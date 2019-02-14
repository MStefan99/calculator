package com.annushkaproject.programmerscalculator.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.annushkaproject.programmerscalculator.R;
import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Operator;
import com.annushkaproject.programmerscalculator.utils.CalculationUtil;
import com.annushkaproject.programmerscalculator.utils.InstanceStateUtil;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

public class ProgrammerFragment extends Fragment {

    private TextView textView;
    private CalculationModel calcModel = new CalculationModel();
    private boolean secondValueInputStarted = false;

    private String packageName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME");
            calcModel = InstanceStateUtil.restoreSavedInstance(savedInstanceState);
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
                // TODO: handle button clicks
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
            if (currentString.length() > 1) {
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
            double currentValue = Double.parseDouble(currentString());

            if (currentValue == 0) { //do not make "-0"
                return;
            }

            String updatedString = currentString();
            if (currentValue > 0) {
                updatedString = "-" + updatedString;
            } else {
                updatedString = updatedString.substring(1);
            }

            updateText(updatedString);
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
        double result = ProgrammerUtil.calculateWithData(calcModel);

        calcModel.resetCalcState();

        calcModel.updateAfterCalculation(result);
        updateText(calcModel.textForValue(result));

        secondValueInputStarted = true;
    }

    private void updateText(String updatedText) {
        textView.setText(updatedText);
        calcModel.updateValues(updatedText);
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
