package com.annushkaproject.programmerscalculator.ProgrammerTests;


import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.CHANGE_SIGN;
import static com.annushkaproject.programmerscalculator.model.WordLength.*;
import static org.junit.Assert.*;

public class ProgrammerSignChangeTest {
    @Test
    public void programmerSignChangeQWORD_isCorrect() {
        assertEquals(-5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), CHANGE_SIGN, QWORD)));
        assertEquals(5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), CHANGE_SIGN, QWORD)));
        assertEquals(0xC000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000000000000000L), CHANGE_SIGN, QWORD)));
        assertEquals(0x8000000000000000L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000000000000000L), CHANGE_SIGN, QWORD)));
        assertEquals(0x8000000000000001L, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFFFFFFFFFFL), CHANGE_SIGN, QWORD)));
        assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFFFFFFFFFFL), CHANGE_SIGN, QWORD)));
    }

    @Test
    public void programmerSignChangeDWORD_isCorrect() {
        assertEquals(-5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), CHANGE_SIGN, DWORD)));
        assertEquals(5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), CHANGE_SIGN, DWORD)));
        assertEquals(0xC0000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40000000), CHANGE_SIGN, DWORD)));
        assertEquals(0x80000000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80000000), CHANGE_SIGN, DWORD)));
        assertEquals(0x80000001, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFFFFFF), CHANGE_SIGN, DWORD)));
        assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFFFFFF), CHANGE_SIGN, DWORD)));
    }

    @Test
    public void programmerSignChangeWORD_isCorrect() {
        assertEquals((short) -5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), CHANGE_SIGN, WORD)));
        assertEquals((short) 5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), CHANGE_SIGN, WORD)));
        assertEquals((short) 0xC000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x4000), CHANGE_SIGN, WORD)));
        assertEquals((short) 0x8000, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x8000), CHANGE_SIGN, WORD)));
        assertEquals((short) 0x8001, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7FFF), CHANGE_SIGN, WORD)));
        assertEquals((short) 1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFFFF), CHANGE_SIGN, WORD)));
    }

    @Test
    public void programmerSignChangeBYTE_isCorrect() {
        assertEquals((byte) -5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(5), CHANGE_SIGN, BYTE)));
        assertEquals((byte) 5, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-5), CHANGE_SIGN, BYTE)));
        assertEquals((byte) 0xC0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x40), CHANGE_SIGN, BYTE)));
        assertEquals((byte) 0x80, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x80), CHANGE_SIGN, BYTE)));
        assertEquals((byte) 0x81, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0x7F), CHANGE_SIGN, BYTE)));
        assertEquals((byte) 1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0xFF), CHANGE_SIGN, BYTE)));
    }
}
