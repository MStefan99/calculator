package com.annushkaproject.programmerscalculator.ProgrammerTests

import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProgrammerAdditionAndSubtractionTest {
    @Test
    fun programmerAdditionQWORD_isCorrect() {
        Assert.assertEquals(10, calculateWithData(ProgrammerCalcModel(BigDecimal(5), BigDecimal(5), Operator.ADD, int_size_enum.l8)))
        Assert.assertEquals(-10, calculateWithData(ProgrammerCalcModel(BigDecimal(-5), BigDecimal(5), Operator.SUBTRACT, int_size_enum.l8)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(0x4000000000000000L), BigDecimal(0x4000000000000000L), Operator.SUBTRACT, int_size_enum.l8)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000000000000000L), BigDecimal(-0x8000000000000000L), Operator.ADD, int_size_enum.l8)))
        Assert.assertEquals(0x7FFFFFFFFFFFFFFFL, calculateWithData(ProgrammerCalcModel(BigDecimal(--0x8000000000000000L), BigDecimal(1), Operator.SUBTRACT, int_size_enum.l8)))
        Assert.assertEquals(-0x8000000000000000L, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFFFFFFFFFFL), BigDecimal(1), Operator.ADD, int_size_enum.l8)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x1L), BigDecimal(1), Operator.ADD, int_size_enum.l8)))
        Assert.assertEquals(-0x8000000000000000L, calculateWithData(ProgrammerCalcModel(BigDecimal(0x4000000000000000L), BigDecimal(0x4000000000000000L), Operator.ADD, int_size_enum.l8)))
    }

    @Test
    fun programmerAdditionDWORD_isCorrect() {
        Assert.assertEquals(10, calculateWithData(ProgrammerCalcModel(BigDecimal(5), BigDecimal(5), Operator.ADD, int_size_enum.l4)))
        Assert.assertEquals(-10, calculateWithData(ProgrammerCalcModel(BigDecimal(-5), BigDecimal(5), Operator.SUBTRACT, int_size_enum.l4)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(0x40000000), BigDecimal(0x40000000), Operator.SUBTRACT, int_size_enum.l4)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x80000000), BigDecimal(-0x80000000), Operator.ADD, int_size_enum.l4)))
        Assert.assertEquals(0x7FFFFFFF, calculateWithData(ProgrammerCalcModel(BigDecimal(--0x80000000), BigDecimal(1), Operator.SUBTRACT, int_size_enum.l4)))
        Assert.assertEquals(-0x80000000, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFF), BigDecimal(1), Operator.ADD, int_size_enum.l4)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x1), BigDecimal(1), Operator.ADD, int_size_enum.l4)))
        Assert.assertEquals(-0x80000000, calculateWithData(ProgrammerCalcModel(BigDecimal(0x40000000), BigDecimal(0x40000000), Operator.ADD, int_size_enum.l4)))
    }

    @Test
    fun programmerAdditionWORD_isCorrect() {
        Assert.assertEquals(10 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(5), BigDecimal(5), Operator.ADD, int_size_enum.l2)))
        Assert.assertEquals(-10 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-5), BigDecimal(5), Operator.SUBTRACT, int_size_enum.l2)))
        Assert.assertEquals(0 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x4000), BigDecimal(0x4000), Operator.SUBTRACT, int_size_enum.l2)))
        Assert.assertEquals(0 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x8000), BigDecimal(0x8000), Operator.ADD, int_size_enum.l2)))
        Assert.assertEquals(0x7FFF as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000), BigDecimal(1), Operator.SUBTRACT, int_size_enum.l2)))
        Assert.assertEquals(0x8000 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFF), BigDecimal(1), Operator.ADD, int_size_enum.l2)))
        Assert.assertEquals(0 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0xFFFF), BigDecimal(1), Operator.ADD, int_size_enum.l2)))
        Assert.assertEquals(0x8000 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x4000), BigDecimal(0x4000), Operator.ADD, int_size_enum.l2)))
    }

    @Test
    fun programmerAdditionBYTE_isCorrect() {
        Assert.assertEquals(10 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(5), BigDecimal(5), Operator.ADD, int_size_enum.l1)))
        Assert.assertEquals(-10 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-5), BigDecimal(5), Operator.SUBTRACT, int_size_enum.l1)))
        Assert.assertEquals(0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x40), BigDecimal(0x40), Operator.SUBTRACT, int_size_enum.l1)))
        Assert.assertEquals(0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), BigDecimal(0x80), Operator.ADD, int_size_enum.l1)))
        Assert.assertEquals(0x7F as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), BigDecimal(1), Operator.SUBTRACT, int_size_enum.l1)))
        Assert.assertEquals(0x80 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7F), BigDecimal(1), Operator.ADD, int_size_enum.l1)))
        Assert.assertEquals(0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0xFF), BigDecimal(1), Operator.ADD, int_size_enum.l1)))
        Assert.assertEquals(0x80 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x40), BigDecimal(0x40), Operator.ADD, int_size_enum.l1)))
    }
}