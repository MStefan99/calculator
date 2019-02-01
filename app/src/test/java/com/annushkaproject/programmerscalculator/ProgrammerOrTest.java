package com.annushkaproject.programmerscalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProgrammerOrTest {
    @Test
    public void orTestAll_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(0, ProgrammerUtil.or(mode, 0, 0));
            assertEquals(1, ProgrammerUtil.or(mode, 1, 0));
            assertEquals(-1, ProgrammerUtil.or(mode, -1, 1));
            assertEquals(-1, ProgrammerUtil.or(mode, -1, -1));
        }
    }
}
