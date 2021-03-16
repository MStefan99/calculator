package com.annushkaproject.programmerscalculator.model

enum class mode_enum {
    mode_enum_dec, mode_enum_heks;

    val base: Int
        get() = when (this) {
            mode_enum_dec -> 10
            mode_enum_heks -> 16
            else -> 16
        }
}