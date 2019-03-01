package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.model.WordLength;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.XOR;
import static org.junit.Assert.*;

public class ProgrammerXorTest {
    @Test
    public void xorTestAll_isCorrect() {
        for (WordLength mode: WordLength.values()) {
            assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(1), XOR, mode)));
            assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(0), XOR, mode)));
            assertEquals(-2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-1), new Value(1), XOR, mode)));
            assertEquals(-1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-1), new Value(0), XOR, mode)));
        }
    }
}