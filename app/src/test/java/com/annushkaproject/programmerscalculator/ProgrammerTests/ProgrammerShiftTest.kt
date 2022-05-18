package com.annushkaproject.programmerscalculator.ProgrammerTests

import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProgrammerShiftTest {
    @Test
    fun lshTestQWORD_isCorrect() {
        Assert.assertEquals(0x2, calculateWithData(ProgrammerCalcModel(BigDecimal(0x1), BigDecimal(1), Operator.LSH, int_size_enum.l8)))
        Assert.assertEquals(-0x8000000000000000L, calculateWithData(ProgrammerCalcModel(BigDecimal(0x1), BigDecimal(63), Operator.LSH, int_size_enum.l8)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000000000000000L), BigDecimal(1), Operator.LSH, int_size_enum.l8)))
    }

    @Test
    fun lshTestDWORD_isCorrect() {
        Assert.assertEquals(0x2, calculateWithData(ProgrammerCalcModel(BigDecimal(0x1), BigDecimal(1), Operator.LSH, int_size_enum.l4)))
        Assert.assertEquals(-0x80000000, calculateWithData(ProgrammerCalcModel(BigDecimal(0x1), BigDecimal(31), Operator.LSH, int_size_enum.l4)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x80000000), BigDecimal(1), Operator.LSH, int_size_enum.l4)))
    }

    @Test
    fun lshTestWORD_isCorrect() {
        Assert.assertEquals(0x2 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x1), BigDecimal(1), Operator.LSH, int_size_enum.l2)))
        Assert.assertEquals(0x8000 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x1), BigDecimal(15), Operator.LSH, int_size_enum.l2)))
        Assert.assertEquals(0 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x8000), BigDecimal(1), Operator.LSH, int_size_enum.l2)))
    }

    @Test
    fun lshTestBYTE_isCorrect() {
        Assert.assertEquals(0x2 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x1), BigDecimal(1), Operator.LSH, int_size_enum.l1)))
        Assert.assertEquals(0x80 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x1), BigDecimal(7), Operator.LSH, int_size_enum.l1)))
        Assert.assertEquals(0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), BigDecimal(1), Operator.LSH, int_size_enum.l1)))
    }

    @Test
    fun rshTestQWORD_isCorrect() {
        Assert.assertEquals(0x1, calculateWithData(ProgrammerCalcModel(BigDecimal(0x2), BigDecimal(1), Operator.RSH, int_size_enum.l8)))
        Assert.assertEquals(-0x1L, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000000000000000L), BigDecimal(63), Operator.RSH, int_size_enum.l8)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFFFFFFFFFFL), BigDecimal(63), Operator.RSH, int_size_enum.l8)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(1), Operator.RSH, int_size_enum.l8)))
    }

    @Test
    fun rshTestDWORD_isCorrect() {
        Assert.assertEquals(0x1, calculateWithData(ProgrammerCalcModel(BigDecimal(0x2), BigDecimal(1), Operator.RSH, int_size_enum.l4)))
        Assert.assertEquals(-0x1, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x80000000), BigDecimal(31), Operator.RSH, int_size_enum.l4)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFF), BigDecimal(31), Operator.RSH, int_size_enum.l4)))
        Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(1), Operator.RSH, int_size_enum.l4)))
    }

    @Test
    fun rshTestWORD_isCorrect() {
        Assert.assertEquals(0x1 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x2), BigDecimal(1), Operator.RSH, int_size_enum.l2)))
        Assert.assertEquals(0xFFFF as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x8000), BigDecimal(15), Operator.RSH, int_size_enum.l2)))
        Assert.assertEquals(0 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFF), BigDecimal(15), Operator.RSH, int_size_enum.l2)))
        Assert.assertEquals(0 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(1), Operator.RSH, int_size_enum.l2)))
    }

    @Test
    fun rshTestBYTE_isCorrect() {
        Assert.assertEquals(0x1 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x2), BigDecimal(1), Operator.RSH, int_size_enum.l1)))
        Assert.assertEquals(0xFF as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), BigDecimal(7), Operator.RSH, int_size_enum.l1)))
        Assert.assertEquals(0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7F), BigDecimal(7), Operator.RSH, int_size_enum.l1)))
        Assert.assertEquals(0 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(1), Operator.RSH, int_size_enum.l1)))
    }
}