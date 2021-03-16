package com.annushkaproject.programmerscalculator.model

import java.math.BigDecimal

open class CalculationModel {
    var firstValue: BigDecimal?
        private set
    var secondValue: BigDecimal? = null
        private set
    var operator: Operator?

    constructor() {
        firstValue = null
        secondValue = null
        operator = null
    }

    constructor(firstValue: BigDecimal?, operator: Operator?) {
        this.firstValue = firstValue
        this.operator = operator
    }

    constructor(firstValue: BigDecimal?, secondValue: BigDecimal?, operator: Operator?) {
        this.firstValue = firstValue
        this.secondValue = secondValue
        this.operator = operator
    }

    fun setFirstValue(value: Double) {
        firstValue = BigDecimal.valueOf(value)
    }

    fun setSecondValue(value: Double) {
        secondValue = BigDecimal.valueOf(value)
    }

    fun setSecondValueEqualToFirst() {
        secondValue = firstValue!!.add(BigDecimal.ZERO)
    }

    fun resetCalcState() {
        firstValue = null
        secondValue = null
        operator = null
    }

    fun updateValues(text: String) {
        if (operator == null) {
            setFirstValue(text.toDouble())
        } else {
            setSecondValue(text.toDouble())
        }
    }

    fun updateAfterCalculation(calculationResult: Double) {
        resetCalcState()
        setFirstValue(calculationResult)
    }

    fun textForValue(value: Double): String {
        val isWholeValue = value % 1 == 0.0
        return if (isWholeValue) String.format("%.0f", value) else java.lang.Double.toString(value)
    }

    val isNotNumber: Boolean
        get() = operator === Operator.remainder_divide && secondValue!!.toDouble() == 0.0 ||
                operator === Operator.DENOMINATOR && firstValue!!.toDouble() == 0.0
    val isFirstIntegerValue: Boolean
        get() = firstValue!!.stripTrailingZeros().scale() <= 0
}