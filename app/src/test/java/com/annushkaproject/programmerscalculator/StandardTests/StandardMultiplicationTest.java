package com.annushkaproject.programmerscalculator.StandardTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.MULTIPLY;
import static com.annushkaproject.programmerscalculator.model.WordLength.QWORD;
import static org.junit.Assert.assertEquals;

public class StandardMultiplicationTest {
    @Test
    public void programmerMultiplicationQWORD_isCorrect() {
        assertEquals(25, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(5), new Value(5), MULTIPLY, QWORD)), 0);
        assertEquals(-25, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(-5), new Value(5), MULTIPLY, QWORD)), 0);
        assertEquals(0.00001, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(0.000005), new Value(2), MULTIPLY, QWORD)), 0);
        assertEquals(3, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(1.5), new Value(2), MULTIPLY, QWORD)), 0);
        assertEquals(1, StandardOperationsUtil.calculateWithData(new ProgrammerCalcModel(new Value(2), new Value(0.5), MULTIPLY, QWORD)), 0);
    }
}
