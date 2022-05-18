package com.annushkaproject.programmerscalculator.StandardTests

import com.annushkaproject.programmerscalculator.model.CalculationModel
import com.annushkaproject.programmerscalculator.model.Operator
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil.calculateResultForTwoSidedOperator
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class StandardMultiplicationTest {
    @Test
    fun testPositiveIntegers() {
        Assert.assertEquals(25.0, calculateResultForTwoSidedOperator(CalculationModel(BigDecimal.valueOf(5), BigDecimal.valueOf(5), Operator.MULTIPLY)), 0.0)
    }

    @Test
    fun testPositiveAndNegativeIntegers() {
        Assert.assertEquals(-25.0, calculateResultForTwoSidedOperator(CalculationModel(BigDecimal.valueOf(-5), BigDecimal.valueOf(5), Operator.MULTIPLY)), 0.0)
    }

    @Test
    fun testDecimalSmall() {
        Assert.assertEquals(0.00001, calculateResultForTwoSidedOperator(CalculationModel(BigDecimal.valueOf(0.000005), BigDecimal.valueOf(2), Operator.MULTIPLY)), 0.0)
    }

    @Test
    fun testFirstDecimalParameter() {
        Assert.assertEquals(3.0, calculateResultForTwoSidedOperator(CalculationModel(BigDecimal.valueOf(1.5), BigDecimal.valueOf(2), Operator.MULTIPLY)), 0.0)
    }

    @Test
    fun testSecondDecimalParameter() {
        Assert.assertEquals(1.0, calculateResultForTwoSidedOperator(CalculationModel(BigDecimal.valueOf(2), BigDecimal.valueOf(0.5), Operator.MULTIPLY)), 0.0)
    }
}