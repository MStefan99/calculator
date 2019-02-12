package com.annushkaproject.programmerscalculator;

import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;
import static org.junit.Assert.*;

import static com.annushkaproject.programmerscalculator.model.WordLength.*;

public class ProgrammerShiftTest {
    @Test
    public void lshTestQWORD_isCorrect() {
        assertEquals(0x2, ProgrammerUtil.lsh(QWORD, 0x1, 1));
        assertEquals(0x8000000000000000L, ProgrammerUtil.lsh(QWORD, 0x1, 63));
        assertEquals(0, ProgrammerUtil.lsh(QWORD, 0x8000000000000000L, 1));
    }
    @Test
    public void lshTestDWORD_isCorrect() {
        assertEquals(0x2, ProgrammerUtil.lsh(DWORD, 0x1, 1));
        assertEquals(0x80000000, ProgrammerUtil.lsh(DWORD, 0x1, 31));
        assertEquals(0, ProgrammerUtil.lsh(DWORD, 0x80000000, 1));
    }
    @Test
    public void lshTestWORD_isCorrect() {
        assertEquals((short) 0x2, ProgrammerUtil.lsh(WORD, 0x1, 1));
        assertEquals((short) 0x8000, ProgrammerUtil.lsh(WORD, 0x1, 15));
        assertEquals((short) 0, ProgrammerUtil.lsh(WORD, 0x8000, 1));
    }
    @Test
    public void lshTestBYTE_isCorrect() {
        assertEquals((byte) 0x2, ProgrammerUtil.lsh(BYTE, 0x1, 1));
        assertEquals((byte) 0x80, ProgrammerUtil.lsh(BYTE, 0x1, 7));
        assertEquals((byte) 0, ProgrammerUtil.lsh(BYTE,0x80, 1));
    }
    @Test
    public void rshTestQWORD_isCorrect() {
        assertEquals(0x1, ProgrammerUtil.rsh(QWORD, 0x2, 1));
        assertEquals(0xFFFFFFFFFFFFFFFFL, ProgrammerUtil.rsh(QWORD, 0x8000000000000000L, 63));
        assertEquals(0, ProgrammerUtil.rsh(QWORD, 0x7FFFFFFFFFFFFFFFL, 63));
        assertEquals(0, ProgrammerUtil.rsh(QWORD, 1, 1));
    }
    @Test
    public void rshTestDWORD_isCorrect() {
        assertEquals(0x1, ProgrammerUtil.rsh(DWORD, 0x2, 1));
        assertEquals(0xFFFFFFFF, ProgrammerUtil.rsh(DWORD, 0x80000000, 31));
        assertEquals(0, ProgrammerUtil.rsh(DWORD, 0x7FFFFFFF, 31));
        assertEquals(0, ProgrammerUtil.rsh(DWORD, 1, 1));
    }
    @Test
    public void rshTestWORD_isCorrect() {
        assertEquals((short) 0x1, ProgrammerUtil.rsh(WORD, 0x2, 1));
        assertEquals((short) 0xFFFF, ProgrammerUtil.rsh(WORD,0x8000, 15));
        assertEquals((short) 0, ProgrammerUtil.rsh(WORD, 0x7FFF, 15));
        assertEquals((short) 0, ProgrammerUtil.rsh(WORD, 1, 1));
    }
    @Test
    public void rshTestBYTE_isCorrect() {
        assertEquals((byte) 0x1, ProgrammerUtil.rsh(BYTE, 0x2, 1));
        assertEquals((byte) 0xFF, ProgrammerUtil.rsh(BYTE,0x80, 7));
        assertEquals((byte) 0, ProgrammerUtil.rsh(BYTE,0x7F, 7));
        assertEquals((byte) 0, ProgrammerUtil.rsh(BYTE, 1, 1));
    }
}
