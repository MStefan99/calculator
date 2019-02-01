package com.annushkaproject.programmerscalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProgrammerXorTest {
    @Test
    public void xorTestAll_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(0, ProgrammerUtil.xor(mode, 1, 1));
            assertEquals(1, ProgrammerUtil.xor(mode, 1, 0));
            assertEquals(-2, ProgrammerUtil.xor(mode, -1, 1));
            assertEquals(-1, ProgrammerUtil.xor(mode, -1, 0));
        }
    }
}