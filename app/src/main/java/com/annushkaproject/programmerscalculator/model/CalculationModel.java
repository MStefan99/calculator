package com.annushkaproject.programmerscalculator.model;

public class CalculationModel {

    private Value firstValue;
    private Value secondValue;
    private Operator operator;

    public CalculationModel() {
        firstValue = null;
        secondValue = null;
        operator = null;
    }

    //getters
    public Value getFirstValue() {
        return firstValue;
    }

    public Value getSecondValue() {
        return secondValue;
    }

    public Operator getOperator() {
        return operator;
    }

    //setters
    //TODO: remove
    public void setFirstValue(double value) {
        firstValue = new Value(value);
    }

    //TODO: remove
    public void setSecondValue(double value) {
        secondValue = new Value(value);
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

    public boolean isNotNumber() {
        return (operator == Operator.DIVIDE && secondValue.getNumber() == 0) ||
                (operator == Operator.DENOMINATOR && firstValue.getNumber() == 0);
    }

}

