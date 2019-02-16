package com.annushkaproject.programmerscalculator.utils;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Operator;

public class StandardOperationsUtil {

    public static double calculateWithData(CalculationModel data) {
        if (data.getOperator().requiresTwoValues() && data.getSecondValue() == null) {
            if (data.getOperator() == Operator.ADD || data.getOperator() == Operator.SUBTRACT) {
                data.setSecondValue(0);
            } else {
                data.setSecondValue(1);
            }
        }

        return StandardOperationsUtil.calculateResult(data);
    }

    private static double calculateResult(CalculationModel data) {
        switch (data.getOperator()) {
            case ADD:
                return data.getFirstValue().getNumber() + data.getSecondValue().getNumber();
            case SUBTRACT:
                return data.getFirstValue().getNumber() - data.getSecondValue().getNumber();
            case MULTIPLY:
                return data.getFirstValue().getNumber() * data.getSecondValue().getNumber();
            case DIVIDE:
                return data.getFirstValue().getNumber() / data.getSecondValue().getNumber();
            case PERCENT:
                return data.getFirstValue().getNumber() / 100.0;

            default:
                //TODO: throw exception or crush the app.
                return 0;
        }
    }

}
