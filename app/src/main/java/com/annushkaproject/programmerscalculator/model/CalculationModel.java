package com.annushkaproject.programmerscalculator.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CalculationModel {

    private BigDecimal firstValue;
    private BigDecimal secondValue;
    private Operator operator;

    public CalculationModel() {
        firstValue = null;
        secondValue = null;
        operator = null;
    }

    public CalculationModel(BigDecimal firstValue, Operator operator) {
        this.firstValue = firstValue;
        this.operator = operator;
    }

    public CalculationModel(BigDecimal firstValue, BigDecimal secondValue, Operator operator) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operator = operator;
    }

    //getters
    public BigDecimal getFirstValue() {
        return firstValue;
    }

    public BigDecimal getSecondValue() {
        return secondValue;
    }

    public Operator getOperator() {
        return operator;
    }

    //setters
    //TODO: remove
    public void setFirstValue(double value) {
        firstValue = BigDecimal.valueOf(value);
    }

    //TODO: remove
    public void setSecondValue(double value) {
        secondValue = BigDecimal.valueOf(value);
    }

    public void setSecondValueEqualToFirst() {
        //Adding ZERO to get new BigDecimal number for the second value
        secondValue = firstValue.add(BigDecimal.ZERO);
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    //reset state
    //TODO: make private
    public void resetCalcState() {
        firstValue = null;
        secondValue = null;
        operator = null;
    }

    //update states
    public void updateValues(String text) {
        if (operator == null) {
            setFirstValue(Double.parseDouble(text));
        } else {
            setSecondValue(Double.parseDouble(text));
        }
    }

    public void updateAfterCalculation(double calculationResult) {
        resetCalcState();
        setFirstValue(calculationResult);
    }

    public String textForValue(double value) {
        boolean isWholeValue = value % 1 == 0;

        return isWholeValue ? String.format("%.0f", value) : (Double.toString(value));
    }

    //TODO: rename method
    public boolean isNotNumber() {
        return (operator == Operator.DIVIDE && secondValue.doubleValue() == 0) ||
                (operator == Operator.DENOMINATOR && firstValue.doubleValue() == 0);
    }

    public boolean isFirstIntegerValue() {
        return firstValue.stripTrailingZeros().scale() <= 0;
    }

}

