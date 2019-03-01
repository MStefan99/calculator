package com.annushkaproject.programmerscalculator.StandardTests;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.MULTIPLY;
import static org.junit.Assert.assertEquals;

public class StandardMultiplicationTest {
    @Test
    public void standardMultiplication_isCorrect() {
        assertEquals(25, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(5), new Value(5), MULTIPLY)), 0); // Integer test
        assertEquals(-25, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(-5), new Value(5), MULTIPLY)), 0); // Integer test
        assertEquals(0.00001, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(0.000005), new Value(2), MULTIPLY)), 0); // Decimal test
        assertEquals(3, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(1.5), new Value(2), MULTIPLY)), 0); // Decimal test
        assertEquals(1, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(2), new Value(0.5), MULTIPLY)), 0); // Decimal test
    }
}
