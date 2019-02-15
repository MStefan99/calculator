package com.annushkaproject.programmerscalculator;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.LSH;
import static com.annushkaproject.programmerscalculator.model.Operator.RSH;
import static org.junit.Assert.*;

import static com.annushkaproject.programmerscalculator.model.WordLength.*;

public class ProgrammerShiftTest {
    @Test
    public void lshTestQWORD_isCorrect() {
        assertEquals(0x2, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x1), new Value(1), LSH, QWORD)));
        assertEquals(0x8000000000000000L, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x1), new Value(63), LSH, QWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000000000000000L), new Value(1), LSH, QWORD)));
    }
    @Test
    public void lshTestDWORD_isCorrect() {
        assertEquals(0x2, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x1), new Value(1), LSH, DWORD)));
        assertEquals(0x80000000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x1), new Value(31), LSH, DWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80000000), new Value(1), LSH, DWORD)));
    }
    @Test
    public void lshTestWORD_isCorrect() {
        assertEquals((short) 0x2, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x1), new Value(1), LSH, WORD)));
        assertEquals((short) 0x8000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x1), new Value(15), LSH, WORD)));
        assertEquals((short) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000), new Value(1), LSH, WORD)));
    }
    @Test
    public void lshTestBYTE_isCorrect() {
        assertEquals((byte) 0x2, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x1), new Value(1), LSH, BYTE)));
        assertEquals((byte) 0x80, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x1), new Value(7), LSH, BYTE)));
        assertEquals((byte) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80), new Value(1), LSH, BYTE)));
    }
    @Test
    public void rshTestQWORD_isCorrect() {
        assertEquals(0x1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x2), new Value(1), RSH, QWORD)));
        assertEquals(0xFFFFFFFFFFFFFFFFL, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000000000000000L), new Value(63), RSH, QWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFFFFFFFFFFL), new Value(63), RSH, QWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(1), RSH, QWORD)));
    }
    @Test
    public void rshTestDWORD_isCorrect() {
        assertEquals(0x1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x2), new Value(1), RSH, DWORD)));
        assertEquals(0xFFFFFFFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80000000), new Value(31), RSH, DWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFF), new Value(31), RSH, DWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(1), RSH, DWORD)));
    }
    @Test
    public void rshTestWORD_isCorrect() {
        assertEquals((short) 0x1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x2), new Value(1), RSH, WORD)));
        assertEquals((short) 0xFFFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000), new Value(15), RSH, WORD)));
        assertEquals((short) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFF), new Value(15), RSH, WORD)));
        assertEquals((short) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(1), RSH, WORD)));
    }
    @Test
    public void rshTestBYTE_isCorrect() {
        assertEquals((byte) 0x1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x2), new Value(1), RSH, BYTE)));
        assertEquals((byte) 0xFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80), new Value(7), RSH, BYTE)));
        assertEquals((byte) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7F), new Value(7), RSH, BYTE)));
        assertEquals((byte) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(1), RSH, BYTE)));
    }
}
