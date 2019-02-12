package com.annushkaproject.programmerscalculator.model;

public enum Operator {
    ADD,
    SUBSTRUCT,
    MULTIPLY,
    DIVIDE,
    PERCENT,
    CHANGE_SIGN,
    LSH,
    RSH,
    NOT,
    OR,
    XOR,
    AND,
    MOD,
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
            case OR:
            case AND:
            case LSH:
            case RSH:
            case XOR:
            case MOD:
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
            case CHANGE_SIGN:
                return 5;
            case LSH:
                return 6;
            case RSH:
                return 7;
            case NOT:
                return 8;
            case OR:
                return 9;
            case XOR:
                return 10;
            case AND:
                return 11;
            case MOD:
                return 12;
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
            case 5:
                return CHANGE_SIGN;
            case 6:
                return LSH;
            case 7:
                return RSH;
            case 8:
                return NOT;
            case 9:
                return OR;
            case 10:
                return XOR;
            case 11:
                return AND;
            case 12:
                return MOD;
            default:
                return UNKNOWN;
        }
    }
}

