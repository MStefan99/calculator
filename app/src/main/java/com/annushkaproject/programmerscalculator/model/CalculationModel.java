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
        return firstValue;
    }

    public Value getSecondValue() {
        return secondValue;
    }

    public Operator getOperator() {
        return operator;
    }

    public WordLength getWordLength() {
        return wordLength;
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

    public void setWordLength(WordLength wordLength) {
        this.wordLength = wordLength;
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

}

