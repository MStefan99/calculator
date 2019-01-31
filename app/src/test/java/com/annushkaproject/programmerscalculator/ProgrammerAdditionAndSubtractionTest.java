package com.annushkaproject.programmerscalculator;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.NumberLength.*;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ProgrammerAdditionAndSubtractionTest {
    @Test
    public void programmerAdditionQWORD_isCorrect() {
        assertEquals(10, ProgrammerUtil.addSubtract(QWORD, 5, 5));
        assertEquals(-10, ProgrammerUtil.addSubtract(QWORD, -5, -5));
        assertEquals(0, ProgrammerUtil.addSubtract(QWORD, 0x4000000000000000L, -0x4000000000000000L));
        assertEquals(0, ProgrammerUtil.addSubtract(QWORD, 0x8000000000000000L, 0x8000000000000000L));
        assertEquals(0x7FFFFFFFFFFFFFFFL, ProgrammerUtil.addSubtract(QWORD, -0x8000000000000000L, -1));
        assertEquals(0x8000000000000000L, ProgrammerUtil.addSubtract(QWORD, 0x7FFFFFFFFFFFFFFFL, 1));
        assertEquals(0, ProgrammerUtil.addSubtract(QWORD, 0xFFFFFFFFFFFFFFFFL, 1));
        assertEquals(0x8000000000000000L,ProgrammerUtil.addSubtract(QWORD, 0x4000000000000000L,0x4000000000000000L));
    }
    @Test
    public void programmerAdditionDWORD_isCorrect() {
        assertEquals(10, ProgrammerUtil.addSubtract(DWORD, 5, 5));
        assertEquals(-10, ProgrammerUtil.addSubtract(DWORD, -5, -5));
        assertEquals(0, ProgrammerUtil.addSubtract(DWORD, 0x40000000, -0x40000000));
        assertEquals(0, ProgrammerUtil.addSubtract(DWORD, 0x80000000, 0x80000000));
        assertEquals(0x7FFFFFFF, ProgrammerUtil.addSubtract(DWORD, -0x80000000, -1));
        assertEquals(0x80000000, ProgrammerUtil.addSubtract(DWORD, 0x7FFFFFFF, 1));
        assertEquals(0, ProgrammerUtil.addSubtract(DWORD, 0xFFFFFFFF, 1));
        assertEquals(0x80000000,ProgrammerUtil.addSubtract(DWORD, 0x40000000,0x40000000));
    }
    @Test
    public void programmerAdditionWORD_isCorrect() {
        assertEquals((short) 10, ProgrammerUtil.addSubtract(WORD, 5, 5));
        assertEquals((short) -10, ProgrammerUtil.addSubtract(WORD, -5, -5));
        assertEquals((short) 0, ProgrammerUtil.addSubtract(WORD,0x4000,-0x4000));
        assertEquals((short) 0, ProgrammerUtil.addSubtract(WORD,0x8000,0x8000));
        assertEquals((short) 0x7FFF, ProgrammerUtil.addSubtract(WORD, -0x8000, -1));
        assertEquals((short) 0x8000, ProgrammerUtil.addSubtract(WORD, 0x7FFF, 1));
        assertEquals((short) 0, ProgrammerUtil.addSubtract(WORD, 0xFFFF, 1));
        assertEquals((short) 0x8000,ProgrammerUtil.addSubtract(WORD, 0x4000,0x4000));
    }
    @Test
    public void programmerAdditionBYTE_isCorrect() {
        assertEquals((byte) 10, ProgrammerUtil.addSubtract(BYTE, 5, 5));
        assertEquals((byte) -10, ProgrammerUtil.addSubtract(BYTE, -5, -5));
        assertEquals((byte) 0, ProgrammerUtil.addSubtract(BYTE, 0x40, -0x40));
        assertEquals((byte) 0, ProgrammerUtil.addSubtract(BYTE,0x80,0x80));
        assertEquals((byte) 0x7F, ProgrammerUtil.addSubtract(BYTE,0x80, -1));
        assertEquals((byte) 0x80, ProgrammerUtil.addSubtract(BYTE,0x7F, 1));
        assertEquals((byte) 0, ProgrammerUtil.addSubtract(BYTE,0xFF, 1));
        assertEquals((byte) 0x80,ProgrammerUtil.addSubtract(BYTE,0x40,0x40));
    }
}
