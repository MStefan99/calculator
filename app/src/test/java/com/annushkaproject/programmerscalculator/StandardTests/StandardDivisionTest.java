package com.annushkaproject.programmerscalculator.StandardTests;

import android.database.sqlite.SQLiteBlobTooBigException;

import com.annushkaproject.programmerscalculator.model.CalculationModel;
import com.annushkaproject.programmerscalculator.model.Value;
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.DIVIDE;
import static org.junit.Assert.assertEquals;

public class StandardDivisionTest {
    @Test
    public void testIwoIntegers() {
        BigDecimal firstValue = BigDecimal.valueOf(25);
        BigDecimal secondValue = BigDecimal.valueOf(5);
        CalculationModel model = new CalculationModel(firstValue, secondValue, DIVIDE);
        assertEquals(5, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

    @Test
    public void testFirstFloat() {
        BigDecimal firstValue = BigDecimal.valueOf(-0.0001);
        BigDecimal secondValue = BigDecimal.valueOf(2);
        CalculationModel model = new CalculationModel(firstValue, secondValue, DIVIDE);
        assertEquals(-0.00005, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

    @Test
    public void testFloatResult() {
        BigDecimal firstValue = BigDecimal.valueOf(3);
        BigDecimal secondValue = BigDecimal.valueOf(2);
        CalculationModel model = new CalculationModel(firstValue, secondValue, DIVIDE);
        assertEquals(1.5, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }

    @Test
    public void testFloatResultLessThanOne() {
        BigDecimal firstValue = BigDecimal.valueOf(1);
        BigDecimal secondValue = BigDecimal.valueOf(2);
        CalculationModel model = new CalculationModel(firstValue, secondValue, DIVIDE);
        assertEquals(0.5, StandardOperationsUtil.calculateResultForTwoSidedOperator(model), 0);
    }
}
