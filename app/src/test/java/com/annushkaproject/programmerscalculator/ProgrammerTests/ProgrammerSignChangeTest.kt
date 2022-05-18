package com.annushkaproject.programmerscalculator.ProgrammerTests

import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProgrammerSignChangeTest {
    @Test
    fun programmerSignChangeQWORD_isCorrect() {
        Assert.assertEquals(-5, calculateWithData(ProgrammerCalcModel(BigDecimal(5), Operator.CHANGE_SIGN, int_size_enum.l8)))
        Assert.assertEquals(5, calculateWithData(ProgrammerCalcModel(BigDecimal(-5), Operator.CHANGE_SIGN, int_size_enum.l8)))
        Assert.assertEquals(-0x4000000000000000L, calculateWithData(ProgrammerCalcModel(BigDecimal(0x4000000000000000L), Operator.CHANGE_SIGN, int_size_enum.l8)))
        Assert.assertEquals(-0x8000000000000000L, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000000000000000L), Operator.CHANGE_SIGN, int_size_enum.l8)))
        Assert.assertEquals(-0x7fffffffffffffffL, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFFFFFFFFFFL), Operator.CHANGE_SIGN, int_size_enum.l8)))
        Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x1L), Operator.CHANGE_SIGN, int_size_enum.l8)))
    }

    @Test
    fun programmerSignChangeDWORD_isCorrect() {
        Assert.assertEquals(-5, calculateWithData(ProgrammerCalcModel(BigDecimal(5), Operator.CHANGE_SIGN, int_size_enum.l4)))
        Assert.assertEquals(5, calculateWithData(ProgrammerCalcModel(BigDecimal(-5), Operator.CHANGE_SIGN, int_size_enum.l4)))
        Assert.assertEquals(-0x40000000, calculateWithData(ProgrammerCalcModel(BigDecimal(0x40000000), Operator.CHANGE_SIGN, int_size_enum.l4)))
        Assert.assertEquals(-0x80000000, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x80000000), Operator.CHANGE_SIGN, int_size_enum.l4)))
        Assert.assertEquals(-0x7fffffff, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFF), Operator.CHANGE_SIGN, int_size_enum.l4)))
        Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x1), Operator.CHANGE_SIGN, int_size_enum.l4)))
    }

    @Test
    fun programmerSignChangeWORD_isCorrect() {
        Assert.assertEquals(-5 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(5), Operator.CHANGE_SIGN, int_size_enum.l2)))
        Assert.assertEquals(5 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-5), Operator.CHANGE_SIGN, int_size_enum.l2)))
        Assert.assertEquals(0xC000 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x4000), Operator.CHANGE_SIGN, int_size_enum.l2)))
        Assert.assertEquals(0x8000 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x8000), Operator.CHANGE_SIGN, int_size_enum.l2)))
        Assert.assertEquals(0x8001 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFF), Operator.CHANGE_SIGN, int_size_enum.l2)))
        Assert.assertEquals(1 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0xFFFF), Operator.CHANGE_SIGN, int_size_enum.l2)))
    }

    @Test
    fun programmerSignChangeBYTE_isCorrect() {
        Assert.assertEquals(-5 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(5), Operator.CHANGE_SIGN, int_size_enum.l1)))
        Assert.assertEquals(5 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(-5), Operator.CHANGE_SIGN, int_size_enum.l1)))
        Assert.assertEquals(0xC0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x40), Operator.CHANGE_SIGN, int_size_enum.l1)))
        Assert.assertEquals(0x80 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), Operator.CHANGE_SIGN, int_size_enum.l1)))
        Assert.assertEquals(0x81 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7F), Operator.CHANGE_SIGN, int_size_enum.l1)))
        Assert.assertEquals(1 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0xFF), Operator.CHANGE_SIGN, int_size_enum.l1)))
    }
}