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
import com.annushkaproject.programmerscalculator.model.Operator;
import com.annushkaproject.programmerscalculator.utils.CalculationUtil;

public class ProgrammerFragment extends Fragment {

    private TextView textView;
    private CalculationUtil buttonUtil = new CalculationUtil();

    private String packageName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME");
            if (savedInstanceState.getBoolean("FIRST_VALUE_SAVED")) {
                buttonUtil.getCalcModel().setFirstValue(savedInstanceState.getDouble("FIRST_VALUE"));
            }
            if (savedInstanceState.getBoolean("OPERATOR_SAVED")) {
                buttonUtil.getCalcModel().setOperator(Operator.getOperatorByNumber(savedInstanceState.getInt("OPERATOR")));
            }
            if (savedInstanceState.getBoolean("SECOND_VALUE_SAVED")) {
                buttonUtil.getCalcModel().setSecondValue(savedInstanceState.getDouble("SECOND_VALUE"));
            }
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
        outState.putString("PACKAGE_NAME", packageName);
        boolean firstValuePresent = buttonUtil.getCalcModel().getFirstValue() != null;
        boolean operatorPresent = buttonUtil.getCalcModel().getOperator() != null;
        boolean secondValuePresent = buttonUtil.getCalcModel().getSecondValue() != null;
        if (firstValuePresent) {
            outState.putDouble("FIRST_VALUE", buttonUtil.getCalcModel().getFirstValue().getNumber());
        }
        if (operatorPresent) {
            outState.putInt("OPERATOR", Operator.getNumberByOperator(buttonUtil.getCalcModel().getOperator()));
        }
        if (secondValuePresent) {
            outState.putDouble("SECOND_VALUE", buttonUtil.getCalcModel().getSecondValue().getNumber());
        }
        outState.putBoolean("FIRST_VALUE_SAVED", firstValuePresent);
        outState.putBoolean("OPERATOR_SAVED", operatorPresent);
        outState.putBoolean("SECOND_VALUE_SAVED", secondValuePresent);
    }

    public void setupFragment(String packageName) {
        this.packageName = packageName;
    }

    private void setupNumberButtons() {
        for (int i = 0; i < 10; i++) {
            Button button = getView().findViewById(getResources().getIdentifier("button" + i,
                    "id", packageName));
            button.setOnClickListener((v) -> {
                System.out.println(((Button)v).getText().toString());
                // TODO: handle button clicks
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
                System.out.println(button.getText().toString());
                // TODO: handle button clicks
            });
        }
    }

    private void setupCalculateButton() {
        Button equalsButton = getView().findViewById(R.id.buttonEquals);
        equalsButton.setOnClickListener(v -> {
            Button button = (Button)v;
            System.out.println(button.getText().toString());
            // TODO: handle button clicks
        });
    }

    private void setupDeleteButton() {
        Button delButton = getView().findViewById(R.id.buttonDel);
        delButton.setOnClickListener(v -> {
            System.out.println(delButton.getText().toString());
            // TODO: handle button clicks
        });
    }

    public void setupSignButton() {
        Button signButton = getView().findViewById(R.id.buttonSign);
        signButton.setOnClickListener(v -> {
            System.out.println(signButton.getText().toString());
            // TODO: handle button clicks
        });
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
