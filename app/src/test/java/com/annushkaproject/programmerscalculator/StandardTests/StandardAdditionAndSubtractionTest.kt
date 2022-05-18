package com.annushkaproject.programmerscalculator.StandardTests

import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil.calculateResultForTwoSidedOperator
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class StandardAdditionAndSubtractionTest {
    @Test
    fun testAddIwoIntegers() {
        val firstValue = BigDecimal.valueOf(5)
        val secondValue = BigDecimal.valueOf(5)
        val model = CalculationModel(firstValue, secondValue, Operator.ADD)
        Assert.assertEquals(10.0, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testSubtractIwoIntegers() {
        val firstValue = BigDecimal.valueOf(-5)
        val secondValue = BigDecimal.valueOf(5)
        val model = CalculationModel(firstValue, secondValue, Operator.SUBTRACT)
        Assert.assertEquals(-10.0, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testSubtractFloatAndDecimal() {
        val firstValue = BigDecimal.valueOf(1.112)
        val secondValue = BigDecimal.valueOf(2)
        val model = CalculationModel(firstValue, secondValue, Operator.SUBTRACT)
        Assert.assertEquals(-0.888, calculateResultForTwoSidedOperator(model), 0.000001)
    }

    @Test
    fun testUnderflow() {
        val firstValue: BigDecimal = BigDecimal.valueOf(--0x8000000000000000L)
        val secondValue = BigDecimal.valueOf(1)
        val model = CalculationModel(firstValue, secondValue, Operator.SUBTRACT)
        Assert.assertEquals(-9.223372036854776E18, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testOverflow() {
        val firstValue = BigDecimal.valueOf(0x7FFFFFFFFFFFFFFFL)
        val secondValue = BigDecimal.valueOf(1)
        val model = CalculationModel(firstValue, secondValue, Operator.ADD)
        Assert.assertEquals(9.223372036854776E18, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testOverflowSameValues() {
        val firstValue = BigDecimal.valueOf(0x4000000000000000L)
        val secondValue = BigDecimal.valueOf(0x4000000000000000L)
        val model = CalculationModel(firstValue, secondValue, Operator.ADD)
        Assert.assertEquals(9.223372036854776E18, calculateResultForTwoSidedOperator(model), 0.0)
    }

    @Test
    fun testUnderflowSameValues() {
        val firstValue = BigDecimal.valueOf(0x4000000000000000L)
        val secondValue = BigDecimal.valueOf(0x4000000000000000L)
        val model = CalculationModel(firstValue, secondValue, Operator.SUBTRACT)
        Assert.assertEquals(0.0, calculateResultForTwoSidedOperator(model), 0.0)
    }
}