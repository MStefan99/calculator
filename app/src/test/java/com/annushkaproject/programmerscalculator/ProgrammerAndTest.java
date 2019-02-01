package com.annushkaproject.programmerscalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProgrammerAndTest {
    @Test
    public void andTestAll_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(0, ProgrammerUtil.and(mode, 1, 0));
            assertEquals(1, ProgrammerUtil.and(mode, 1, 1));
            assertEquals(1, ProgrammerUtil.and(mode, -1, 1));
            assertEquals(-1, ProgrammerUtil.and(mode, -1, -1));
        }
    }
}
