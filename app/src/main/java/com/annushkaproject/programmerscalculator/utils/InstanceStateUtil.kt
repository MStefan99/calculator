package com.annushkaproject.programmerscalculator.utils

import android.os.Bundle
import com.annushkaproject.programmerscalculator.model.CalculationModel
import com.annushkaproject.programmerscalculator.model.Operator
import com.annushkaproject.programmerscalculator.model.ProgrammerCalcModel

object InstanceStateUtil {
    @JvmStatic
    fun restoreSavedInstance(savedInstanceState: Bundle): CalculationModel {
        val calcModel = CalculationModel()
        if (savedInstanceState.getBoolean("FIRST_VALUE_SAVED")) {
            calcModel.setFirstValue(savedInstanceState.getDouble("FIRST_VALUE"))
        }
        if (savedInstanceState.getBoolean("OPERATOR_SAVED")) {
            calcModel.operator = Operator.getOperatorByNumber(savedInstanceState.getInt("OPERATOR"))
        }
        if (savedInstanceState.getBoolean("SECOND_VALUE_SAVED")) {
            calcModel.setSecondValue(savedInstanceState.getDouble("SECOND_VALUE"))
        }
        return calcModel
    }

    @JvmStatic
    fun restoreProgrammerSavedInstance(savedInstanceState: Bundle): ProgrammerCalcModel {
        val calcModel = ProgrammerCalcModel()
        if (savedInstanceState.getBoolean("FIRST_VALUE_SAVED")) {
            calcModel.setFirstValue(savedInstanceState.getDouble("FIRST_VALUE"))
        }
        if (savedInstanceState.getBoolean("OPERATOR_SAVED")) {
            calcModel.operator = Operator.getOperatorByNumber(savedInstanceState.getInt("OPERATOR"))
        }
        if (savedInstanceState.getBoolean("SECOND_VALUE_SAVED")) {
            calcModel.setSecondValue(savedInstanceState.getDouble("SECOND_VALUE"))
        }
        calcModel.setSecondValue(savedInstanceState.getDouble("WORD_LENGTH"))
        return calcModel
    }

    fun saveInstanceState(outState: Bundle, calcModel: CalculationModel, packageName: String?) {
        outState.putString("PACKAGE_NAME", packageName)
        val firstValuePresent = calcModel.firstValue != null
        val operatorPresent = calcModel.operator != null
        val secondValuePresent = calcModel.secondValue != null
        if (firstValuePresent) {
            outState.putDouble("FIRST_VALUE", calcModel.firstValue.toDouble())
        }
        if (operatorPresent) {
            outState.putInt("OPERATOR", Operator.getNumberByOperator(calcModel.operator))
        }
        if (secondValuePresent) {
            outState.putDouble("SECOND_VALUE", calcModel.secondValue.toDouble())
        }
        outState.putBoolean("FIRST_VALUE_SAVED", firstValuePresent)
        outState.putBoolean("OPERATOR_SAVED", operatorPresent)
        outState.putBoolean("SECOND_VALUE_SAVED", secondValuePresent)
    }

    @JvmStatic
    fun saveInstanceState(outState: Bundle, calcModel: ProgrammerCalcModel, packageName: String?) {
        outState.putString("PACKAGE_NAME", packageName)
        val firstValuePresent = calcModel.firstValue != null
        val operatorPresent = calcModel.operator != null
        val secondValuePresent = calcModel.secondValue != null
        if (firstValuePresent) {
            outState.putDouble("FIRST_VALUE", calcModel.firstValue.toDouble())
        }
        if (operatorPresent) {
            outState.putInt("OPERATOR", Operator.getNumberByOperator(calcModel.operator))
        }
        if (secondValuePresent) {
            outState.putDouble("SECOND_VALUE", calcModel.secondValue.toDouble())
        }
        outState.putInt("WORD_LENGTH", calcModel.bytelengthenum.wordToInt())
        outState.putBoolean("FIRST_VALUE_SAVED", firstValuePresent)
        outState.putBoolean("OPERATOR_SAVED", operatorPresent)
        outState.putBoolean("SECOND_VALUE_SAVED", secondValuePresent)
    }
}