package com.annushkaproject.programmerscalculator;

public class ProgrammerUtil {
    public static long addSubtract(WordLength mode, long value1, long value2) {
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

    public static long changeSign(WordLength mode, long value) {
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

    public static long lsh(WordLength mode, long value, int shift) {
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

    public static long rsh(WordLength mode, long value, int shift) {
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

    public static long not(WordLength mode, long value) {
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

    public static long or(WordLength mode, long value1, long value2) {
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

    public static long xor(WordLength mode, long value1, long value2) {
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

    public static long and(WordLength mode, long value1, long value2) {
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

    public static long mod(WordLength mode, long dividend, long divider) {
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
    
    public static long multiply(WordLength mode, long value1, long value2) {
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

    public static long divide(WordLength mode, long dividend, long divider) {
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
