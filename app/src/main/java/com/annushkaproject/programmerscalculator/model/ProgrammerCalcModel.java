package com.annushkaproject.programmerscalculator.model;
import com.annushkaproject.programmerscalculator.model.CalculationModel;
import java.math.BigDecimal;
import static com.annushkaproject.programmerscalculator.model.WordLength.QWORD;
public class ProgrammerCalcModel extends CalculationModel {
    private WordLength wordLength;
    public WordLength getWordLength() { return wordLength; } 
    public void setWordLength(WordLength wordLength) { this.wordLength = wordLength; } 
    public ProgrammerCalcModel() { this.wordLength = QWORD; } 
    public ProgrammerCalcModel(BigDecimal firstValue, Operator operator, WordLength wordLength) {
        super(firstValue, operator);
        this.wordLength = wordLength;
    }

    public ProgrammerCalcModel(BigDecimal firstValue, BigDecimal secondValue, Operator operator, WordLength wordLength) {
        super(firstValue, secondValue, operator);
        this.wordLength = wordLength;
    }
    public void updateValues(String text, Mode mode) {
        if (this.getOperator() == null) {
            setFirstValue(Long.parseLong(text, mode.getBase()));
        } else {
            setSecondValue(Long.parseLong(text, mode.getBase()));
        }
    }

}