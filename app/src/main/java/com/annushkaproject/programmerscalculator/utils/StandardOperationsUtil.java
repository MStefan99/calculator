package com.annushkaproject.programmerscalculator.utils;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Operator;

public class StandardOperationsUtil {

    public static double calculateWithData(CalculationModel data) {
        if (data.getOperator().requiresTwoValues() && data.getSecondValue() == null) {
            data.setSecondValue(data.getFirstValue().getNumber());
        }

        double result;
        if (data.getOperator().requiresTwoValues()) {
            result = StandardOperationsUtil.calculateResultForTwoSidedOperator(data);
        } else {
            result = StandardOperationsUtil.calculateResultForOneSidedOperator(data);
        }

        return result;
    }

    private static double calculateResultForTwoSidedOperator(CalculationModel data) {
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

    private static double calculateResultForOneSidedOperator(CalculationModel data) {
        if (data.getOperator().requiresTwoValues()) {
            return -1; //TODO: throw an exception.
        }

        switch (data.getOperator()) {
            case PERCENT:
                return data.getFirstValue().getNumber() / 100.0;
            case ASIN:
                return Math.asin(data.getFirstValue().getNumber());
            case ACOS:
                return Math.acos(data.getFirstValue().getNumber());
            case ATAN:
                return Math.atan(data.getFirstValue().getNumber());
            case SIN:
                return Math.sin(data.getFirstValue().getNumber());
            case COS:
                return Math.cos(data.getFirstValue().getNumber());
            case TAN:
                return Math.tan(data.getFirstValue().getNumber());
            case LN:
                return Math.log(data.getFirstValue().getNumber());
            case LOG:
                return Math.log10(data.getFirstValue().getNumber());
            case DENOMINATOR:
                return 1.0 / data.getFirstValue().getNumber();
            case EXPONENT_POWER:
                return Math.exp(data.getFirstValue().getNumber());
            case SQUARE:
                return data.getFirstValue().getNumber() * data.getFirstValue().getNumber();
            case ABS:
                return Math.abs(data.getFirstValue().getNumber());
            case SQUARE_ROOT:
                return Math.sqrt(data.getFirstValue().getNumber());
            case FACTORIAL:
                StandardOperationsUtil.calculateFactorial(data.getFirstValue().getNumber());

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
