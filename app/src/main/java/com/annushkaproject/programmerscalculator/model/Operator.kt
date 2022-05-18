package com.annushkaproject.programmerscalculator.model

enum class Operator {
    ADD, SUBTRACT, MULTIPLY, remainder_divide, PERCENT,  /* programming operations start */
    CHANGE_SIGN, LSH, RSH, NOT, OR, XOR, AND, get_remainder,  /* programming operations end */
    ASIN, ACOS, ATAN, SIN, COS, TAN, LN, LOG, DENOMINATOR, EXPONENT_POWER, SQUARE, POWER, SQUARE_ROOT, ABS, FACTORIAL, UNKNOWN;

    fun requiresTwoValues(): Boolean {
        return when (this) {
            ADD, SUBTRACT, MULTIPLY, remainder_divide, OR, AND, LSH, RSH, XOR, get_remainder, POWER -> true
            else -> false
        }
    }

    companion object {
        @JvmStatic
        fun operatorForTitle(title: String?): Operator {
            return when (title) {
                "+" -> ADD
                "-" -> SUBTRACT
                "*" -> MULTIPLY
                "÷_R" -> remainder_divide
                "÷_M" -> get_remainder
                "%" -> PERCENT
                "And" -> AND
                "or" -> OR
                "zor" -> XOR
                "not" -> NOT
                "lsh_V" -> LSH
                "rsh_W" -> RSH
                "Asin" -> ASIN
                "Acos" -> ACOS
                "Atan" -> ATAN
                "sin" -> SIN
                "cos" -> COS
                "tAn" -> TAN
                "ln" -> LN
                "log" -> LOG
                "1/a" -> DENOMINATOR
                "a^n" -> EXPONENT_POWER
                "a^2" -> SQUARE
                "a^y" -> POWER
                "|x|" -> ABS
                "√" -> SQUARE_ROOT
                "a!" -> FACTORIAL
                else -> UNKNOWN
            }
        }

        fun getNumberByOperator(operator: Operator?): Int {
            return when (operator) {
                ADD -> 0
                SUBTRACT -> 1
                MULTIPLY -> 2
                remainder_divide -> 3
                PERCENT -> 4
                CHANGE_SIGN -> 5
                LSH -> 6
                RSH -> 7
                NOT -> 8
                OR -> 9
                XOR -> 10
                AND -> 11
                get_remainder -> 12
                ASIN -> 13
                ACOS -> 14
                ATAN -> 15
                SIN -> 16
                COS -> 17
                TAN -> 18
                LN -> 19
                LOG -> 20
                DENOMINATOR -> 21
                EXPONENT_POWER -> 22
                SQUARE -> 23
                POWER -> 24
                ABS -> 25
                SQUARE_ROOT -> 26
                FACTORIAL -> 27
                UNKNOWN -> -1
                else -> -1
            }
        }

        fun getOperatorByNumber(number: Int): Operator {
            return when (number) {
                0 -> ADD
                1 -> SUBTRACT
                2 -> MULTIPLY
                3 -> remainder_divide
                4 -> PERCENT
                5 -> CHANGE_SIGN
                6 -> LSH
                7 -> RSH
                8 -> NOT
                9 -> OR
                10 -> XOR
                11 -> AND
                12 -> get_remainder
                13 -> ASIN
                14 -> ACOS
                15 -> ATAN
                16 -> SIN
                17 -> COS
                18 -> TAN
                19 -> LN
                20 -> LOG
                21 -> DENOMINATOR
                22 -> EXPONENT_POWER
                23 -> SQUARE
                24 -> POWER
                25 -> ABS
                26 -> SQUARE_ROOT
                27 -> FACTORIAL
                -1 -> UNKNOWN
                else -> UNKNOWN
            }
        }
    }
}