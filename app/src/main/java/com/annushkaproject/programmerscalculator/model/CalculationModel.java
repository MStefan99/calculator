package com.annushkaproject.programmerscalculator.model;
import java.math.BigDecimal;

public class CalculationModel { private BigDecimal firstValue; private BigDecimal secondValue; private Operator operator; 
    public CalculationModel() { firstValue = null; secondValue = null; operator = null; } 
    public CalculationModel(BigDecimal firstValue, Operator operator) { this.firstValue = firstValue; this.operator = operator; } 
    public CalculationModel(BigDecimal firstValue, BigDecimal secondValue, Operator operator) {
        this.firstValue = firstValue; this.secondValue = secondValue; this.operator = operator;
    }
    public BigDecimal getFirstValue() { return firstValue; }
    public BigDecimal getSecondValue() { return secondValue; } 
    public Operator getOperator() { return operator; }
    public void setFirstValue(double value) { firstValue = BigDecimal.valueOf(value); }
    public void setSecondValue(double value) { secondValue = BigDecimal.valueOf(value); }
    public void setSecondValueEqualToFirst() { secondValue = firstValue.add(BigDecimal.ZERO); } 
    public void setOperator(Operator operator) { this.operator = operator; }
    public void resetCalcState() { firstValue = null; secondValue = null; operator = null; }
    public void updateValues(String text) {
        if (operator == null) { setFirstValue(Double.parseDouble(text)); } else { setSecondValue(Double.parseDouble(text)); }
    }
    public void updateAfterCalculation(double calculationResult) { resetCalcState(); setFirstValue(calculationResult); }
    public String textForValue(double value) {
        boolean isWholeValue = value % 1 == 0;
        return isWholeValue ? String.format("%.0f", value) : (Double.toString(value));
    }
    public boolean isNotNumber() {
        return (operator == Operator.remainder_divide && secondValue.doubleValue() == 0) ||
                (operator == Operator.DENOMINATOR && firstValue.doubleValue() == 0);
    }
    public boolean isFirstIntegerValue() { return firstValue.stripTrailingZeros().scale() <= 0; }
}

