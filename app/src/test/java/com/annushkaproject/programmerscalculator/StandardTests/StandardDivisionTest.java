package com.annushkaproject.programmerscalculator.StandardTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.DIVIDE;
import static com.annushkaproject.programmerscalculator.model.WordLength.QWORD;
import static org.junit.Assert.assertEquals;

public class StandardDivisionTest {
    @Test
    public void standardDivision_isCorrect() {
        assertEquals(5, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(25), new Value(5), DIVIDE, QWORD)), 0);
        assertEquals(-5, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-25), new Value(5), DIVIDE, QWORD)), 0);
        assertEquals(-0.00005, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-0.0001), new Value(2), DIVIDE, QWORD)), 0);
        assertEquals(1.5, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(3), new Value(2), DIVIDE, QWORD)), 0);
        assertEquals(0.5, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(1), new Value(2), DIVIDE, QWORD)), 0);
    }
}
