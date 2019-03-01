package com.annushkaproject.programmerscalculator.StandardTests;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

import org.junit.Test;

import static com.annushkaproject.programmerscalculator.model.Operator.DIVIDE;
import static org.junit.Assert.assertEquals;

public class StandardDivisionTest {
    @Test
    public void standardDivision_isCorrect() {
        assertEquals(5, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(25), new Value(5), DIVIDE)), 0); // Integer test
        assertEquals(-5, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(-25), new Value(5), DIVIDE)), 0); // Integer test
        assertEquals(-0.00005, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(-0.0001), new Value(2), DIVIDE)), 0); // Decimal test
        assertEquals(1.5, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(3), new Value(2), DIVIDE)), 0); // Decimal test
        assertEquals(0.5, StandardOperationsUtil.calculateResultForTwoSidedOperator(new CalculationModel(new Value(1), new Value(2), DIVIDE)), 0); // Decimal test
    }
}
