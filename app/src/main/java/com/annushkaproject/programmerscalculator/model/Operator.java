package com.annushkaproject.programmerscalculator.model;

public enum Operator {
    ADD,
    SUBSTRUCT,
    MULTIPLY,
    DIVIDE,
    PERCENT,
    UNKNOWN;

    public static Operator operatorForTitle(String title) {
        switch (title) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBSTRUCT;
            case "×":
                return Operator.MULTIPLY;
            case "÷":
                return Operator.DIVIDE;
            case "%":
                return Operator.PERCENT;

                default:
                    return Operator.UNKNOWN;
        }
    }

    public boolean requiresTwoValues() {
        switch (this) {
            case ADD:
            case SUBSTRUCT:
            case MULTIPLY:
            case DIVIDE:
                return true;

            default:
                return false;
        }
    }

    public static int getNumberByOperator(Operator operator) {
        switch (operator) {
            case ADD:
                return 0;
            case SUBSTRUCT:
                return 1;
            case MULTIPLY:
                return 2;
            case DIVIDE:
                return 3;
            case PERCENT:
                return 4;
            default:
                return -1;
        }
    }

    public static Operator getOperatorByNumber(int number) {
        switch (number) {
            case -1:
                return UNKNOWN;
            case 0:
                return ADD;
            case 1:
                return SUBSTRUCT;
            case 2:
                return MULTIPLY;
            case 3:
                return DIVIDE;
            case 4:
                return PERCENT;
            default:
                return UNKNOWN;
        }
    }
}

