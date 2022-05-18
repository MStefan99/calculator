package com.annushkaproject.programmerscalculator.ProgrammerTests

import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProgrammerMultiplicationTest {
    @Test
    fun programmerMultiplicationQWORD_isCorrect() {
        Assert.assertEquals(25, calculateWithData(ProgrammerCalcModel(BigDecimal(5), BigDecimal(5), Operator.MULTIPLY, int_size_enum.l8)))
        Assert.assertEquals(-25, calculateWithData(ProgrammerCalcModel(BigDecimal(-5), BigDecimal(5), Operator.MULTIPLY, int_size_enum.l8)))
        Assert.assertEquals(-0x8000000000000000L, calculateWithData(ProgrammerCalcModel(BigDecimal(0x4000000000000000L), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l8)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000000000000000L), BigDecimal(-0x8000000000000000L), Operator.MULTIPLY, int_size_enum.l8)))
        Assert.assertEquals(-0x2L, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFFFFFFFFFFL), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l8)))
        Assert.assertEquals(0x7FFFFFFFFFFFFFFEL, calculateWithData(ProgrammerCalcModel(BigDecimal(0x3FFFFFFFFFFFFFFFL), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l8)))
    }

    @Test
    fun programmerMultiplicationDWORD_isCorrect() {
        Assert.assertEquals(25, calculateWithData(ProgrammerCalcModel(BigDecimal(5), BigDecimal(5), Operator.MULTIPLY, int_size_enum.l4)))
        Assert.assertEquals(-25, calculateWithData(ProgrammerCalcModel(BigDecimal(-5), BigDecimal(5), Operator.MULTIPLY, int_size_enum.l4)))
        Assert.assertEquals(-0x80000000, calculateWithData(ProgrammerCalcModel(BigDecimal(0x40000000), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l4)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x80000000), BigDecimal(-0x80000000), Operator.MULTIPLY, int_size_enum.l4)))
        Assert.assertEquals(-0x2, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFF), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l4)))
        Assert.assertEquals(0x7FFFFFFE, calculateWithData(ProgrammerCalcModel(BigDecimal(0x3FFFFFFF), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l4)))
    }

    @Test
    fun programmerMultiplicationWORD_isCorrect() {
        Assert.assertEquals(25 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(5), BigDecimal(5), Operator.MULTIPLY, int_size_enum.l2)))
        Assert.assertEquals(-25 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-5), BigDecimal(5), Operator.MULTIPLY, int_size_enum.l2)))
        Assert.assertEquals(0x8000 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x4000), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l2)))
        Assert.assertEquals(0 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x8000), BigDecimal(0x8000), Operator.MULTIPLY, int_size_enum.l2)))
        Assert.assertEquals(0xFFFE as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFF), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l2)))
        Assert.assertEquals(0x7FFE as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x3FFF), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l2)))
    }

    @Test
    fun programmerMultiplicationBYTE_isCorrect() {
        Assert.assertEquals(25 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(5), BigDecimal(5), Operator.MULTIPLY, int_size_enum.l1)))
        Assert.assertEquals(-25 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-5), BigDecimal(5), Operator.MULTIPLY, int_size_enum.l1)))
        Assert.assertEquals(0x80 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x40), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l1)))
        Assert.assertEquals(0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), BigDecimal(0x80), Operator.MULTIPLY, int_size_enum.l1)))
        Assert.assertEquals(0xFE as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7F), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l1)))
        Assert.assertEquals(0x7E as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x3F), BigDecimal(2), Operator.MULTIPLY, int_size_enum.l1)))
    }
}