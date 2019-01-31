package com.annushkaproject.programmerscalculator;

public class ProgrammerUtil {
    public static long addSubtract(NumberLength mode, long value1, long value2){
        switch(mode) {
            case QWORD:
                return value1 + value2;
            case DWORD:
                return (int) (value1 + value2);
            case WORD:
                return (short) (value1 + value2);
            case BYTE:
                return (byte) (value1 + value2);
        }
        return 0;
    }

    public static long changeSign(NumberLength mode, long value){
        switch(mode) {
            case QWORD:
                return -value;
            case DWORD:
                return (int) -value;
            case WORD:
                return (short) -value;
            case BYTE:
                return (byte) -value;
        }
        return 0;
    }

    public static long lsh(NumberLength mode, long value, int shift){
        switch(mode) {
            case QWORD:
                return value << shift;
            case DWORD:
                return (int) (value << shift);
            case WORD:
                return (short) ((short) value << shift);
            case BYTE:
                return (byte) ((byte) value << shift);
        }
        return 0;
    }

    public static long rsh(NumberLength mode, long value, int shift){
        switch(mode) {
            case QWORD:
                return value >> shift;
            case DWORD:
                return (int) ( value >> shift);
            case WORD:
                return (short) ((short) value >> shift);
            case BYTE:
                return (byte) ((byte) value >> shift);
        }
        return 0;
    }

    public static long not(NumberLength mode, long value){
        switch(mode) {
            case QWORD:
                return ~value;
            case DWORD:
                return (int) ~value;
            case WORD:
                return (short) (~(short) value);
            case BYTE:
                return (byte) (~(byte) value);
        }
        return 0;
    }

    public static long or(NumberLength mode, long value1, long value2){
        switch(mode) {
            case QWORD:
                return value1 | value2;
            case DWORD:
                return (int) (value1 | value2);
            case WORD:
                return (short) (value1 | value2);
            case BYTE:
                return (byte) (value1 | value2);
        }
        return 0;
    }

    public static long xor(NumberLength mode, long value1, long value2){
        switch(mode) {
            case QWORD:
                return value1 ^ value2;
            case DWORD:
                return (int) (value1 ^ value2);
            case WORD:
                return (short) (value1 ^ value2);
            case BYTE:
                return (byte) (value1 ^ value2);
        }
        return 0;
    }

    public static long and(NumberLength mode, long value1, long value2){
        switch(mode) {
            case QWORD:
                return value1 & value2;
            case DWORD:
                return (int) (value1 & value2);
            case WORD:
                return (short) (value1 & value2);
            case BYTE:
                return (byte) (value1 & value2);
        }
        return 0;
    }
}
