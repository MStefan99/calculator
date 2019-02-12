package com.annushkaproject.programmerscalculator.utils;

import android.widget.TextView;
import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Operator;

public class CalculationUtil {

    private CalculationModel calcModel = new CalculationModel();
    private boolean secondValueInputStarted = false;
    private boolean secondValueInputInProgress = false;

    public CalculationModel getCalcModel() {
        return calcModel;
    }

    private String currentString(TextView textView) {
        return textView.getText().toString();
    }

    public void usePressedNumber(String number, TextView textView) {
        if (currentString(textView).equals("0") && !number.equals(".")) {
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

    public void usePressedOperator(Operator operator, TextView textView) {
        boolean readyToCalcOneSide = calcModel.getOperator() != null && !calcModel.getOperator().requiresTwoValues() && calcModel.getFirstValue() != null;
        boolean readyToCalcTwoSides = calcModel.getOperator() != null && calcModel.getFirstValue() != null && calcModel.getSecondValue() != null;
        if (readyToCalcOneSide || readyToCalcTwoSides) {
            calculateResult(textView);
        }

        calcModel.setOperator(operator);

        if (operator == Operator.PERCENT) {
            calculateResult(textView);
        } else {
            secondValueInputStarted = true;
        }
    }

    public void useEqualsOperator(TextView textView) {
        if (calcModel.getOperator() == null) {
            return;
        }

        calculateResult(textView);
    }

    public void calculateResult(TextView textView) {
        double result = StandardOperationsUtil.calculateWithData(calcModel);
        setTextViewValue(result, textView);

        calcModel.resetCalcState();
        secondValueInputInProgress = false;

        calcModel.setFirstValue(result);
    }

    public void setTextViewValue(Double value, TextView textView) {
        boolean isWholeValue = value % 1 == 0;

        if (isWholeValue) {
            textView.setText(String.format("%.0f", value));
        } else {
            textView.setText(Double.toString(value));
        }
    }

}
