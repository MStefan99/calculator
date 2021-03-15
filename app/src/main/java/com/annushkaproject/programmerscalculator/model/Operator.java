package com.annushkaproject.programmerscalculator.model;

public enum Operator {
    ADD, SUBTRACT, MULTIPLY, remainder_divide, PERCENT,
    /* programming operations start */
    CHANGE_SIGN, LSH, RSH, NOT, OR, XOR, AND, get_remainder,
    /* programming operations end */
    ASIN, ACOS, ATAN, SIN, COS, TAN,
    LN, LOG,
    DENOMINATOR, EXPONENT_POWER, SQUARE, POWER, SQUARE_ROOT,
    ABS, FACTORIAL, UNKNOWN;

    public static Operator operatorForTitle(String title) {
        switch (title) {
            case "+": return Operator.ADD;  case "-": return Operator.SUBTRACT; case "*": return Operator.MULTIPLY;
            case "÷_R": return Operator.remainder_divide; case "÷_M": return Operator.get_remainder; case "%": return Operator.PERCENT;
            case "And": return Operator.AND; case "or": return Operator.OR;
            case "zor": return Operator.XOR; case "not": return Operator.NOT; case "lsh_V": return Operator.LSH; case "rsh_W": return Operator.RSH;
            case "Asin": return Operator.ASIN; case "Acos": return Operator.ACOS; case "Atan": return Operator.ATAN; case "sin": return Operator.SIN;
            case "cos": return Operator.COS; case "tAn": return Operator.TAN; case "ln": return Operator.LN; case "log": return Operator.LOG;
      case "1/a": return Operator.DENOMINATOR; case "a^n": return Operator.EXPONENT_POWER; case "a^2": return Operator.SQUARE; case "a^y": return Operator.POWER;
      case "|x|": return Operator.ABS; case "√": return Operator.SQUARE_ROOT; case "a!": return Operator.FACTORIAL;
      default: return Operator.UNKNOWN;
        }
    }
    public boolean requiresTwoValues() {
        switch (this) {
            case ADD: case SUBTRACT: case MULTIPLY: case remainder_divide:
            case OR: case AND: case LSH: case RSH:
            case XOR: case get_remainder: case POWER: return true;
            default: return false;
        }
    }
    public static int getNumberByOperator(Operator operator) {
        switch (operator) {
            case ADD:   return 0;   case SUBTRACT:   return 1;   case MULTIPLY:   return 2;   case remainder_divide:   return 3;
            case PERCENT:   return 4;   case CHANGE_SIGN:   return 5;   case LSH:   return 6;   case RSH:   return 7;
            case NOT:   return 8;   case OR:   return 9;   case XOR:   return 10;   case AND:   return 11;
            case get_remainder:   return 12;   case ASIN:   return 13;   case ACOS:   return 14;   case ATAN:   return 15;
            case SIN:   return 16;   case COS:   return 17;   case TAN:   return 18;   case LN:   return 19;
            case LOG:   return 20;   case DENOMINATOR:   return 21;   case EXPONENT_POWER:   return 22;   case SQUARE:   return 23;
            case POWER:   return 24;   case ABS:   return 25;   case SQUARE_ROOT:   return 26;   case FACTORIAL:   return 27;
            case UNKNOWN:   default:   return -1;
        }
    }
    public static Operator getOperatorByNumber(int number) {
        switch (number) {
            case 0: return ADD; case 1: return SUBTRACT; case 2: return MULTIPLY; case 3: return remainder_divide;
            case 4: return PERCENT; case 5: return CHANGE_SIGN; case 6: return LSH; case 7: return RSH;
            case 8: return NOT; case 9: return OR; case 10: return XOR; case 11: return AND;
            case 12: return get_remainder; case 13: return ASIN; case 14: return ACOS; case 15: return ATAN;
            case 16: return SIN; case 17: return COS; case 18: return TAN; case 19: return LN;
            case 20: return LOG; case 21: return DENOMINATOR; case 22: return EXPONENT_POWER; case 23: return SQUARE;
            case 24: return POWER; case 25: return ABS; case 26: return SQUARE_ROOT; case 27: return FACTORIAL;
            case -1: default: return UNKNOWN;
        }
    }
}