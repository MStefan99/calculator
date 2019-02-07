package com.annushkaproject.programmerscalculator;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.WordLength.*;
import static org.junit.Assert.*;

public class ProgrammerDivisionTest {
    @Test
    public void programmerAdditionQWORD_isCorrect() {
        assertEquals(5, ProgrammerUtil.divide(QWORD, 25, 5));
        assertEquals(-5, ProgrammerUtil.divide(QWORD, -25, 5));
        assertEquals(1, ProgrammerUtil.divide(QWORD, 3, 2));
        assertEquals(0xC000000000000000L, ProgrammerUtil.divide(QWORD, 0x8000000000000000L, 2));
        assertEquals(1, ProgrammerUtil.divide(QWORD, 0x8000000000000000L, 0x8000000000000000L));
        assertEquals(0, ProgrammerUtil.divide(QWORD, 1, 2));
        assertEquals(0xFFFFFFFFFFFFFFFFL, ProgrammerUtil.divide(QWORD, 0xFFFFFFFFFFFFFFFEL, 2));
        assertEquals(0x3FFFFFFFFFFFFFFFL, ProgrammerUtil.divide(QWORD, 0x7FFFFFFFFFFFFFFEL, 2));
    }
    @Test
    public void programmerAdditionDWORD_isCorrect() {
        assertEquals(5, ProgrammerUtil.divide(DWORD, 25, 5));
        assertEquals(-5, ProgrammerUtil.divide(DWORD, -25, 5));
        assertEquals(1, ProgrammerUtil.divide(DWORD, 3, 2));
        assertEquals(0xC0000000, ProgrammerUtil.divide(DWORD, 0x80000000, 2));
        assertEquals(1, ProgrammerUtil.divide(DWORD, 0x80000000, 0x80000000));
        assertEquals(0, ProgrammerUtil.divide(QWORD, 1, 2));
        assertEquals(0xFFFFFFFF, ProgrammerUtil.divide(DWORD, 0xFFFFFFFE, 2));
        assertEquals(0x3FFFFFFF, ProgrammerUtil.divide(DWORD, 0x7FFFFFFE, 2));
    }
    @Test
    public void programmerAdditionWORD_isCorrect() {
        assertEquals((short) 5, ProgrammerUtil.divide(WORD, 25, 5));
        assertEquals((short) -5, ProgrammerUtil.divide(WORD, -25, 5));
        assertEquals((short) 1, ProgrammerUtil.divide(WORD, 3, 2));
        assertEquals((short) 0xC000, ProgrammerUtil.divide(WORD, 0x8000, 2));
        assertEquals((short) 1, ProgrammerUtil.divide(WORD, 0x8000, 0x8000));
        assertEquals(0, ProgrammerUtil.divide(QWORD, 1, 2));
        assertEquals((short) 0xFFFF, ProgrammerUtil.divide(WORD, 0xFFFE, 2));
        assertEquals((short) 0x3FFF, ProgrammerUtil.divide(WORD, 0x7FFE, 2));
    }
    @Test
    public void programmerAdditionBYTE_isCorrect() {
        assertEquals((byte) 5, ProgrammerUtil.divide(BYTE, 25, 5));
        assertEquals((byte) -5, ProgrammerUtil.divide(BYTE, -25, 5));
        assertEquals((byte) 1, ProgrammerUtil.divide(BYTE, 3, 2));
        assertEquals((byte) 0xC0, ProgrammerUtil.divide(BYTE, 0x80, 2));
        assertEquals((byte) 1, ProgrammerUtil.divide(BYTE, 0x80, 0x80));
        assertEquals(0, ProgrammerUtil.divide(QWORD, 1, 2));
        assertEquals((byte) 0xFF, ProgrammerUtil.divide(BYTE, 0xFE, 2));
        assertEquals((byte) 0x3F, ProgrammerUtil.divide(BYTE, 0x7E, 2));
    }
}
