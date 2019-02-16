package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.model.WordLength;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.NOT;
import static org.junit.Assert.*;

import static com.annushkaproject.programmerscalculator.model.WordLength.*;

public class ProgrammerNotTest {
    @Test
    public void notTestBasic_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(-2, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), NOT, mode)));
            assertEquals(-1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0), NOT, mode)));
            assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-1), NOT, mode)));
            assertEquals(1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-2), NOT, mode)));
        }
    }
    @Test
    public void notTestQWORD_isCorrect() {
        assertEquals(0x8000000000000000L, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFFFFFFFFFFL), NOT, QWORD)));
        assertEquals(0x7FFFFFFFFFFFFFFFL, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000000000000000L), NOT, QWORD)));
    }
    @Test
    public void notTestDWORD_isCorrect() {
        assertEquals(0x80000000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFFFFFF), NOT, DWORD)));
        assertEquals(0x7FFFFFFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80000000), NOT, DWORD)));
    }
    @Test
    public void notTestWORD_isCorrect() {
        assertEquals((short) 0x8000, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7FFF), NOT, WORD)));
        assertEquals((short) 0x7FFF, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x8000), NOT, WORD)));
    }
    @Test
    public void notTestBYTE_isCorrect() {
        assertEquals((byte) 0x80, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x7F), NOT, BYTE)));
        assertEquals((byte) 0x7F, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0x80), NOT, BYTE)));
    }
}
