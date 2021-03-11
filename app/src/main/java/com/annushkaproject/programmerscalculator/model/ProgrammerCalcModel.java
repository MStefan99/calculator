package com.annushkaproject.programmerscalculator.model;
import java.math.BigDecimal;
import static com.annushkaproject.programmerscalculator.model.int_size_enum.l8;
public class ProgrammerCalcModel extends CalculationModel {
    private int_size_enum bytelengthenum;
    public int_size_enum getBytelengthenum() { return bytelengthenum; }
    public void setBytelengthenum(int_size_enum bytelengthenum) { this.bytelengthenum = bytelengthenum; }
    public ProgrammerCalcModel() { this.bytelengthenum = l8; }
    public ProgrammerCalcModel(BigDecimal firstValue, Operator operator, int_size_enum bytelengthenum) {
        super(firstValue, operator);
        this.bytelengthenum = bytelengthenum;
    }

    public ProgrammerCalcModel(BigDecimal firstValue, BigDecimal secondValue, Operator operator, int_size_enum bytelengthenum) {
        super(firstValue, secondValue, operator);
        this.bytelengthenum = bytelengthenum;
    }
    public void updateValues(String text, mode_enum modeenum) {
        if (this.getOperator() == null) {
            setFirstValue(Long.parseLong(text, modeenum.getBase()));
        } else {
            setSecondValue(Long.parseLong(text, modeenum.getBase()));
        }
    }

}