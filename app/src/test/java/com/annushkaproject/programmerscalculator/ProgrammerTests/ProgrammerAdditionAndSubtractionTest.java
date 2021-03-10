package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.ADD;
import static com.annushkaproject.programmerscalculator.model.Operator.SUBTRACT;
import static com.annushkaproject.programmerscalculator.model.int_size_enum.*;
import static org.junit.Assert.*;

public class ProgrammerAdditionAndSubtractionTest {
    @Test
    public void programmerAdditionQWORD_isCorrect() {
        assertEquals(10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), ADD, int_size_enum_kvrd)));
        assertEquals(-10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), SUBTRACT, int_size_enum_kvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000000000000000L), new BigDecimal(0x4000000000000000L), SUBTRACT, int_size_enum_kvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(0x8000000000000000L), ADD, int_size_enum_kvrd)));
        assertEquals(0x7FFFFFFFFFFFFFFFL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-0x8000000000000000L), new BigDecimal(1), SUBTRACT, int_size_enum_kvrd)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), new BigDecimal(1), ADD, int_size_enum_kvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFFFFFFFFFFL), new BigDecimal(1), ADD, int_size_enum_kvrd)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000000000000000L), new BigDecimal(0x4000000000000000L), ADD, int_size_enum_kvrd)));
    }

    @Test
    public void programmerAdditionDWORD_isCorrect() {
        assertEquals(10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), ADD, int_size_enum_dvrd)));
        assertEquals(-10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), SUBTRACT, int_size_enum_dvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40000000), new BigDecimal(0x40000000), SUBTRACT, int_size_enum_dvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(0x80000000), ADD, int_size_enum_dvrd)));
        assertEquals(0x7FFFFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-0x80000000), new BigDecimal(1), SUBTRACT, int_size_enum_dvrd)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), new BigDecimal(1), ADD, int_size_enum_dvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFF), new BigDecimal(1), ADD, int_size_enum_dvrd)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40000000), new BigDecimal(0x40000000), ADD, int_size_enum_dvrd)));
    }

    @Test
    public void programmerAdditionWORD_isCorrect() {
        assertEquals((short) 10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), ADD, int_size_enum_vrd)));
        assertEquals((short) -10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), SUBTRACT, int_size_enum_vrd)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000), new BigDecimal(0x4000), SUBTRACT, int_size_enum_vrd)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(0x8000), ADD, int_size_enum_vrd)));
        assertEquals((short) 0x7FFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-0x8000), new BigDecimal(1), SUBTRACT, int_size_enum_vrd)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), new BigDecimal(1), ADD, int_size_enum_vrd)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFF), new BigDecimal(1), ADD, int_size_enum_vrd)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000), new BigDecimal(0x4000), ADD, int_size_enum_vrd)));
    }

    @Test
    public void programmerAdditionBYTE_isCorrect() {
        assertEquals((byte) 10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), ADD, int_size_enum_byte)));
        assertEquals((byte) -10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), SUBTRACT, int_size_enum_byte)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40), new BigDecimal(0x40), SUBTRACT, int_size_enum_byte)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(0x80), ADD, int_size_enum_byte)));
        assertEquals((byte) 0x7F, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(1), SUBTRACT, int_size_enum_byte)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), new BigDecimal(1), ADD, int_size_enum_byte)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFF), new BigDecimal(1), ADD, int_size_enum_byte)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40), new BigDecimal(0x40), ADD, int_size_enum_byte)));
    }
}
