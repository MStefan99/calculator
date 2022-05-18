package com.annushkaproject.programmerscalculator.model

import java.math.BigDecimal

class ProgrammerCalcModel : CalculationModel {
    var bytelengthenum: int_size_enum

    constructor() {
        bytelengthenum = int_size_enum.l8
    }

    constructor(firstValue: BigDecimal?, operator: Operator?, bytelengthenum: int_size_enum) : super(firstValue, operator) {
        this.bytelengthenum = bytelengthenum
    }

    constructor(firstValue: BigDecimal?, secondValue: BigDecimal?, operator: Operator?, bytelengthenum: int_size_enum) : super(firstValue, secondValue, operator) {
        this.bytelengthenum = bytelengthenum
    }

    fun updateValues(text: String, modeenum: mode_enum) {
        if (operator == null) setFirstValue(text.toLong(modeenum.base).toDouble()) else setSecondValue(text.toLong(modeenum.base).toDouble())
    }
}