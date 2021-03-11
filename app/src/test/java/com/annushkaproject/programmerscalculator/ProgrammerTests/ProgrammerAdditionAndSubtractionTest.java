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
        assertEquals(10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), ADD, len8)));
        assertEquals(-10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), SUBTRACT, len8)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000000000000000L), new BigDecimal(0x4000000000000000L), SUBTRACT, len8)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), new BigDecimal(0x8000000000000000L), ADD, len8)));
        assertEquals(0x7FFFFFFFFFFFFFFFL, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-0x8000000000000000L), new BigDecimal(1), SUBTRACT, len8)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), new BigDecimal(1), ADD, len8)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFFFFFFFFFFL), new BigDecimal(1), ADD, len8)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000000000000000L), new BigDecimal(0x4000000000000000L), ADD, len8)));
    }

    @Test
    public void programmerAdditionDWORD_isCorrect() {
        assertEquals(10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), ADD, len4)));
        assertEquals(-10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), SUBTRACT, len4)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40000000), new BigDecimal(0x40000000), SUBTRACT, len4)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), new BigDecimal(0x80000000), ADD, len4)));
        assertEquals(0x7FFFFFFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-0x80000000), new BigDecimal(1), SUBTRACT, len4)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), new BigDecimal(1), ADD, len4)));
        assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFF), new BigDecimal(1), ADD, len4)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40000000), new BigDecimal(0x40000000), ADD, len4)));
    }

    @Test
    public void programmerAdditionWORD_isCorrect() {
        assertEquals((short) 10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), ADD, len2)));
        assertEquals((short) -10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), SUBTRACT, len2)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000), new BigDecimal(0x4000), SUBTRACT, len2)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), new BigDecimal(0x8000), ADD, len2)));
        assertEquals((short) 0x7FFF, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-0x8000), new BigDecimal(1), SUBTRACT, len2)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), new BigDecimal(1), ADD, len2)));
        assertEquals((short) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFF), new BigDecimal(1), ADD, len2)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000), new BigDecimal(0x4000), ADD, len2)));
    }

    @Test
    public void programmerAdditionBYTE_isCorrect() {
        assertEquals((byte) 10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), new BigDecimal(5), ADD, len1)));
        assertEquals((byte) -10, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), new BigDecimal(5), SUBTRACT, len1)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40), new BigDecimal(0x40), SUBTRACT, len1)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(0x80), ADD, len1)));
        assertEquals((byte) 0x7F, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), new BigDecimal(1), SUBTRACT, len1)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), new BigDecimal(1), ADD, len1)));
        assertEquals((byte) 0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFF), new BigDecimal(1), ADD, len1)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40), new BigDecimal(0x40), ADD, len1)));
    }
}
