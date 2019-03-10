package com.annushkaproject.programmerscalculator.model;

/**
 * Stores all modes in which calculator can perform operations.
 */
public enum Mode {
    DEC,
    OCT,
    BIN,
    HEX;

    /**
     * Used to get the base of the numbers when calculating.
     * @return Integer value of the base.
     */
    public int getBase() {
        switch (this) {
            case DEC:
                return 10;
            case HEX:
                return 16;
            case BIN:
                return 2;
            case OCT:
                return 8;
            default:
                return 10;
        }
    }
}
