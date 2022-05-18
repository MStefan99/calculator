package com.annushkaproject.programmerscalculator.model

enum class int_size_enum {
    l8, l4, l2, l1;

    fun wordToInt(): Int {
        return when (this) {
            l8 -> 0
            l4 -> 1
            l2 -> 2
            l1 -> 3
            else -> -1
        }
    }

    companion object {
        fun intToWord(number: Int): int_size_enum {
            return when (number) {
                0 -> l8
                1 -> l4
                2 -> l2
                3 -> l1
                else -> l8
            }
        }
    }
}