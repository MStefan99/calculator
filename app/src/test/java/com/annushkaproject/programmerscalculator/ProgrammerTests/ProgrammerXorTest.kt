package com.annushkaproject.programmerscalculator.ProgrammerTests

import com.annushkaproject.programmerscalculator.model.Operator
import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel
import com.annushkaproject.programmerscalculator.model.int_size_enum
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ProgrammerXorTest {
    @Test
    fun xorTestAll_isCorrect() {
        for (mode in int_size_enum.values()) {
            Assert.assertEquals(0, calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(1), Operator.XOR, mode)))
            Assert.assertEquals(1, calculateWithData(ProgrammerCalcModel(BigDecimal(1), BigDecimal(0), Operator.XOR, mode)))
            Assert.assertEquals(-2, calculateWithData(ProgrammerCalcModel(BigDecimal(-1), BigDecimal(1), Operator.XOR, mode)))
            Assert.assertEquals(-1, calculateWithData(ProgrammerCalcModel(BigDecimal(-1), BigDecimal(0), Operator.XOR, mode)))
        }
    }
}