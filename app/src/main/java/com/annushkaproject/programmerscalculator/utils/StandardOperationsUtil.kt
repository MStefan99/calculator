package com.annushkaproject.programmerscalculator.utils

import com.annushkaproject.programmerscalculator.model.CalculationModel
import com.annushkaproject.programmerscalculator.model.Operator
import java.math.RoundingMode

object StandardOperationsUtil {
    const val SCALE = 20

    /**
     * Used to calculate the result for operators that require two values.
     * @param data Model that will be used for calculations.
     * @return Calculated result.
     */
    @JvmStatic
    fun calculateResultForTwoSidedOperator(data: CalculationModel): Double {
        if (data.secondValue == null) {
            data.setSecondValueEqualToFirst()
        }
        if (!data.operator.requiresTwoValues()) {
            return (-1).toDouble() //TODO: throw an exception.
        }
        val result: Double
        result = when (data.operator) {
            Operator.ADD -> data.firstValue.add(data.secondValue).toDouble()
            Operator.SUBTRACT -> data.firstValue.subtract(data.secondValue).toDouble()
            Operator.MULTIPLY -> data.firstValue.multiply(data.secondValue).toDouble()
            Operator.remainder_divide -> data.firstValue.divide(data.secondValue, SCALE, RoundingMode.HALF_UP).toDouble()
            Operator.POWER -> data.firstValue.pow(data.secondValue.toInt()).toDouble()
            else ->                 //TODO: throw exception or crush the app.
                return 0
        }
        return result
    }

    /**
     * Used to calculate percents.
     * @param data Model for calculations.
     * @return Calculated result.
     */
    @JvmStatic
    fun calculatePercentForData(data: CalculationModel): Double {
        if (data.secondValue == null) {
            return (-1).toDouble() //TODO: throw an exception.
        }
        val firstNumber = data.firstValue.toDouble()
        val secondNumber = data.secondValue.toDouble()
        return firstNumber / 100.0 * secondNumber
    }

    /**
     * Used to calculate the result for operators that require one value.
     * @param number Number for calculation.
     * @param operator Operator for calculation.
     * @return Calculated result.
     */
    @JvmStatic
    fun calculateResultForOneSidedOperator(number: Double, operator: Operator): Double {
        return if (operator.requiresTwoValues()) {
            (-1).toDouble() //TODO: throw an exception.
        } else when (operator) {
            Operator.PERCENT -> number / 100.0 //TODO: change to BigDecimal
            Operator.ASIN -> Math.asin(number)
            Operator.ACOS -> Math.acos(number)
            Operator.ATAN -> Math.atan(number)
            Operator.SIN -> Math.sin(number)
            Operator.COS -> Math.cos(number)
            Operator.TAN -> Math.tan(number)
            Operator.LN -> Math.log(number)
            Operator.LOG -> Math.log10(number)
            Operator.DENOMINATOR -> 1.0 / number //TODO: change to BigDecimal
            Operator.EXPONENT_POWER -> Math.exp(number)
            Operator.SQUARE -> number * number
            Operator.ABS -> Math.abs(number)
            Operator.SQUARE_ROOT -> Math.sqrt(number)
            Operator.FACTORIAL -> calculateFactorial(number)
            else ->                 //TODO: throw exception or crush the app.
                0
        }
    }

    /**
     * Used to calculate factorials.
     * @param value Value for calculation.
     * @return Calculated result.
     */
    private fun calculateFactorial(value: Double): Double {
        var result = 1.0
        var i = 2
        while (i <= value) {
            result *= i.toDouble()
            i++
        }
        return result
    }
}