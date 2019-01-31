package com.annushkaproject.programmerscalculator;


import org.junit.Test;

import static com.annushkaproject.programmerscalculator.NumberLength.*;
import static org.junit.Assert.*;

public class ProgrammerSignChangeTest {
    @Test
    public void programmerSignChangeQWORD_isCorrect() {
        assertEquals(-5, ProgrammerUtil.changeSign(QWORD, 5));
        assertEquals(5, ProgrammerUtil.changeSign(QWORD, -5));
        assertEquals(0xC000000000000000L, ProgrammerUtil.changeSign(QWORD, 0x4000000000000000L));
        assertEquals(0x8000000000000000L, ProgrammerUtil.changeSign(QWORD, 0x8000000000000000L));
        assertEquals(0x8000000000000001L, ProgrammerUtil.changeSign(QWORD, 0x7FFFFFFFFFFFFFFFL));
        assertEquals(1, ProgrammerUtil.changeSign(QWORD, 0xFFFFFFFFFFFFFFFFL));
    }
    @Test
    public void programmerSignChangeDWORD_isCorrect() {
        assertEquals(-5, ProgrammerUtil.changeSign(DWORD, 5));
        assertEquals(5, ProgrammerUtil.changeSign(DWORD, -5));
        assertEquals(0xC0000000, ProgrammerUtil.changeSign(DWORD, 0x40000000));
        assertEquals(0x80000000, ProgrammerUtil.changeSign(DWORD, 0x80000000));
        assertEquals(0x80000001, ProgrammerUtil.changeSign(DWORD, 0x7FFFFFFF));
        assertEquals(1, ProgrammerUtil.changeSign(DWORD, 0xFFFFFFFF));
    }
    @Test
    public void programmerSignChangeWORD_isCorrect() {
        assertEquals((short) -5, ProgrammerUtil.changeSign(WORD, 5));
        assertEquals((short) 5, ProgrammerUtil.changeSign(WORD, -5));
        assertEquals((short) 0xC000, ProgrammerUtil.changeSign(WORD,0x4000));
        assertEquals((short) 0x8000, ProgrammerUtil.changeSign(WORD,0x8000));
        assertEquals((short) 0x8001, ProgrammerUtil.changeSign(WORD,0x7FFF));
        assertEquals((short) 1, ProgrammerUtil.changeSign(WORD,0xFFFF));
    }
    @Test
    public void programmerSignChangeBYTE_isCorrect() {
        assertEquals((byte) -5, ProgrammerUtil.changeSign(BYTE, 5));
        assertEquals((byte) 5, ProgrammerUtil.changeSign(BYTE, -5));
        assertEquals((byte) 0xC0, ProgrammerUtil.changeSign(BYTE,0x40));
        assertEquals((byte) 0x80, ProgrammerUtil.changeSign(BYTE,0x80));
        assertEquals((byte) 0x81, ProgrammerUtil.changeSign(BYTE,0x7F));
        assertEquals((byte) 1, ProgrammerUtil.changeSign(BYTE,0xFF));
    }
}
