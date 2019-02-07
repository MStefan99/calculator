package com.annushkaproject.programmerscalculator;

public class CalculationModel {

    private Value firstValue;
    private Value secondValue;
    private Operator operator;

    public CalculationModel() {
        this.firstValue = null;
        this.secondValue = null;
        this.operator = null;
    }

    //getters
    public Value getFirstValue() {
        return this.firstValue;
    }

    public Value getSecondValue() {
        return this.secondValue;
    }

    public Operator getOperator() {
        return this.operator;
    }

    //setters
    public void setFirstValue(double value) {
        this.firstValue = new Value(value);
    }

    public void setSecondValue(double value) {
        this.secondValue = new Value(value);
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    //reset methods
    public void resetFirstValue() {
        this.firstValue = null;
    }

    public void resetSecondValue() {
        this.secondValue = null;
    }

    public void resetOperator() {
        this.operator = null;
    }

    public void resetCalcState() {
        resetFirstValue();
        resetSecondValue();
        resetOperator();
    }

}

