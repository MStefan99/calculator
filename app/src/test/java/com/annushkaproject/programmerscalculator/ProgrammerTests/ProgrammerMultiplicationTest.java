package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.MULTIPLY;
import static com.annushkaproject.programmerscalculator.model.WordLength.*;
import static org.junit.Assert.*;

public class ProgrammerMultiplicationTest {
    @Test
    public void programmerMultiplicationQWORD_isCorrect() {
        assertEquals(25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), MULTIPLY, QWORD)));
        assertEquals(-25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(5), MULTIPLY, QWORD)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x4000000000000000L), new Value(2), MULTIPLY, QWORD)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000000000000000L), new Value(0x8000000000000000L), MULTIPLY, QWORD)));
        assertEquals(0xFFFFFFFFFFFFFFFEL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFFFFFFFFFFL), new Value(2), MULTIPLY, QWORD)));
        //TODO: Fix error
        //assertEquals(0x7FFFFFFFFFFFFFFEL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x3FFFFFFFFFFFFFFFL), new Value(2), MULTIPLY, QWORD)));
    }
    @Test
    public void programmerMultiplicationDWORD_isCorrect() {
        assertEquals(25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), MULTIPLY, DWORD)));
        assertEquals(-25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(5), MULTIPLY, DWORD)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x40000000), new Value(2), MULTIPLY, DWORD)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80000000), new Value(0x80000000), MULTIPLY, DWORD)));
        assertEquals(0xFFFFFFFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFF), new Value(2), MULTIPLY, DWORD)));
        assertEquals(0x7FFFFFFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x3FFFFFFF), new Value(2), MULTIPLY, DWORD)));
    }
    @Test
    public void programmerMultiplicationWORD_isCorrect() {
        assertEquals((short) 25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), MULTIPLY, WORD)));
        assertEquals((short) -25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(5), MULTIPLY, WORD)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x4000), new Value(2), MULTIPLY, WORD)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000), new Value(0x8000), MULTIPLY, WORD)));
        assertEquals((short) 0xFFFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFF), new Value(2), MULTIPLY, WORD)));
        assertEquals((short) 0x7FFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x3FFF), new Value(2), MULTIPLY, WORD)));
    }
    @Test
    public void programmerMultiplicationBYTE_isCorrect() {
        assertEquals((byte) 25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), MULTIPLY, BYTE)));
        assertEquals((byte) -25, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(5), MULTIPLY, BYTE)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x40), new Value(2), MULTIPLY, BYTE)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80), new Value(0x80), MULTIPLY, BYTE)));
        assertEquals((byte) 0xFE, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7F), new Value(2), MULTIPLY, BYTE)));
        assertEquals((byte) 0x7E, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x3F), new Value(2), MULTIPLY, BYTE)));
    }
}
