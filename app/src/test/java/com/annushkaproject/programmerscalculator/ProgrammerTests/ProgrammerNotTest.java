package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.int_size_enum;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.NOT;
import static org.junit.Assert.*;

import static com.annushkaproject.programmerscalculator.model.int_size_enum.*;

public class ProgrammerNotTest {
    @Test
    public void notTestBasic_isCorrect() {
        for (int_size_enum mode : int_size_enum.values()) {
            assertEquals(-2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), NOT, mode)));
            assertEquals(-1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0), NOT, mode)));
            assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-1), NOT, mode)));
            assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-2), NOT, mode)));
        }
    }

    @Test
    public void notTestQWORD_isCorrect() {
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), NOT, int_size_enum_kvrd)));
        assertEquals(0x7FFFFFFFFFFFFFFFL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), NOT, int_size_enum_kvrd)));
    }

    @Test
    public void notTestDWORD_isCorrect() {
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), NOT, int_size_enum_dvrd)));
        assertEquals(0x7FFFFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), NOT, int_size_enum_dvrd)));
    }

    @Test
    public void notTestWORD_isCorrect() {
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), NOT, int_size_enum_vrd)));
        assertEquals((short) 0x7FFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), NOT, int_size_enum_vrd)));
    }

    @Test
    public void notTestBYTE_isCorrect() {
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), NOT, int_size_enum_byte)));
        assertEquals((byte) 0x7F, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), NOT, int_size_enum_byte)));
    }
}
