package com.annushkaproject.programmerscalculator;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.DIVIDE;
import static com.annushkaproject.programmerscalculator.model.WordLength.*;
import static org.junit.Assert.*;

public class ProgrammerDivisionTest {
    @Test
    public void programmerAdditionQWORD_isCorrect() {
        assertEquals(5, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(25), new Value(5), DIVIDE, QWORD)));
        assertEquals(-5, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-25), new Value(5), DIVIDE, QWORD)));
        assertEquals(1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(3), new Value(2), DIVIDE, QWORD)));
        assertEquals(0xC000000000000000L, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000000000000000L), new Value(2), DIVIDE, QWORD)));
        assertEquals(1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000000000000000L), new Value(0x8000000000000000L), DIVIDE, QWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(2), DIVIDE, QWORD)));
        assertEquals(0xFFFFFFFFFFFFFFFFL, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0xFFFFFFFFFFFFFFFEL), new Value(2), DIVIDE, QWORD)));
        assertEquals(0x3FFFFFFFFFFFFFFFL, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFFFFFFFFFEL), new Value(2), DIVIDE, QWORD)));
    }
    @Test
    public void programmerAdditionDWORD_isCorrect() {
        assertEquals(5, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(25), new Value(5), DIVIDE, DWORD)));
        assertEquals(-5, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-25), new Value(5), DIVIDE, DWORD)));
        assertEquals(1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(3), new Value(2), DIVIDE, DWORD)));
        assertEquals(0xC0000000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80000000), new Value(2), DIVIDE, DWORD)));
        assertEquals(1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80000000), new Value(0x80000000), DIVIDE, DWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(2), DIVIDE, QWORD)));
        assertEquals(0xFFFFFFFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0xFFFFFFFE), new Value(2), DIVIDE, DWORD)));
        assertEquals(0x3FFFFFFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFE), new Value(2), DIVIDE, DWORD)));
    }
    @Test
    public void programmerAdditionWORD_isCorrect() {
        assertEquals((short) 5, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(25), new Value(5), DIVIDE, WORD)));
        assertEquals((short) -5, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-25), new Value(5), DIVIDE, WORD)));
        assertEquals((short) 1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(3), new Value(2), DIVIDE, WORD)));
        assertEquals((short) 0xC000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000), new Value(2), DIVIDE, WORD)));
        assertEquals((short) 1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000), new Value(0x8000), DIVIDE, WORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(2), DIVIDE, QWORD)));
        assertEquals((short) 0xFFFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0xFFFE), new Value(2), DIVIDE, WORD)));
        assertEquals((short) 0x3FFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFE), new Value(2), DIVIDE, WORD)));
    }
    @Test
    public void programmerAdditionBYTE_isCorrect() {
        assertEquals((byte) 5, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(25), new Value(5), DIVIDE, BYTE)));
        assertEquals((byte) -5, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-25), new Value(5), DIVIDE, BYTE)));
        assertEquals((byte) 1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(3), new Value(2), DIVIDE, BYTE)));
        assertEquals((byte) 0xC0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80), new Value(2), DIVIDE, BYTE)));
        assertEquals((byte) 1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80), new Value(0x80), DIVIDE, BYTE)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(2), DIVIDE, QWORD)));
        assertEquals((byte) 0xFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0xFE), new Value(2), DIVIDE, BYTE)));
        assertEquals((byte) 0x3F, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7E), new Value(2), DIVIDE, BYTE)));
    }
}
