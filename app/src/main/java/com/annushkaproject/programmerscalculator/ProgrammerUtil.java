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
}
