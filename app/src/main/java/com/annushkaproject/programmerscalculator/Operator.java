package com.annushkaproject.programmerscalculator;

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

}

