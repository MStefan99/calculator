package com.annushkaproject.programmerscalculator.utils;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Operator;

public class StandardOperationsUtil {

//    public static double calculateWithData(CalculationModel data) {
//        if (data.getOperator().requiresTwoValues() && data.getSecondValue() == null) {
//            data.setSecondValue(data.getFirstValue().getNumber());
//        }
//
//        double result;
//        if (data.getOperator().requiresTwoValues()) {
//            result = StandardOperationsUtil.calculateResultForTwoSidedOperator(data);
//        } else {
//            result = StandardOperationsUtil.calculateResultForOneSidedOperator(data);
//        }
//
//        return result;
//    }

    public static double calculateResultForTwoSidedOperator(CalculationModel data) {
        if (data.getSecondValue() == null) {
            data.setSecondValue(data.getFirstValue().getNumber());
        }

        if (!data.getOperator().requiresTwoValues()) {
            return -1; //TODO: throw an exception.
        }

        switch (data.getOperator()) {
            case ADD:
                return data.getFirstValue().getNumber() + data.getSecondValue().getNumber();
            case SUBTRACT:
                return data.getFirstValue().getNumber() - data.getSecondValue().getNumber();
            case MULTIPLY:
                return data.getFirstValue().getNumber() * data.getSecondValue().getNumber();
            case DIVIDE:
                return data.getFirstValue().getNumber() / data.getSecondValue().getNumber();
            case POWER:


            default:
                //TODO: throw exception or crush the app.
                return 0;
        }
    }

    public static double calculatePercentForData(CalculationModel data) {
        if (data.getOperator() != Operator.PERCENT || data.getSecondValue() == null) {
            return -1; //TODO: throw an exception.
        }

        double firstNumber = data.getFirstValue().getNumber();
        double secondNumber = data.getSecondValue().getNumber();

        return firstNumber / 100.0 * secondNumber;
    }

    public static double calculateResultForOneSidedOperator(double number, Operator operator) {
        if (operator.requiresTwoValues()) {
            return -1; //TODO: throw an exception.
        }

        switch (operator) {
            case PERCENT:
                return number / 100.0;
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
                return 1.0 / number;
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
