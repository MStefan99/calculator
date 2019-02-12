package com.annushkaproject.programmerscalculator;

import com.annushkaproject.programmerscalculator.model.WordLength;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProgrammerModTest {
    @Test
    public void modTestAll_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(1, ProgrammerUtil.mod(mode, 3, 2));
            assertEquals(0, ProgrammerUtil.mod(mode, 2, 2));
            assertEquals(0, ProgrammerUtil.mod(mode, 0, 2));
            assertEquals(-1, ProgrammerUtil.mod(mode, -3, 2));
            assertEquals(-1, ProgrammerUtil.mod(mode, -3, -2));
            assertEquals(0, ProgrammerUtil.mod(mode, -2, -2));
        }
    }
}
