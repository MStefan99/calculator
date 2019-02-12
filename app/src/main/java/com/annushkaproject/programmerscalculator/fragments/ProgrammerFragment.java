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

import java.util.ArrayList;

public class ProgrammerFragment extends Fragment {

    private TextView textView;
    private ArrayList<Button> numberButtons = new ArrayList<>();
    private ArrayList<Button> operatorButtons = new ArrayList<>();

    private CalculationModel calcModel = new CalculationModel();
    private boolean secondValueInputStarted = false;
    private boolean secondValueInputInProgress = false;

    private String packageName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME");
            if (savedInstanceState.getBoolean("FIRST_VALUE_SAVED")) {
                calcModel.setFirstValue(savedInstanceState.getDouble("FIRST_VALUE"));
            }
            if (savedInstanceState.getBoolean("OPERATOR_SAVED")) {
                calcModel.setOperator(Operator.getOperatorByNumber(savedInstanceState.getInt("OPERATOR")));
            }
            if (savedInstanceState.getBoolean("SECOND_VALUE_SAVED")) {
                calcModel.setSecondValue(savedInstanceState.getDouble("SECOND_VALUE"));
            }
        }
        return inflater.inflate(R.layout.fragment_standard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = getView().findViewById(R.id.inputField);

        fillNumberButtons();
        fillOperatorButtons();

        setupCalculateButton();
        setupDeleteButton();
        setupClearButton();
        setupSignButton();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("PACKAGE_NAME", packageName);
        boolean firstValuePresent = calcModel.getFirstValue() != null;
        boolean operatorPresent = calcModel.getOperator() != null;
        boolean secondValuePresent = calcModel.getSecondValue() != null;
        if (firstValuePresent) {
            outState.putDouble("FIRST_VALUE", calcModel.getFirstValue().getNumber());
        }
        if (operatorPresent) {
            outState.putInt("OPERATOR", Operator.getNumberByOperator(calcModel.getOperator()));
        }
        if (secondValuePresent) {
            outState.putDouble("SECOND_VALUE", calcModel.getSecondValue().getNumber());
        }
        outState.putBoolean("FIRST_VALUE_SAVED", firstValuePresent);
        outState.putBoolean("OPERATOR_SAVED", operatorPresent);
        outState.putBoolean("SECOND_VALUE_SAVED", secondValuePresent);
    }

    public void setupFragment(String packageName) {
        this.packageName = packageName;
    }


    private void fillNumberButtons() {
        for (int i = 0; i < 10; i++) {
            Button button = getView().findViewById(getResources().getIdentifier("button" + i,
                    "id", packageName));
            button.setOnClickListener(v -> {
                Button button1 = (Button)v;
                System.out.println(button1.getText().toString());
                usePressedNumber(button1.getText().toString());
            }
            );

            numberButtons.add(button);
        }
    }

    private void fillLetterButtons() {
        int[] letterButtons = new int[] {R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD,
                R.id.buttonE, R.id.buttonF};
        for (int button : letterButtons) {
            getView().findViewById(button).setOnClickListener((v) -> {
                Button buttonToSet = (Button)v;
                System.out.println(buttonToSet.getText().toString());
                usePressedNumber(buttonToSet.getText().toString());
            });
        }
    }

    private void usePressedNumber(String number) {
        if (currentString().equals("0") && !number.equals(".")) {
            textView.setText(""); //clear text view from 0 value.
        }

        String newString;
        if (secondValueInputStarted) {
            newString = number;
            secondValueInputStarted = false;
            secondValueInputInProgress = true;
        } else {
            newString = textView.getText().toString() + number;
        }

        textView.setText(newString);

        if (secondValueInputInProgress) {
            calcModel.setSecondValue(Double.parseDouble(textView.getText().toString()));
        } else {
            calcModel.setFirstValue(Double.parseDouble(textView.getText().toString()));
        }
    }

    private void fillOperatorButtons() {
        int[] operatorButtons = new int[] {R.id.buttonMod, R.id.buttonXOR, R.id.buttonOR,
            R.id.buttonAND, R.id.buttonLSH, R.id.buttonRSH, R.id.buttonNOT, R.id.buttonDivide,
            R.id.buttonMultiply, R.id.buttonMinus, R.id.buttonPlus};
        for (int button : operatorButtons) {
            getView().findViewById(button).setOnClickListener((v) -> {
                Button buttonToSet = (Button)v;
                System.out.println(buttonToSet.getText().toString());
                usePressedNumber(buttonToSet.getText().toString());
            });
        }
    }

    private void usePressedOperator(Operator operator) {
        boolean readyToCalcOneSide = calcModel.getOperator() != null && !calcModel.getOperator().requiresTwoValues() && calcModel.getFirstValue() != null;
        boolean readyToCalcTwoSides = calcModel.getOperator() != null && calcModel.getFirstValue() != null && calcModel.getSecondValue() != null;
        if (readyToCalcOneSide || readyToCalcTwoSides) {
            calculateResult();
        }

        calcModel.setOperator(operator);

        if (operator == Operator.PERCENT) {
            calculateResult();
        } else {
            secondValueInputStarted = true;
        }
    }



}
