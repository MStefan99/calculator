package com.annushkaproject.programmerscalculator.utils;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Operator;

import java.math.BigDecimal;

public class StandardOperationsUtil {

    public static double calculateResultForTwoSidedOperator(CalculationModel data) {
        if (data.getSecondValue() == null) {
            data.setSecondValueEqualToFirst();
        }

        if (!data.getOperator().requiresTwoValues()) {
            return -1; //TODO: throw an exception.
        }

        double result;
        switch (data.getOperator()) {
            case ADD:
                result = data.getFirstValue().add(data.getSecondValue()).doubleValue();
                break;
            case SUBTRACT:
                result = data.getFirstValue().subtract(data.getSecondValue()).doubleValue();
                break;
            case MULTIPLY:
                result = data.getFirstValue().multiply(data.getSecondValue()).doubleValue();
                break;
            case DIVIDE:
                result = data.getFirstValue().divide(data.getSecondValue()).doubleValue();
                break;
            case POWER:
                result = data.getFirstValue().pow(data.getSecondValue().intValue()).doubleValue();
                break;

            default:
                //TODO: throw exception or crush the app.
                return 0;
        }

        return result;
    }

    public static double calculatePercentForData(CalculationModel data) {
        if (data.getSecondValue() == null) {
            return -1; //TODO: throw an exception.
        }

        double firstNumber = data.getFirstValue().doubleValue();
        double secondNumber = data.getSecondValue().doubleValue();

        double result = firstNumber / 100.0 * secondNumber;

        return result;
    }

    public static double calculateResultForOneSidedOperator(double number, Operator operator) {
        if (operator.requiresTwoValues()) {
            return -1; //TODO: throw an exception.
        }

        switch (operator) {
            case PERCENT:
                return number / 100.0; //TODO: change to BigDecimal
            case ASIN:
                return Math.asin(number);
            case ACOS:
                return Math.acos(number);
            case ATAN:
                return Math.atan(number);
            case SIN:
                return Math.sin(number);
            case COS:
                return Math.cos(number);
            case TAN:
                return Math.tan(number);
            case LN:
                return Math.log(number);
            case LOG:
                return Math.log10(number);
            case DENOMINATOR:
                return 1.0 / number; //TODO: change to BigDecimal
            case EXPONENT_POWER:
                return Math.exp(number);
            case SQUARE:
                return number * number;
            case ABS:
                return Math.abs(number);
            case SQUARE_ROOT:
                return Math.sqrt(number);
            case FACTORIAL:
                return StandardOperationsUtil.calculateFactorial(number);

            default:
                //TODO: throw exception or crush the app.
                return 0;
        }
    }

    static private double calculateFactorial(double value) {
        double result = 1;

        for (int i = 2; i <= value; i++) {
            result *= i;
        }

        return result;
    }

}
