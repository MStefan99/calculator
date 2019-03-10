package com.annushkaproject.programmerscalculator.model;

/**
 * Used to store the calculation operator.
 */
public enum Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    PERCENT,
    /* programming operations start */
    CHANGE_SIGN,
    LSH,
    RSH,
    NOT,
    OR,
    XOR,
    AND,
    MOD,
    /* programming operations end */
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

    /**
     * Used to get operator from its name.
     * @param title Operator name.
     * @return Corresponding operator.
     */
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

    /**
     * Used to check if the operator requires two values.
     * @return True if operator requires two values.
     */
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

    /**
     * Used to get the unique code for saving the operator.
     * @param operator Operator.
     * @return Corresponding code.
     */
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
            case ASIN:
                return 13;
            case ACOS:
                return 14;
            case ATAN:
                return 15;
            case SIN:
                return 16;
            case COS:
                return 17;
            case TAN:
                return 18;
            case LN:
                return 19;
            case LOG:
                return 20;
            case DENOMINATOR:
                return 21;
            case EXPONENT_POWER:
                return 22;
            case SQUARE:
                return 23;
            case POWER:
                return 24;
            case ABS:
                return 25;
            case SQUARE_ROOT:
                return 26;
            case FACTORIAL:
                return 27;
            case UNKNOWN:
            default:
                return -1;
        }
    }

    /**
     * Used to get the operator by its code.
     * @param number Operator code.
     * @return Corresponding operator.
     */
    public static Operator getOperatorByNumber(int number) {
        switch (number) {
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
            case 13:
                return ASIN;
            case 14:
                return ACOS;
            case 15:
                return ATAN;
            case 16:
                return SIN;
            case 17:
                return COS;
            case 18:
                return TAN;
            case 19:
                return LN;
            case 20:
                return LOG;
            case 21:
                return DENOMINATOR;
            case 22:
                return EXPONENT_POWER;
            case 23:
                return SQUARE;
            case 24:
                return POWER;
            case 25:
                return ABS;
            case 26:
                return SQUARE_ROOT;
            case 27:
                return FACTORIAL;
            case -1:
            default:
                return UNKNOWN;
        }
    }
}

