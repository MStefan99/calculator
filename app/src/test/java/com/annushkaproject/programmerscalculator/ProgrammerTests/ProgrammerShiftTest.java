package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.LSH;
import static com.annushkaproject.programmerscalculator.model.Operator.RSH;
import static org.junit.Assert.*;

import static com.annushkaproject.programmerscalculator.model.WordLength.*;

public class ProgrammerShiftTest {
    @Test
    public void lshTestQWORD_isCorrect() {
        assertEquals(0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, QWORD)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(63), LSH, QWORD)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(1), LSH, QWORD)));
    }

    @Test
    public void lshTestDWORD_isCorrect() {
        assertEquals(0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, DWORD)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(31), LSH, DWORD)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(1), LSH, DWORD)));
    }

    @Test
    public void lshTestWORD_isCorrect() {
        assertEquals((short) 0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, WORD)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(15), LSH, WORD)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(1), LSH, WORD)));
    }

    @Test
    public void lshTestBYTE_isCorrect() {
        assertEquals((byte) 0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, BYTE)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(7), LSH, BYTE)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(1), LSH, BYTE)));
    }

    @Test
    public void rshTestQWORD_isCorrect() {
        assertEquals(0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, QWORD)));
        assertEquals(0xFFFFFFFFFFFFFFFFL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(63), RSH, QWORD)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), new BigDecimal(63), RSH, QWORD)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, QWORD)));
    }

    @Test
    public void rshTestDWORD_isCorrect() {
        assertEquals(0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, DWORD)));
        assertEquals(0xFFFFFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(31), RSH, DWORD)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), new BigDecimal(31), RSH, DWORD)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, DWORD)));
    }

    @Test
    public void rshTestWORD_isCorrect() {
        assertEquals((short) 0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, WORD)));
        assertEquals((short) 0xFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(15), RSH, WORD)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), new BigDecimal(15), RSH, WORD)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, WORD)));
    }

    @Test
    public void rshTestBYTE_isCorrect() {
        assertEquals((byte) 0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, BYTE)));
        assertEquals((byte) 0xFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(7), RSH, BYTE)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), new BigDecimal(7), RSH, BYTE)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, BYTE)));
    }
}
