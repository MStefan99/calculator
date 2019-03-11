package com.annushkaproject.programmerscalculator.utils;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.WordLength;

import java.math.BigDecimal;

public class ProgrammerOperationsUtil {
    /**
     * Used to get calculated result.
     * @param data Model used to calculate the result.
     * @return Result.
     */
    public static long calculateWithData(ProgrammerCalcModel data) {
        switch (data.getOperator()) {
            case ADD:
                return addSubtract(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case SUBTRACT:
                return addSubtract(data.getWordLength(), data.getFirstValue(), data.getSecondValue().negate());
            case MULTIPLY:
                return multiply(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case DIVIDE:
                return divide(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case LSH:
                return lsh(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case RSH:
                return rsh(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case OR:
                return or(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case XOR:
                return xor(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case AND:
                return and(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case MOD:
                return mod(data.getWordLength(), data.getFirstValue(), data.getSecondValue());
            case CHANGE_SIGN:
                return changeSign(data.getWordLength(), data.getFirstValue());
            case NOT:
                return not(data.getWordLength(), data.getFirstValue());
            default:
                return 0;
        }
    }

    private static long addSubtract(WordLength mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case QWORD:
                return value1.longValue() + value2.longValue();
            case DWORD:
                return value1.intValue() + value2.intValue();
            case WORD:
                return (short) (value1.shortValue() + value2.shortValue());
            case BYTE:
                return (byte) (value1.byteValue() + value2.byteValue());
            default:
                return 0;
        }
    }

    private static long changeSign(WordLength mode, BigDecimal value) {
        switch (mode) {
            case QWORD:
                return value.negate().longValue();
            case DWORD:
                return value.negate().intValue();
            case WORD:
                return value.negate().shortValue();
            case BYTE:
                return value.negate().byteValue();
            default:
                return 0;
        }
    }

    private static long lsh(WordLength mode, BigDecimal value, BigDecimal shift) {
        switch (mode) {
            case QWORD:
                return value.longValue() << shift.intValue();
            case DWORD:
                return value.intValue() << shift.intValue();
            case WORD:
                return (short) (value.shortValue() << shift.intValue());
            case BYTE:
                return (byte) (value.byteValue() << shift.intValue());
            default:
                return 0;
        }
    }

    private static long rsh(WordLength mode, BigDecimal value, BigDecimal shift) {
        switch (mode) {
            case QWORD:
                return value.longValue() >> shift.intValue();
            case DWORD:
                return value.intValue() >> shift.intValue();
            case WORD:
                return (short) (value.shortValue() >> shift.intValue());
            case BYTE:
                return (byte) (value.byteValue() >> shift.intValue());
            default:
                return 0;
        }
    }

    private static long not(WordLength mode, BigDecimal value) {
        switch (mode) {
            case QWORD:
                return ~value.longValue();
            case DWORD:
                return ~value.intValue();
            case WORD:
                return (short) (~value.shortValue());
            case BYTE:
                return (byte) (~value.byteValue());
            default:
                return 0;
        }
    }

    private static long or(WordLength mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case QWORD:
                return value1.longValue() | value2.longValue();
            case DWORD:
                return value1.intValue() | value2.intValue();
            case WORD:
                return (short) (value1.shortValue() | value2.shortValue());
            case BYTE:
                return (byte) (value1.byteValue() | value2.byteValue());
            default:
                return 0;
        }
    }

    private static long xor(WordLength mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case QWORD:
                return value1.longValue() ^ value2.longValue();
            case DWORD:
                return value1.intValue() ^ value2.intValue();
            case WORD:
                return (short) (value1.shortValue() ^ value2.shortValue());
            case BYTE:
                return (byte) (value1.byteValue() ^ value2.byteValue());
            default:
                return 0;
        }
    }

    private static long and(WordLength mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case QWORD:
                return value1.longValue() & value2.longValue();
            case DWORD:
                return value1.intValue() & value2.intValue();
            case WORD:
                return (short) (value1.shortValue() & value2.shortValue());
            case BYTE:
                return (byte) (value1.byteValue() & value2.byteValue());
            default:
                return 0;
        }
    }

    private static long mod(WordLength mode, BigDecimal dividend, BigDecimal divider) {
        switch (mode) {
            case QWORD:
                return dividend.longValue() % divider.longValue();
            case DWORD:
                return dividend.intValue() % divider.intValue();
            case WORD:
                return (short) (dividend.shortValue() % divider.shortValue());
            case BYTE:
                return (byte) (dividend.byteValue() % divider.byteValue());
            default:
                return 0;
        }
    }

    private static long multiply(WordLength mode, BigDecimal value1, BigDecimal value2) {
        switch (mode) {
            case QWORD:
                return value1.longValue() * value2.longValue();
            case DWORD:
                return value1.intValue() * value2.intValue();
            case WORD:
                return (short) (value1.shortValue() * value2.shortValue());
            case BYTE:
                return (byte) (value1.byteValue() * value2.byteValue());
            default:
                return 0;
        }
    }

    private static long divide(WordLength mode, BigDecimal dividend, BigDecimal divider) {
        switch (mode) {
            case QWORD:
                return dividend.longValue() / divider.longValue();
            case DWORD:
                return dividend.intValue() / divider.intValue();
            case WORD:
                return (short) (dividend.shortValue() / divider.shortValue());
            case BYTE:
                return (byte) (dividend.byteValue() / divider.byteValue());
            default:
                return 0;
        }
    }
}
