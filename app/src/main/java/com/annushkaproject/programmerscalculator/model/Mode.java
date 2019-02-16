package com.annushkaproject.programmerscalculator.model;

public enum Mode {
    DEC,
    OCT,
    BIN,
    HEX;

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
