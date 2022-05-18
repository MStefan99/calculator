package com.annushkaproject.programmerscalculator.ProgrammerTests

import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProgrammerDivisionTest {
    @Test
    fun programmerDivisionQWORD_isCorrect() {
        Assert.assertEquals(5, calculateWithData(ProgrammerCalcModel(BigDecimal(25), BigDecimal(5), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(-5, calculateWithData(ProgrammerCalcModel(BigDecimal(-25), BigDecimal(5), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(3), BigDecimal(2), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(-0x4000000000000000L, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000000000000000L), BigDecimal(2), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000000000000000L), BigDecimal(-0x8000000000000000L), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(2), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(-0x1L, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x2L), BigDecimal(2), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(0x3FFFFFFFFFFFFFFFL, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFFFFFFFFFEL), BigDecimal(2), Operator.remainder_divide, int_size_enum.l8)))
    }

    @Test
    fun programmerDivisionDWORD_isCorrect() {
        Assert.assertEquals(5, calculateWithData(ProgrammerCalcModel(BigDecimal(25), BigDecimal(5), Operator.remainder_divide, int_size_enum.l4)))
        Assert.assertEquals(-5, calculateWithData(ProgrammerCalcModel(BigDecimal(-25), BigDecimal(5), Operator.remainder_divide, int_size_enum.l4)))
        Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(3), BigDecimal(2), Operator.remainder_divide, int_size_enum.l4)))
        Assert.assertEquals(-0x40000000, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x80000000), BigDecimal(2), Operator.remainder_divide, int_size_enum.l4)))
        Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x80000000), BigDecimal(-0x80000000), Operator.remainder_divide, int_size_enum.l4)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(2), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(-0x1, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x2), BigDecimal(2), Operator.remainder_divide, int_size_enum.l4)))
        Assert.assertEquals(0x3FFFFFFF, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFE), BigDecimal(2), Operator.remainder_divide, int_size_enum.l4)))
    }

    @Test
    fun programmerDivisionWORD_isCorrect() {
        Assert.assertEquals(5 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(25), BigDecimal(5), Operator.remainder_divide, int_size_enum.l2)))
        Assert.assertEquals(-5 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-25), BigDecimal(5), Operator.remainder_divide, int_size_enum.l2)))
        Assert.assertEquals(1 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(3), BigDecimal(2), Operator.remainder_divide, int_size_enum.l2)))
        Assert.assertEquals(0xC000 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x8000), BigDecimal(2), Operator.remainder_divide, int_size_enum.l2)))
        Assert.assertEquals(1 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x8000), BigDecimal(0x8000), Operator.remainder_divide, int_size_enum.l2)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(2), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(0xFFFF as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0xFFFE), BigDecimal(2), Operator.remainder_divide, int_size_enum.l2)))
        Assert.assertEquals(0x3FFF as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFE), BigDecimal(2), Operator.remainder_divide, int_size_enum.l2)))
    }

    @Test
    fun programmerDivisionBYTE_isCorrect() {
        Assert.assertEquals(5 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(25), BigDecimal(5), Operator.remainder_divide, int_size_enum.l1)))
        Assert.assertEquals(-5 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-25), BigDecimal(5), Operator.remainder_divide, int_size_enum.l1)))
        Assert.assertEquals(1 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(3), BigDecimal(2), Operator.remainder_divide, int_size_enum.l1)))
        Assert.assertEquals(0xC0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), BigDecimal(2), Operator.remainder_divide, int_size_enum.l1)))
        Assert.assertEquals(1 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), BigDecimal(0x80), Operator.remainder_divide, int_size_enum.l1)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(2), Operator.remainder_divide, int_size_enum.l8)))
        Assert.assertEquals(0xFF as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0xFE), BigDecimal(2), Operator.remainder_divide, int_size_enum.l1)))
        Assert.assertEquals(0x3F as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7E), BigDecimal(2), Operator.remainder_divide, int_size_enum.l1)))
    }
}