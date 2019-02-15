package com.annushkaproject.programmerscalculator;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.ADD;
import static com.annushkaproject.programmerscalculator.model.WordLength.*;
import static org.junit.Assert.*;

public class ProgrammerAdditionAndSubtractionTest {
    @Test
    public void programmerAdditionQWORD_isCorrect() {
        assertEquals(10, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), ADD, QWORD)));
        assertEquals(-10, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(-5), ADD, QWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x4000000000000000L), new Value(-0x4000000000000000L), ADD, QWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000000000000000L), new Value(0x8000000000000000L), ADD, QWORD)));
        assertEquals(0x7FFFFFFFFFFFFFFFL, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-0x8000000000000000L), new Value(-1), ADD, QWORD)));
        assertEquals(0x8000000000000000L, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFFFFFFFFFFL), new Value(1), ADD, QWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0xFFFFFFFFFFFFFFFFL), new Value(1), ADD, QWORD)));
        assertEquals(0x8000000000000000L, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x4000000000000000L), new Value(0x4000000000000000L), ADD, QWORD)));
    }
    @Test
    public void programmerAdditionDWORD_isCorrect() {
        assertEquals(10, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), ADD, DWORD)));
        assertEquals(-10, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(-5), ADD, DWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x40000000), new Value(-0x40000000), ADD, DWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80000000), new Value(0x80000000), ADD, DWORD)));
        assertEquals(0x7FFFFFFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-0x80000000), new Value(-1), ADD, DWORD)));
        assertEquals(0x80000000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFF), new Value(1), ADD, DWORD)));
        assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0xFFFFFFFF), new Value(1), ADD, DWORD)));
        assertEquals(0x80000000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x40000000), new Value(0x40000000), ADD, DWORD)));
    }
    @Test
    public void programmerAdditionWORD_isCorrect() {
        assertEquals((short) 10, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), ADD, WORD)));
        assertEquals((short) -10, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(-5), ADD, WORD)));
        assertEquals((short) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x4000), new Value(-0x4000), ADD, WORD)));
        assertEquals((short) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000), new Value(0x8000), ADD, WORD)));
        assertEquals((short) 0x7FFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-0x8000), new Value(-1), ADD, WORD)));
        assertEquals((short) 0x8000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFF), new Value(1), ADD, WORD)));
        assertEquals((short) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0xFFFF), new Value(1), ADD, WORD)));
        assertEquals((short) 0x8000,ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x4000), new Value(0x4000), ADD, WORD)));
    }
    @Test
    public void programmerAdditionBYTE_isCorrect() {
        assertEquals((byte) 10, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), ADD, BYTE)));
        assertEquals((byte) -10, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(-5), ADD, BYTE)));
        assertEquals((byte) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x40), new Value(-0x40), ADD, BYTE)));
        assertEquals((byte) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80), new Value(0x80), ADD, BYTE)));
        assertEquals((byte) 0x7F, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80), new Value(-1), ADD, BYTE)));
        assertEquals((byte) 0x80, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7F), new Value(1), ADD, BYTE)));
        assertEquals((byte) 0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0xFF), new Value(1), ADD, BYTE)));
        assertEquals((byte) 0x80,ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x40), new Value(0x40), ADD, BYTE)));
    }
}
