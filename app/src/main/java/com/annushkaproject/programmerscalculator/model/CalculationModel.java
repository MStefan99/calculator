package com.annushkaproject.programmerscalculator.model;

public class CalculationModel {

    private Value firstValue;
    private Value secondValue;
    private Operator operator;
    private WordLength wordLength;

    public CalculationModel() {
        this.firstValue = null;
        this.secondValue = null;
        this.operator = null;
        this.wordLength = WordLength.QWORD;
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

    public WordLength getWordLength() {
        return wordLength;
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

    public void setWordLength(WordLength wordLength) {
        this.wordLength = wordLength;
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

