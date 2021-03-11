package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.LSH;
import static com.annushkaproject.programmerscalculator.model.Operator.RSH;
import static org.junit.Assert.*;

import static com.annushkaproject.programmerscalculator.model.int_size_enum.*;

public class ProgrammerShiftTest {
    @Test
    public void lshTestQWORD_isCorrect() {
        assertEquals(0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, len8)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(63), LSH, len8)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(1), LSH, len8)));
    }

    @Test
    public void lshTestDWORD_isCorrect() {
        assertEquals(0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, len4)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(31), LSH, len4)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(1), LSH, len4)));
    }

    @Test
    public void lshTestWORD_isCorrect() {
        assertEquals((short) 0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, len2)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(15), LSH, len2)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(1), LSH, len2)));
    }

    @Test
    public void lshTestBYTE_isCorrect() {
        assertEquals((byte) 0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, len1)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(7), LSH, len1)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(1), LSH, len1)));
    }

    @Test
    public void rshTestQWORD_isCorrect() {
        assertEquals(0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, len8)));
        assertEquals(0xFFFFFFFFFFFFFFFFL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(63), RSH, len8)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), new BigDecimal(63), RSH, len8)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, len8)));
    }

    @Test
    public void rshTestDWORD_isCorrect() {
        assertEquals(0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, len4)));
        assertEquals(0xFFFFFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(31), RSH, len4)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), new BigDecimal(31), RSH, len4)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, len4)));
    }

    @Test
    public void rshTestWORD_isCorrect() {
        assertEquals((short) 0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, len2)));
        assertEquals((short) 0xFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(15), RSH, len2)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), new BigDecimal(15), RSH, len2)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, len2)));
    }

    @Test
    public void rshTestBYTE_isCorrect() {
        assertEquals((byte) 0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, len1)));
        assertEquals((byte) 0xFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(7), RSH, len1)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), new BigDecimal(7), RSH, len1)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, len1)));
    }
}
