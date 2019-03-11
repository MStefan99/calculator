package com.annushkaproject.programmerscalculator.model;

/**
 * Used to store current length of the variables in programmer mode.
 */
public enum WordLength {
    QWORD,
    DWORD,
    WORD,
    BYTE;

    public int wordToInt() {
        switch (this) {
            case QWORD:
                return 0;
            case DWORD:
                return 1;
            case WORD:
                return 2;
            case BYTE:
                return 3;
            default:
                return -1;
        }
    }

    public static WordLength intToWord(int number) {
        switch (number) {
            default:
            case 0:
                return QWORD;
            case 1:
                return DWORD;
            case 2:
                return WORD;
            case 3:
                return BYTE;
        }
    }
}
