package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.model.WordLength;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.MOD;
import static org.junit.Assert.*;

public class ProgrammerModTest {
    @Test
    public void modTestAll_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(3), new Value(2), MOD, mode)));
            assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(2), new Value(2), MOD, mode)));
            assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0), new Value(2), MOD, mode)));
            assertEquals(-1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-3), new Value(2), MOD, mode)));
            assertEquals(-1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-3), new Value(-2), MOD, mode)));
            assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-2), new Value(-2), MOD, mode)));
        }
    }
}
