package com.annushkaproject.programmerscalculator.StandardTests;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.ADD;
import static com.annushkaproject.programmerscalculator.model.Operator.SUBTRACT;
import static org.junit.Assert.assertEquals;

public class StandardAdditionAndSubtractionTest {

    @Test
    public void testAddIwoIntegers() {
        BigDecimal firstValue = BigDecimal.valueOf(5);
        BigDecimal secondValue = BigDecimal.valueOf(5);
        CalculationModel model = new CalculationModel(firstValue, secondValue, ADD);
        assertEquals(10, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

    @Test
    public void testSubtractIwoIntegers() {
        BigDecimal firstValue = BigDecimal.valueOf(-5);
        BigDecimal secondValue = BigDecimal.valueOf(5);
        CalculationModel model = new CalculationModel(firstValue, secondValue, SUBTRACT);
        assertEquals(-10, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

    @Test
    public void testSubtractFloatAndDecimal() {
        BigDecimal firstValue = BigDecimal.valueOf(1.112);
        BigDecimal secondValue = BigDecimal.valueOf(2);
        CalculationModel model = new CalculationModel(firstValue, secondValue, SUBTRACT);
        assertEquals(-0.888, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0.000001);
    }

    @Test
    public void testUnderflow() {
        BigDecimal firstValue = BigDecimal.valueOf(-0x8000000000000000L);
        BigDecimal secondValue = BigDecimal.valueOf(1);
        CalculationModel model = new CalculationModel(firstValue, secondValue, SUBTRACT);
        assertEquals(-9.223372036854776E18, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

    @Test
    public void testOverflow() {
        BigDecimal firstValue = BigDecimal.valueOf(0x7FFFFFFFFFFFFFFFL);
        BigDecimal secondValue = BigDecimal.valueOf(1);
        CalculationModel model = new CalculationModel(firstValue, secondValue, ADD);
        assertEquals(9.223372036854776E18, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

    @Test
    public void testOverflowSameValues() {
        BigDecimal firstValue = BigDecimal.valueOf(0x4000000000000000L);
        BigDecimal secondValue = BigDecimal.valueOf(0x4000000000000000L);
        CalculationModel model = new CalculationModel(firstValue, secondValue, ADD);
        assertEquals(9.223372036854776E18, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

    @Test
    public void testUnderflowSameValues() {
        BigDecimal firstValue = BigDecimal.valueOf(0x4000000000000000L);
        BigDecimal secondValue = BigDecimal.valueOf(0x4000000000000000L);
        CalculationModel model = new CalculationModel(firstValue, secondValue, SUBTRACT);
        assertEquals(0, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

}
