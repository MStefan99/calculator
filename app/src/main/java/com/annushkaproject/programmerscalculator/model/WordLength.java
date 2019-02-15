package com.annushkaproject.programmerscalculator.model;

public enum WordLength {
    QWORD,
    DWORD,
    WORD,
    BYTE,
    UNKNOWN;

    public static int wordToInt(WordLength word) {
        switch (word) {
            case QWORD:
                return 0;
            case DWORD:
                return 1;
            case WORD:
                return 2;
            case BYTE:
                return 3;
            case UNKNOWN:
                return 4;
            default:
                return -1;
        }
    }

    public static WordLength intToWord(int number) {
        switch (number) {
            case 0:
                return QWORD;
            case 1:
                return DWORD;
            case 2:
                return WORD;
            case 3:
                return BYTE;
            default:
                return UNKNOWN;
        }
    }
}
