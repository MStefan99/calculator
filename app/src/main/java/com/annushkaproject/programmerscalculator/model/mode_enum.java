package com.annushkaproject.programmerscalculator.model;
public enum mode_enum { mode_enum_dec, mode_enum_heks;
    public int getBase() { switch (this) { case mode_enum_dec: return 10; case mode_enum_heks: return 16; default: return 10; } }
}
