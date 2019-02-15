package com.annushkaproject.programmerscalculator;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.model.WordLength;
import com.annushkaproject.programmerscalculator.utils.ProgrammerUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.OR;
import static org.junit.Assert.*;

public class ProgrammerOrTest {
    @Test
    public void orTestAll_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(0, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(0), new Value(0), OR, mode)));
            assertEquals(1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(0), OR, mode)));
            assertEquals(-1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-1), new Value(1), OR, mode)));
            assertEquals(-1, ProgrammerUtil.calculateWithData(new ProgrammerCalcModel(new Value(-1), new Value(-1), OR, mode)));
        }
    }
}
