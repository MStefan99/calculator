package com.annushkaproject.programmerscalculator.model;

public enum Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    PERCENT,
    ASIN,
    ACOS,
    ATAN,
    SIN,
    COS,
    TAN,
    LN,
    LOG,
    DENOMINATOR,
    EXPONENT_POWER,
    SQUARE,
    POWER,
    ABS,
    SQUARE_ROOT,
    FACTORIAL,
    UNKNOWN;

    public static Operator operatorForTitle(String title) {
        switch (title) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBTRACT;
            case "×":
                return Operator.MULTIPLY;
            case "÷":
                return Operator.DIVIDE;
            case "%":
                return Operator.PERCENT;
            case "sinˉ¹":
                return Operator.ASIN;
            case "cosˉ¹":
                return Operator.ACOS;
            case "tanˉ¹":
                return Operator.ATAN;
            case "sin":
                return Operator.SIN;
            case "cos":
                return Operator.COS;
            case "tan":
                return Operator.TAN;
            case "ln":
                return Operator.LN;
            case "log":
                return Operator.LOG;
            case "1/x":
                return Operator.DENOMINATOR;
            case "eˣ":
                return Operator.EXPONENT_POWER;
            case "x²":
                return Operator.SQUARE;
            case "xʸ":
                return Operator.POWER;
            case "|x|":
                return Operator.ABS;
            case "√":
                return Operator.SQUARE_ROOT;
            case "x!":
                return Operator.FACTORIAL;


                default:
                    return Operator.UNKNOWN;
        }
    }

    public boolean requiresTwoValues() {
        switch (this) {
            case ADD:
            case SUBTRACT:
            case MULTIPLY:
            case DIVIDE:
            case POWER:
                return true;

            default:
                return false;
        }
    }

    public static int getNumberByOperator(Operator operator) {
        switch (operator) {
            case ADD:
                return 0;
            case SUBTRACT:
                return 1;
            case MULTIPLY:
                return 2;
            case DIVIDE:
                return 3;
            case PERCENT:
                return 4;
            case ASIN:
                return 5;
            case ACOS:
                return 6;
            case ATAN:
                return 7;
            case SIN:
                return 8;
            case COS:
                return 9;
            case TAN:
                return 10;
            case LN:
                return 11;
            case LOG:
                return 12;
            case DENOMINATOR:
                return 13;
            case EXPONENT_POWER:
                return 14;
            case SQUARE:
                return 15;
            case POWER:
                return 16;
            case ABS:
                return 17;
            case SQUARE_ROOT:
                return 18;
            case FACTORIAL:
                return 19;

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
                return SUBTRACT;
            case 2:
                return MULTIPLY;
            case 3:
                return DIVIDE;
            case 4:
                return PERCENT;
            case 5:
                return ASIN;
            case 6:
                return ACOS;
            case 7:
                return ATAN;
            case 8:
                return SIN;
            case 9:
                return COS;
            case 10:
                return TAN;
            case 11:
                return LN;
            case 12:
                return LOG;
            case 13:
                return DENOMINATOR;
            case 14:
                return EXPONENT_POWER;
            case 15:
                return SQUARE;
            case 16:
                return POWER;
            case 17:
                return ABS;
            case 18:
                return SQUARE_ROOT;
            case 19:
                return FACTORIAL;

            default:
                return UNKNOWN;
        }
    }
}

