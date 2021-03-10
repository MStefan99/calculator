package com.annushkaproject.programmerscalculator.ProgrammerTests;

import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel;
import com.annushkaproject.programmerscalculator.model.int_size_enum;
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil;

import org.junit.Test;

import java.math.BigDecimal;

import static com.annushkaproject.programmerscalculator.model.Operator.OR;
import static org.junit.Assert.*;

public class ProgrammerOrTest {
    @Test
    public void orTestAll_isCorrect() {
        for (int_size_enum mode : int_size_enum.values()) {
            assertEquals(0, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(0), new BigDecimal(0), OR, mode)));
            assertEquals(1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(1), new BigDecimal(0), OR, mode)));
            assertEquals(-1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-1), new BigDecimal(1), OR, mode)));
            assertEquals(-1, ProgrammerOperationsUtil.calculateWithData(new ProgrammerCalcModel(new BigDecimal(-1), new BigDecimal(-1), OR, mode)));
        }
    }
}
