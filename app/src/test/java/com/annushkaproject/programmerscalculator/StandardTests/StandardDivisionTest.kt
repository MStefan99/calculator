package com.annushkaproject.programmerscalculator.StandardTests

import com.annushkaproject.programmerscalculator.model.CalculationModel
import com.annushkaproject.programmerscalculator.model.Operator
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil.calculateResultForTwoSidedOperator
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class StandardDivisionTest {
    @Test
    fun testIwoIntegers() {
        val firstValue = BigDecimal.valueOf(25)
        val secondValue = BigDecimal.valueOf(5)
        val model = CalculationModel(firstValue, secondValue, Operator.remainder_divide)
        Assert.assertEquals(5.0, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testIwoIntegersRountResult() {
        val firstValue = BigDecimal.valueOf(5)
        val secondValue = BigDecimal.valueOf(9)
        val model = CalculationModel(firstValue, secondValue, Operator.remainder_divide)
        Assert.assertEquals(0.5555555555555556, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testFirstFloat() {
        val firstValue = BigDecimal.valueOf(-0.0001)
        val secondValue = BigDecimal.valueOf(2)
        val model = CalculationModel(firstValue, secondValue, Operator.remainder_divide)
        Assert.assertEquals(-0.00005, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testFloatResult() {
        val firstValue = BigDecimal.valueOf(3)
        val secondValue = BigDecimal.valueOf(2)
        val model = CalculationModel(firstValue, secondValue, Operator.remainder_divide)
        Assert.assertEquals(1.5, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testFloatResultLessThanOne() {
        val firstValue = BigDecimal.valueOf(1)
        val secondValue = BigDecimal.valueOf(2)
        val model = CalculationModel(firstValue, secondValue, Operator.remainder_divide)
        Assert.assertEquals(0.5, calculateResultForTwoSidedOperator(model), 0.0)
    }
}