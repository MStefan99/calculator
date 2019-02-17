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
import android.widget.RadioGroup;
import android.widget.TextView;

import com.annushkaproject.programmerscalculator.R;
import com.annushkaproject.programmerscalculator.model.Mode;
import com.annushkaproject.programmerscalculator.model.Operator;
import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.WordLength;
import com.annushkaproject.programmerscalculator.utils.InstanceStateUtil;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

public class ProgrammerFragment extends Fragment {

    private TextView textView;
    private ProgrammerCalcModel calcModel = new ProgrammerCalcModel();
    private boolean secondValueInputStarted = false;
    private String packageName;
    private WordLength wordLength = WordLength.QWORD;
    private Mode mode = Mode.DEC;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME");
            calcModel = InstanceStateUtil.restoreProgrammerSavedInstance(savedInstanceState);
        }
        return inflater.inflate(R.layout.fragment_programmer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = getView().findViewById(R.id.inputField);

        setupNumberButtons();
        setupOperatorButtons();
        setupLetterButtons();
        setupCalculateButton();
        setupDeleteButton();
        //setupClearButton(); TODO: add clear button
        setupSignButton();
        setupModeRadio();
        setupWordLengthButton();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        InstanceStateUtil.saveInstanceState(outState, calcModel, packageName);
    }

    public void setupFragment(String packageName) {
        this.packageName = packageName;
    }

    private void setupNumberButtons() {
        for (int i = 0; i < 10; i++) {
            Button button = getView().findViewById(getResources().getIdentifier("button" + i,
                    "id", packageName));
            button.setOnClickListener((v) -> {
                usePressedNumber(((Button)v).getText().toString());
            });
        }
    }

    private void setupLetterButtons() {
        int[] letterButtonIDs = new int[]{R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD,
                R.id.buttonE, R.id.buttonF};
        for (int buttonID : letterButtonIDs) {
            Button button = getView().findViewById(buttonID);
            button.setOnClickListener((v) -> {
                System.out.println(button.getText().toString());
                usePressedNumber(((Button)v).getText().toString());
            });
        }
    }

    private void setupOperatorButtons() {
        int[] operatorButtonIDs = new int[]{R.id.buttonMod, R.id.buttonXOR, R.id.buttonOR, R.id.buttonAND,
                R.id.buttonLSH, R.id.buttonRSH, R.id.buttonNOT, R.id.buttonDivide, R.id.buttonMultiply,
                R.id.buttonMinus, R.id.buttonPlus};
        for (int buttonID : operatorButtonIDs) {
            Button button = getView().findViewById(buttonID);
            button.setOnClickListener((v) -> {
                Operator operator = Operator.operatorForTitle(button.getText().toString());
                usePressedOperator(operator);
            });
        }
    }

    private void setupCalculateButton() {
        Button equalsButton = getView().findViewById(R.id.buttonEquals);
        equalsButton.setOnClickListener(v -> {
            Button button = (Button)v;
            System.out.println(button.getText().toString());
            useEqualsOperator();
        });
    }

    private void setupDeleteButton() {
        Button delButton = getView().findViewById(R.id.buttonDel);
        delButton.setOnClickListener(v -> {
            String currentString = currentString();
            if (!currentString.equals("-") && currentString.length() > 1) {
                currentString = currentString.substring(0, currentString.length() - 1);
                updateText(currentString);
            } else {
                updateText(calcModel.textForValue(0.0));
            }
        });
    }

    public void setupSignButton() {
        Button signButton = getView().findViewById(R.id.buttonSign);
        signButton.setOnClickListener(v -> {
            long currentValue = Long.parseLong(currentString(), mode.getBase());

            if (currentValue == 0) { //do not make "-0"
                return;
            }

            String updatedString = formatText(currentValue);
            if (currentValue > 0) {
                updatedString = "-" + updatedString;
            } else {
                updatedString = updatedString.substring(1);
            }

            updateText(updatedString);
        });
    }

    public void setupWordLengthButton() {
        Button modeButton = getView().findViewById(R.id.buttonLength);
        modeButton.setOnClickListener(v -> {
            long val = Long.parseLong(currentString(), mode.getBase());
            if (wordLength.ordinal() < 3) {
                int num = wordLength.ordinal();
                wordLength = WordLength.values()[++num];
            } else {
                wordLength = WordLength.QWORD;
            }
            switch (wordLength) {
                case DWORD:
                    val = (int) val;
                    break;
                case WORD:
                    val = (short) val;
                    break;
                case BYTE:
                    val = (byte) val;
            }
            calcModel.setWordLength(wordLength);
            updateText(formatText(val));
            Log.d("LengthChanged", "Length button pressed, current value: " + wordLength.toString());
            modeButton.setText(wordLength.toString());
        });
    }

    public void setupModeRadio() {
        RadioGroup radioGroup = getView().findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((v, id) -> {
            long number = Long.parseLong(textView.getText().toString(), mode.getBase());
            switch (id) {
                case R.id.radioButtonHex:
                    mode = Mode.HEX;
                    break;
                case R.id.radioButtonDec:
                    mode = Mode.DEC;
                    break;
                case R.id.radioButtonOct:
                    mode = Mode.OCT;
                    break;
                case R.id.radioButtonBin:
                    mode = Mode.BIN;
                    break;
            }
            updateText(formatText(number));
            Log.d("ModeChanged", "Mode radio pressed, current value: " + mode.toString());
        });
    }

    private String currentString() {
        return textView.getText().toString();
    }

    private void usePressedNumber(String number) {
        if (currentString().equals("0") && !number.equals(".")) {
            textView.setText(""); //clear text view from 0 value.
        }

        String newString;
        if (secondValueInputStarted) {
            newString = number;
            secondValueInputStarted = false;
        } else {
            newString = textView.getText().toString() + number;
        }

        updateText(newString);
    }

    private void usePressedOperator(Operator operator) {
        boolean readyToSaveOperator = calcModel.getFirstValue() != null;
        if (!readyToSaveOperator) {
            return;
        }

        boolean readyToCalcOneSide = !operator.requiresTwoValues() &&
                calcModel.getFirstValue() != null;
        if (readyToCalcOneSide) {
            calcModel.setOperator(operator);
            calculateResult();
            return;
        }

        boolean readyToCalcTwoSides = calcModel.getOperator() != null &&
                calcModel.getFirstValue() != null &&
                calcModel.getSecondValue() != null;
        if (readyToCalcTwoSides) {
            calculateResult();
        } else {
            secondValueInputStarted = true;
        }

        calcModel.setOperator(operator);
    }

    private void useEqualsOperator() {
        if (calcModel.getOperator() == null) {
            return;
        }

        calculateResult();
    }

    private void calculateResult() {
        long result = ProgrammerOperationsUtil.calculateWithData(calcModel);

        calcModel.resetCalcState();

        calcModel.updateAfterCalculation(result);
        updateText(formatText(result));

        secondValueInputStarted = true;
    }

    public String formatText(long number) {
        return Long.toString(number, mode.getBase()).toUpperCase();
    }

    private void updateText(String updatedText) {
        textView.setText(updatedText);
        calcModel.updateValues(updatedText, mode);
    }

    private void setTextViewValue(Double value) {
        boolean isWholeValue = value % 1 == 0;

        if (isWholeValue) {
            textView.setText(String.format("%.0f", value));
        } else {
            textView.setText(Double.toString(value));
        }
    }
}
