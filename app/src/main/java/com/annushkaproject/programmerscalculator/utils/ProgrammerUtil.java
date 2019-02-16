package com.annushkaproject.programmerscalculator.utils;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.WordLength;

public class ProgrammerUtil {
    public static long calculateWithData(ProgrammerCalcModel data) {
        switch (data.getOperator()) {
            case ADD:
                return addSubtract(data.getWordLength(), (long) data.getFirstValue().getNumber(), (long) data.getSecondValue().getNumber());
            case SUBTRACT:
                return addSubtract(data.getWordLength(), (long) data.getFirstValue().getNumber(), - (long) data.getSecondValue().getNumber());
            case MULTIPLY:
                return multiply(data.getWordLength(), (long) data.getFirstValue().getNumber(), (long) data.getSecondValue().getNumber());
            case DIVIDE:
                return divide(data.getWordLength(), (long) data.getFirstValue().getNumber(), (long) data.getSecondValue().getNumber());
            case LSH:
                return lsh(data.getWordLength(), (long) data.getFirstValue().getNumber(), (int) data.getSecondValue().getNumber());
            case RSH:
                return rsh(data.getWordLength(), (long) data.getFirstValue().getNumber(), (int) data.getSecondValue().getNumber());
            case OR:
                return or(data.getWordLength(), (long) data.getFirstValue().getNumber(), (long) data.getSecondValue().getNumber());
            case XOR:
                return xor(data.getWordLength(), (long) data.getFirstValue().getNumber(), (long) data.getSecondValue().getNumber());
            case AND:
                return and(data.getWordLength(), (long) data.getFirstValue().getNumber(), (long) data.getSecondValue().getNumber());
            case MOD:
                return mod(data.getWordLength(), (long) data.getFirstValue().getNumber(), (long) data.getSecondValue().getNumber());
            case CHANGE_SIGN:
                return changeSign(data.getWordLength(), (long) data.getFirstValue().getNumber());
            case NOT:
                return not(data.getWordLength(), (long) data.getFirstValue().getNumber());
            default:
                return 0;
        }
    }

    private static long addSubtract(WordLength mode, long value1, long value2) {
        switch(mode) {
            case QWORD:
                return value1 + value2;
            case DWORD:
                return (int) (value1 + value2);
            case WORD:
                return (short) (value1 + value2);
            case BYTE:
                return (byte) (value1 + value2);
            default:
                return 0;
        }
    }

    private static long changeSign(WordLength mode, long value) {
        switch(mode) {
            case QWORD:
                return -value;
            case DWORD:
                return (int) -value;
            case WORD:
                return (short) -value;
            case BYTE:
                return (byte) -value;
            default:
                return 0;
        }
    }

    private static long lsh(WordLength mode, long value, int shift) {
        switch(mode) {
            case QWORD:
                return value << shift;
            case DWORD:
                return (int) (value << shift);
            case WORD:
                return (short) ((short) value << shift);
            case BYTE:
                return (byte) ((byte) value << shift);
            default:
                return 0;
        }
    }

    private static long rsh(WordLength mode, long value, int shift) {
        switch(mode) {
            case QWORD:
                return value >> shift;
            case DWORD:
                return (int) ( value >> shift);
            case WORD:
                return (short) ((short) value >> shift);
            case BYTE:
                return (byte) ((byte) value >> shift);
            default:
                return 0;
        }
    }

    private static long not(WordLength mode, long value) {
        switch(mode) {
            case QWORD:
                return ~value;
            case DWORD:
                return (int) ~value;
            case WORD:
                return (short) (~(short) value);
            case BYTE:
                return (byte) (~(byte) value);
            default:
                return 0;
        }
    }

    private static long or(WordLength mode, long value1, long value2) {
        switch(mode) {
            case QWORD:
                return value1 | value2;
            case DWORD:
                return (int) (value1 | value2);
            case WORD:
                return (short) (value1 | value2);
            case BYTE:
                return (byte) (value1 | value2);
            default:
                return 0;
        }
    }

    private static long xor(WordLength mode, long value1, long value2) {
        switch(mode) {
            case QWORD:
                return value1 ^ value2;
            case DWORD:
                return (int) (value1 ^ value2);
            case WORD:
                return (short) (value1 ^ value2);
            case BYTE:
                return (byte) (value1 ^ value2);
            default:
                return 0;
        }
    }

    private static long and(WordLength mode, long value1, long value2) {
        switch(mode) {
            case QWORD:
                return value1 & value2;
            case DWORD:
                return (int) (value1 & value2);
            case WORD:
                return (short) (value1 & value2);
            case BYTE:
                return (byte) (value1 & value2);
            default:
                return 0;
        }
    }

    private static long mod(WordLength mode, long dividend, long divider) {
        switch(mode) {
            case QWORD:
                return dividend % divider;
            case DWORD:
                return (int) dividend % divider;
            case WORD:
                return (short) dividend % divider;
            case BYTE:
                return (byte) dividend % divider;
            default:
                return 0;
        }
    }

    private static long multiply(WordLength mode, long value1, long value2) {
        switch(mode) {
            case QWORD:
                return value1 * value2;
            case DWORD:
                return (int) (value1 * value2);
            case WORD:
                return (short) ((short) value1 * (short) value2);
            case BYTE:
                return (byte) ((byte) value1 * (byte) value2);
            default:
                return 0;
        }
    }

    private static long divide(WordLength mode, long dividend, long divider) {
        switch(mode) {
            case QWORD:
                return dividend / divider;
            case DWORD:
                return (int) (dividend / divider);
            case WORD:
                return (short) ((short) dividend / (short) divider);
            case BYTE:
                return (byte) ((byte) dividend / (byte) divider);
            default:
                return 0;
        }
    }
}
