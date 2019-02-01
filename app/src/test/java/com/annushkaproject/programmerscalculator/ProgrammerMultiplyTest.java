package com.annushkaproject.programmerscalculator;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.WordLength.*;
import static org.junit.Assert.*;

public class ProgrammerMultiplyTest {
    @Test
    public void programmerMultiplicationQWORD_isCorrect() {
        assertEquals(25, ProgrammerUtil.multiply(QWORD, 5, 5));
        assertEquals(-25, ProgrammerUtil.multiply(QWORD, -5, 5));
        assertEquals(0x8000000000000000L, ProgrammerUtil.multiply(QWORD, 0x4000000000000000L, 2));
        assertEquals(0, ProgrammerUtil.multiply(QWORD, 0x8000000000000000L, 0x8000000000000000L));
        assertEquals(0xFFFFFFFFFFFFFFFEL, ProgrammerUtil.multiply(QWORD, 0x7FFFFFFFFFFFFFFFL, 2));
        assertEquals(0x7FFFFFFFFFFFFFFEL, ProgrammerUtil.multiply(QWORD, 0x3FFFFFFFFFFFFFFFL, 2));
    }
    @Test
    public void programmerMultiplicationDWORD_isCorrect() {
        assertEquals(25, ProgrammerUtil.multiply(DWORD, 5, 5));
        assertEquals(-25, ProgrammerUtil.multiply(DWORD, -5, 5));
        assertEquals(0x80000000, ProgrammerUtil.multiply(DWORD, 0x40000000, 2));
        assertEquals(0, ProgrammerUtil.multiply(DWORD, 0x80000000, 0x80000000));
        assertEquals(0xFFFFFFFE, ProgrammerUtil.multiply(DWORD, 0x7FFFFFFF, 2));
        assertEquals(0x7FFFFFFE, ProgrammerUtil.multiply(DWORD, 0x3FFFFFFF, 2));
    }
    @Test
    public void programmerMultiplicationWORD_isCorrect() {
        assertEquals((short) 25, ProgrammerUtil.multiply(WORD, 5, 5));
        assertEquals((short) -25, ProgrammerUtil.multiply(WORD, -5, 5));
        assertEquals((short) 0x8000, ProgrammerUtil.multiply(WORD, 0x4000, 2));
        assertEquals((short) 0, ProgrammerUtil.multiply(WORD, 0x8000, 0x8000));
        assertEquals((short) 0xFFFE, ProgrammerUtil.multiply(WORD, 0x7FFF, 2));
        assertEquals((short) 0x7FFE, ProgrammerUtil.multiply(WORD, 0x3FFF, 2));
    }
    @Test
    public void programmerMultiplicationBYTE_isCorrect() {
        assertEquals((byte) 25, ProgrammerUtil.multiply(BYTE, 5, 5));
        assertEquals((byte) -25, ProgrammerUtil.multiply(BYTE, -5, 5));
        assertEquals((byte) 0x80, ProgrammerUtil.multiply(BYTE, 0x40, 2));
        assertEquals((byte) 0, ProgrammerUtil.multiply(BYTE, 0x80, 0x80));
        assertEquals((byte) 0xFE, ProgrammerUtil.multiply(BYTE, 0x7F, 2));
        assertEquals((byte) 0x7E, ProgrammerUtil.multiply(BYTE, 0x3F, 2));
    }
}
