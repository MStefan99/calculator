package com.annushkaproject.programmerscalculator;

import com.annushkaproject.programmerscalculator.model.WordLength;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;
import static org.junit.Assert.*;

import static com.annushkaproject.programmerscalculator.model.WordLength.*;

public class ProgrammerNotTest {
    @Test
    public void notTestBasic_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(-2, ProgrammerUtil.not(mode, 1));
            assertEquals(-1, ProgrammerUtil.not(mode, 0));
            assertEquals(0, ProgrammerUtil.not(mode, -1));
            assertEquals(1, ProgrammerUtil.not(mode, -2));
        }
    }
    @Test
    public void notTestQWORD_isCorrect() {
        assertEquals(0x8000000000000000L, ProgrammerUtil.not(QWORD, 0x7FFFFFFFFFFFFFFFL));
        assertEquals(0x7FFFFFFFFFFFFFFFL, ProgrammerUtil.not(QWORD, 0x8000000000000000L));
    }
    @Test
    public void notTestDWORD_isCorrect() {
        assertEquals(0x80000000, ProgrammerUtil.not(DWORD, 0x7FFFFFFF));
        assertEquals(0x7FFFFFFF, ProgrammerUtil.not(DWORD, 0x80000000));
    }
    @Test
    public void notTestWORD_isCorrect() {
        assertEquals((short) 0x8000, ProgrammerUtil.not(WORD, 0x7FFF));
        assertEquals((short) 0x7FFF, ProgrammerUtil.not(WORD, 0x8000));
    }
    @Test
    public void notTestBYTE_isCorrect() {
        assertEquals((byte) 0x80, ProgrammerUtil.not(BYTE, 0x7F));
        assertEquals((byte) 0x7F, ProgrammerUtil.not(BYTE, 0x80));
    }
}
