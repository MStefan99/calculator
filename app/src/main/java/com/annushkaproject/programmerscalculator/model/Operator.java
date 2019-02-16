package com.annushkaproject.programmerscalculator.model;

public enum Operator {
    ADD,
    SUBTRACT,
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
            case "And":
                return Operator.AND;
            case "Or":
                return Operator.OR;
            case "Xor":
                return Operator.XOR;
            case "Not":
                return Operator.NOT;
            case "Lsh":
                return Operator.LSH;
            case "Rsh":
                return Operator.RSH;
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
            case OR:
            case AND:
            case LSH:
            case RSH:
            case XOR:
            case MOD:
            case POWER:
                return true;

            default:
                return false;
        }
    }

    public static int getNumberByOperator(Operator operator) {
        return operator.ordinal();
    }

    public static Operator getOperatorByNumber(int number) {
        return Operator.values()[number];
    }
}

