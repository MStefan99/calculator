package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.remainder_divide;
import static com.annushkaproject.programmerscalculator.model.int_size_enum.*;
import static org.junit.Assert.*;

public class ProgrammerDivisionTest {
    @Test
    public void programmerDivisionQWORD_isCorrect() {
        assertEquals(5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(25), new BigDecimal(5), remainder_divide, len8)));
        assertEquals(-5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-25), new BigDecimal(5), remainder_divide, len8)));
        assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(3), new BigDecimal(2), remainder_divide, len8)));
        assertEquals(0xC000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(2), remainder_divide, len8)));
        assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(0x8000000000000000L), remainder_divide, len8)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(2), remainder_divide, len8)));
        assertEquals(0xFFFFFFFFFFFFFFFFL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFFFFFFFFFEL), new BigDecimal(2), remainder_divide, len8)));
        assertEquals(0x3FFFFFFFFFFFFFFFL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFEL), new BigDecimal(2), remainder_divide, len8)));
    }

    @Test
    public void programmerDivisionDWORD_isCorrect() {
        assertEquals(5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(25), new BigDecimal(5), remainder_divide, len4)));
        assertEquals(-5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-25), new BigDecimal(5), remainder_divide, len4)));
        assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(3), new BigDecimal(2), remainder_divide, len4)));
        assertEquals(0xC0000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(2), remainder_divide, len4)));
        assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(0x80000000), remainder_divide, len4)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(2), remainder_divide, len8)));
        assertEquals(0xFFFFFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFE), new BigDecimal(2), remainder_divide, len4)));
        assertEquals(0x3FFFFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFE), new BigDecimal(2), remainder_divide, len4)));
    }

    @Test
    public void programmerDivisionWORD_isCorrect() {
        assertEquals((short) 5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(25), new BigDecimal(5), remainder_divide, len2)));
        assertEquals((short) -5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-25), new BigDecimal(5), remainder_divide, len2)));
        assertEquals((short) 1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(3), new BigDecimal(2), remainder_divide, len2)));
        assertEquals((short) 0xC000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(2), remainder_divide, len2)));
        assertEquals((short) 1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(0x8000), remainder_divide, len2)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(2), remainder_divide, len8)));
        assertEquals((short) 0xFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFE), new BigDecimal(2), remainder_divide, len2)));
        assertEquals((short) 0x3FFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFE), new BigDecimal(2), remainder_divide, len2)));
    }

    @Test
    public void programmerDivisionBYTE_isCorrect() {
        assertEquals((byte) 5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(25), new BigDecimal(5), remainder_divide, len1)));
        assertEquals((byte) -5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-25), new BigDecimal(5), remainder_divide, len1)));
        assertEquals((byte) 1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(3), new BigDecimal(2), remainder_divide, len1)));
        assertEquals((byte) 0xC0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(2), remainder_divide, len1)));
        assertEquals((byte) 1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(0x80), remainder_divide, len1)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(2), remainder_divide, len8)));
        assertEquals((byte) 0xFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFE), new BigDecimal(2), remainder_divide, len1)));
        assertEquals((byte) 0x3F, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7E), new BigDecimal(2), remainder_divide, len1)));
    }
}
