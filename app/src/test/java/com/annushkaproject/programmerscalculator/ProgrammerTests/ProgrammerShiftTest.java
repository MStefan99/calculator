package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.LSH;
import static com.annushkaproject.programmerscalculator.model.Operator.RSH;
import static org.junit.Assert.*;

import static com.annushkaproject.programmerscalculator.model.int_size_enum.*;

public class ProgrammerShiftTest {
    @Test
    public void lshTestQWORD_isCorrect() {
        assertEquals(0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, int_size_enum_kvrd)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(63), LSH, int_size_enum_kvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(1), LSH, int_size_enum_kvrd)));
    }

    @Test
    public void lshTestDWORD_isCorrect() {
        assertEquals(0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, int_size_enum_dvrd)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(31), LSH, int_size_enum_dvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(1), LSH, int_size_enum_dvrd)));
    }

    @Test
    public void lshTestWORD_isCorrect() {
        assertEquals((short) 0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, int_size_enum_vrd)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(15), LSH, int_size_enum_vrd)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(1), LSH, int_size_enum_vrd)));
    }

    @Test
    public void lshTestBYTE_isCorrect() {
        assertEquals((byte) 0x2, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(1), LSH, int_size_enum_byte)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x1), new BigDecimal(7), LSH, int_size_enum_byte)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(1), LSH, int_size_enum_byte)));
    }

    @Test
    public void rshTestQWORD_isCorrect() {
        assertEquals(0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, int_size_enum_kvrd)));
        assertEquals(0xFFFFFFFFFFFFFFFFL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(63), RSH, int_size_enum_kvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), new BigDecimal(63), RSH, int_size_enum_kvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, int_size_enum_kvrd)));
    }

    @Test
    public void rshTestDWORD_isCorrect() {
        assertEquals(0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, int_size_enum_dvrd)));
        assertEquals(0xFFFFFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(31), RSH, int_size_enum_dvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), new BigDecimal(31), RSH, int_size_enum_dvrd)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, int_size_enum_dvrd)));
    }

    @Test
    public void rshTestWORD_isCorrect() {
        assertEquals((short) 0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, int_size_enum_vrd)));
        assertEquals((short) 0xFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(15), RSH, int_size_enum_vrd)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), new BigDecimal(15), RSH, int_size_enum_vrd)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, int_size_enum_vrd)));
    }

    @Test
    public void rshTestBYTE_isCorrect() {
        assertEquals((byte) 0x1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x2), new BigDecimal(1), RSH, int_size_enum_byte)));
        assertEquals((byte) 0xFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(7), RSH, int_size_enum_byte)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), new BigDecimal(7), RSH, int_size_enum_byte)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(1), RSH, int_size_enum_byte)));
    }
}
