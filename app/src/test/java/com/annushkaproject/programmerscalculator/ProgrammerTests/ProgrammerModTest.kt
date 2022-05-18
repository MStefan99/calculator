package com.annushkaproject.programmerscalculator.ProgrammerTests

import com.annushkaproject.programmerscalculator.model.Operator
import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel
import com.annushkaproject.programmerscalculator.model.int_size_enum
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProgrammerModTest {
    @Test
    fun modTestAll_isCorrect() {
        for (mode in int_size_enum.values()) {
            Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(3), BigDecimal(2), Operator.get_remainder, mode)))
            Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(2), BigDecimal(2), Operator.get_remainder, mode)))
            Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(0), BigDecimal(2), Operator.get_remainder, mode)))
            Assert.assertEquals(-1, calculateWithData(ProgrammerCalcModel(BigDecimal(-3), BigDecimal(2), Operator.get_remainder, mode)))
            Assert.assertEquals(-1, calculateWithData(ProgrammerCalcModel(BigDecimal(-3), BigDecimal(-2), Operator.get_remainder, mode)))
            Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(-2), BigDecimal(-2), Operator.get_remainder, mode)))
        }
    }
}