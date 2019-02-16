package com.annushkaproject.programmerscalculator.StandardTests;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.ADD;
import static com.annushkaproject.programmerscalculator.model.Operator.SUBTRACT;
import static org.junit.Assert.assertEquals;

public class StandardAdditionAndSubtractionTest {
    @Test
    public void standardAddition_isCorrect() {
        assertEquals(10, StandardOperationsUtil.calculateWithData(new CalculationModel(new Value(5), new Value(5), ADD)), 0);
        assertEquals(-10, StandardOperationsUtil.calculateWithData(new CalculationModel(new Value(-5), new Value(5), SUBTRACT)), 0);
        assertEquals(-0.888, StandardOperationsUtil.calculateWithData(new CalculationModel(new Value(1.112), new Value(2), SUBTRACT)), 0.000001);
        assertEquals(0, StandardOperationsUtil.calculateWithData(new CalculationModel(new Value(0x4000000000000000L), new Value(0x4000000000000000L), SUBTRACT)), 0);
        assertEquals(-9.223372036854776E18, StandardOperationsUtil.calculateWithData(new CalculationModel(new Value(-0x8000000000000000L), new Value(1), SUBTRACT)), 0);
        assertEquals(9.223372036854776E18, StandardOperationsUtil.calculateWithData(new CalculationModel(new Value(0x7FFFFFFFFFFFFFFFL), new Value(1), ADD)), 0);
        assertEquals(9.223372036854776E18, StandardOperationsUtil.calculateWithData(new CalculationModel(new Value(0x4000000000000000L), new Value(0x4000000000000000L), ADD)), 0);
    }
}
