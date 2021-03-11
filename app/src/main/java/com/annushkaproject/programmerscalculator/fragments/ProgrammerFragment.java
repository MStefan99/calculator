package com.annushkaproject.programmerscalculator.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.annushkaproject.programmerscalculator.R;
import com.annushkaproject.programmerscalculator.model.mode_enum;
import com.annushkaproject.programmerscalculator.model.Operator;
import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.int_size_enum;
import com.annushkaproject.programmerscalculator.utils.InstanceStateUtil;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

public class ProgrammerFragment extends Fragment {

    private TextView textView; private TextView textView2;
    private ProgrammerCalcModel calcModel = new ProgrammerCalcModel();
    private boolean secondValueInputStarted = false;
    private String packageName;
    private int_size_enum bytelengthenum = int_size_enum.l8;
//    private mode_enum modeenum = mode_enum.mode_enum_dec;
    private mode_enum modeenum = mode_enum.mode_enum_heks;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME");
            calcModel = InstanceStateUtil.restoreProgrammerSavedInstance(savedInstanceState);
        }
        return inflater.inflate(R.layout.fragment_programmer, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { super.onViewCreated(view, savedInstanceState);
        textView = getView().findViewById(R.id.inputField); textView2 = getView().findViewById(R.id.inputField2);
        setupNumberButtons();setupOperatorButtons();setupLetterButtons();setupCalculateButton();setupDeleteButton();
        //setupClearButton(); TODO: add clear button
        setupSignButton();
//        setupModeRadio();
        setup_heks_cb();setupWordLengthButton();enableButtonsDEC();
    }

    @Override public void onSaveInstanceState(@NonNull Bundle outState) { super.onSaveInstanceState(outState);
        InstanceStateUtil.saveInstanceState(outState, calcModel, packageName);
    }

    public void setupFragment(String packageName) {
        this.packageName = packageName;
    }

    private void setupNumberButtons() {
        for (int i = 0; i < 10; i++) {
            Button button = getView().findViewById(getResources().getIdentifier("button" + i, "id", packageName));
            button.setOnClickListener((v) -> { usePressedNumber(((Button) v).getText().toString()); });
        }
    }

    private void setupLetterButtons() {
        int[] letterButtonIDs = new int[]{R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD, R.id.buttonE, R.id.buttonF};
        for (int buttonID : letterButtonIDs) {
            Button button = getView().findViewById(buttonID);
            button.setOnClickListener((v) -> {
                System.out.println(button.getText().toString()); usePressedNumber(((Button) v).getText().toString());
            });
        }
    }

    private void setupOperatorButtons() {
        int[] operatorButtonIDs = new int[]{R.id.buttonMod, R.id.button_zor, R.id.buttonOR, R.id.buttonAND,
                R.id.buttonLSH, R.id.buttonRSH, R.id.buttonNOT, R.id.buttonRDivide, R.id.buttonMultiply,
                R.id.buttonMinus, R.id.buttonPlus};
        for (int buttonID : operatorButtonIDs) { Button button = getView().findViewById(buttonID);button.setOnClickListener((v) -> {
                Operator operator = Operator.operatorForTitle(button.getText().toString());
                usePressedOperator(operator);
            });
        }
    }

    private void setupCalculateButton() { Button equalsButton = getView().findViewById(R.id.buttonEquals);equalsButton.setOnClickListener(v -> {
            Button button = (Button) v; System.out.println(button.getText().toString());
            useEqualsOperator();
        });
    }

    private void setupDeleteButton() { Button delButton = getView().findViewById(R.id.buttonDel); delButton.setOnClickListener(v -> {
            String currentString = currentString();
            if (!currentString.equals("-") && currentString.length() > 1) {
                currentString = currentString.substring(0, currentString.length() - 1);
                updateText(currentString);
            } else updateText(calcModel.textForValue(0.0));
        });
    }

    private void setupSignButton() { Button signButton = getView().findViewById(R.id.buttonSign);signButton.setOnClickListener(v -> {
            long currentValue = Long.parseLong(currentString(), modeenum.getBase());
            if (currentValue == 0) return;
            String updatedString = formatText(currentValue);
            if (currentValue > 0) updatedString = "-" + updatedString; else updatedString = updatedString.substring(1);
            updateText(updatedString);
        });
    }
    private String currentString() { return textView.getText().toString(); }
    private void setupWordLengthButton() { Button modeButton = getView().findViewById(R.id.buttonLength);modeButton.setOnClickListener(v -> {
            long val = Long.parseLong(currentString(), modeenum.getBase());
            if (bytelengthenum.ordinal() < 3) {
                int num = bytelengthenum.ordinal();
                bytelengthenum = int_size_enum.values()[++num];
            } else bytelengthenum = int_size_enum.l8;
            switch (bytelengthenum) {
                case l4: val = (int) val;break;
                case l2: val = (short) val;break;
                case l1: val = (byte) val;
            }
            calcModel.setBytelengthenum(bytelengthenum);
            updateText(formatText(val));
            Log.d("LengthChanged", "Length button pressed, current value: " + bytelengthenum.toString());
            modeButton.setText(bytelengthenum.toString());
        });
    }

//    private void setupModeRadio() { RadioGroup radioGroup = getView().findViewById(R.id.radioGroup);radioGroup.setOnCheckedChangeListener((v, id) -> {
//            long number = Long.parseLong(textView.getText().toString(), modeenum.getBase());
//            switch (id) {
//                case R.id.radioButtonHex: modeenum = mode_enum.mode_enum_heks; enableButtonsALL(); break;
//                case R.id.radioButtonDec: modeenum = mode_enum.mode_enum_dec; enableButtonsDEC(); break;
//                // case R.id.radioButtonOct: modeenum = mode_enum.OCT; enableButtonsOCT(); break; case R.id.radioButtonBin: modeenum = mode_enum.BIN; enableButtonsBIN(); break;
//            }
//            updateText(formatText(number));
//            Log.d("ModeChanged", "mode_enum radio pressed, current value: " + modeenum.toString());
//        });
//    }
    private void setup_heks_cb() {
        CheckBox heks_cb = getView().findViewById(R.id.heks_check_boks); heks_cb.setOnCheckedChangeListener( (v, id) -> {
            long number = Long.parseLong(textView.getText().toString(), modeenum.getBase());
            if (heks_cb.isChecked()) { modeenum = mode_enum.mode_enum_heks; enableButtonsALL(); }
            else {modeenum = mode_enum.mode_enum_dec; enableButtonsDEC();}
            updateText(formatText(number));
        });
    }
    private void usePressedNumber(String number) {
        if (currentString().equals("0") && !number.equals(".")) { textView.setText(""); textView2.setText(""); }
        String newString;
        if (secondValueInputStarted) { newString = number;secondValueInputStarted = false; }
        else newString = textView.getText().toString() + number;
        updateText(newString);
    }

    private void usePressedOperator(Operator operator) {
        boolean readyToSaveOperator = calcModel.getFirstValue() != null;
        if (!readyToSaveOperator) return;
        boolean readyToCalcOneSide = !operator.requiresTwoValues() && calcModel.getFirstValue() != null;
        if (readyToCalcOneSide) { calcModel.setOperator(operator);calculateResult();return; }
        boolean readyToCalcTwoSides = calcModel.getOperator() != null && calcModel.getFirstValue() != null && calcModel.getSecondValue() != null;
        if (readyToCalcTwoSides) calculateResult(); else secondValueInputStarted = true;
        calcModel.setOperator(operator);
    }

    private void useEqualsOperator() { if (calcModel.getOperator() == null) return;calculateResult(); }
    private void calculateResult() {
        long result = ProgrammerOperationsUtil.calculateWithData(calcModel);
        calcModel.resetCalcState();
        calcModel.updateAfterCalculation(result);
        updateText(formatText(result));
        secondValueInputStarted = true;
    }

    private String formatText(long number) { return Long.toString(number, modeenum.getBase()).toUpperCase(); }

    private void updateText(String updatedText) {
        textView.setText(updatedText); textView2.setText(updatedText);
        if (updatedText.length() > 10) { textView.setTextSize(24); textView2.setTextSize(24); } else { textView.setTextSize(30); textView2.setTextSize(30); }
        calcModel.updateValues(updatedText, modeenum);
    }

    private void setTextViewValue(Double value) {
        boolean isWholeValue = value % 1 == 0;
        if (isWholeValue) {
            textView.setText(String.format("%.0f", value)); textView2.setText(String.format("%.0f", value));
        } else {
            textView.setText(Double.toString(value)); textView2.setText(Double.toString(value));
        }
    }

    private void disableAllButtons() { setNumberButtonsClickable(10, false);setLetterButtonsClickable(false); }
//    private void enableButtonsBIN() { disableAllButtons();setNumberButtonsClickable(2, true); }
//    private void enableButtonsOCT() { disableAllButtons();setNumberButtonsClickable(8, true); }
    private void enableButtonsDEC() { disableAllButtons();setNumberButtonsClickable(10, true); }
    private void enableButtonsALL() { setLetterButtonsClickable(true);setNumberButtonsClickable(10, true); }
    private void setLetterButtonsClickable(boolean mode) {
        int[] letterButtonIDs = new int[]{R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD, R.id.buttonE, R.id.buttonF};
        for (int buttonID : letterButtonIDs) { Button button = getView().findViewById(buttonID);button.setEnabled(mode); }
    }
    private void setNumberButtonsClickable(int range, boolean mode) {
        for (int i = 0; i < range; i++) {
            Button button = getView().findViewById(getResources().getIdentifier("button" + i, "id", packageName));
            button.setEnabled(mode);
        }
    }
}
