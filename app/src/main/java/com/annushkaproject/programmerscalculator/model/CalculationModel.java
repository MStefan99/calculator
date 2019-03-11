package com.annushkaproject.programmerscalculator.model;

/**
 * Used to contain current state of the calculator.
 */
import java.math.BigDecimal;

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

    /**
     * Used to get the first value of the model.
     * @return Returns the first value of the model.
     */
    public BigDecimal getFirstValue() {
        return firstValue;
    }

    /**
     * Used to get the second value of the model.
     * @return Returns the second value of the model.
     */
    public BigDecimal getSecondValue() {
        return secondValue;
    }

    /**
     * Used to get the operator stored in the model.
     * @return Returns the operator.
     */
    public Operator getOperator() {
        return operator;
    }

    //setters
    //TODO: remove

    /**
     * Used to set the first value of the model.
     * @param value Value to set.
     */
    public void setFirstValue(double value) {
        firstValue = BigDecimal.valueOf(value);
    }

    //TODO: remove

    /**
     * Used to set the second value of the model.
     * @param value Value to set.
     */
    public void setSecondValue(double value) {
        secondValue = BigDecimal.valueOf(value);
    }

    /**
     * Used to set the second value same as the first one.
     */
    public void setSecondValueEqualToFirst() {
        //Adding ZERO to get new BigDecimal number for the second value
        secondValue = firstValue.add(BigDecimal.ZERO);
    }

    /**
     * Used to set the operator of the model.
     * @param operator Operator to set.
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    //reset state
    //TODO: make private

    /**
     * Used to reset the model state.
     */
    public void resetCalcState() {
        firstValue = null;
        secondValue = null;
        operator = null;
    }

    //update states

    /**
     * Used to set a value of the model.
     * @param text Value as a text.
     */
    public void updateValues(String text) {
        if (operator == null) {
            setFirstValue(Double.parseDouble(text));
        } else {
            setSecondValue(Double.parseDouble(text));
        }
    }

    /**
     * Used to get the model ready for the next calculation.
     * @param calculationResult Result of previous calculation.
     */
    public void updateAfterCalculation(double calculationResult) {
        resetCalcState();
        setFirstValue(calculationResult);
    }

    /**
     * Used to format number for display.
     * @param value Number to format.
     * @return Formatted text.
     */
    public String textForValue(double value) {
        boolean isWholeValue = value % 1 == 0;

        return isWholeValue ? String.format("%.0f", value) : (Double.toString(value));
    }

    /**
     * Used to check if calculation result is not a number.
     * @return True if the result is not a number.
     */
    //TODO: rename method
    public boolean isNotNumber() {
        return (operator == Operator.DIVIDE && secondValue.doubleValue() == 0) ||
                (operator == Operator.DENOMINATOR && firstValue.doubleValue() == 0);
    }

    /**
     * Used to check if first value is an integer number.
     * @return True if the first value is an integer.
     */
    public boolean isFirstIntegerValue() {
        return firstValue.stripTrailingZeros().scale() <= 0;
    }

}

