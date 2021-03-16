package com.annushkaproject.programmerscalculator.ProgrammerTests

import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProgrammerNotTest {
    @Test
    fun notTestBasic_isCorrect() {
        for (mode in int_size_enum.values()) {
            Assert.assertEquals(-2, calculateWithData(ProgrammerCalcModel(BigDecimal(1), Operator.NOT, mode)))
            Assert.assertEquals(-1, calculateWithData(ProgrammerCalcModel(BigDecimal(0), Operator.NOT, mode)))
            Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-1), Operator.NOT, mode)))
            Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(-2), Operator.NOT, mode)))
        }
    }

    @Test
    fun notTestQWORD_isCorrect() {
        Assert.assertEquals(-0x8000000000000000L, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFFFFFFFFFFL), Operator.NOT, int_size_enum.l8)))
        Assert.assertEquals(0x7FFFFFFFFFFFFFFFL, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x8000000000000000L), Operator.NOT, int_size_enum.l8)))
    }

    @Test
    fun notTestDWORD_isCorrect() {
        Assert.assertEquals(-0x80000000, calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFFFFFF), Operator.NOT, int_size_enum.l4)))
        Assert.assertEquals(0x7FFFFFFF, calculateWithData(ProgrammerCalcModel(BigDecimal(-0x80000000), Operator.NOT, int_size_enum.l4)))
    }

    @Test
    fun notTestWORD_isCorrect() {
        Assert.assertEquals(0x8000 as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7FFF), Operator.NOT, int_size_enum.l2)))
        Assert.assertEquals(0x7FFF as Short.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x8000), Operator.NOT, int_size_enum.l2)))
    }

    @Test
    fun notTestBYTE_isCorrect() {
        Assert.assertEquals(0x80 as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x7F), Operator.NOT, int_size_enum.l1)))
        Assert.assertEquals(0x7F as Byte.toLong(), calculateWithData(ProgrammerCalcModel(BigDecimal(0x80), Operator.NOT, int_size_enum.l1)))
    }
}