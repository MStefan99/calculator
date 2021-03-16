package com.annushkaproject.programmerscalculator.fragments

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.annushkaproject.programmerscalculator.R
import com.annushkaproject.programmerscalculator.activities.HistoryActivity
import com.annushkaproject.programmerscalculator.managers.HistoryManager
import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.model.Operator.Companion.operatorForTitle
import com.annushkaproject.programmerscalculator.utils.InstanceStateUtil.restoreSavedInstance
import com.annushkaproject.programmerscalculator.utils.InstanceStateUtil.saveInstanceState
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil.calculatePercentForData
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil.calculateResultForOneSidedOperator
import com.annushkaproject.programmerscalculator.utils.StandardOperationsUtil.calculateResultForTwoSidedOperator
import java.util.*

class StandardFragment : Fragment() {
    private var textView: TextView? = null
    private val numberButtons: ArrayList<Button?>? = ArrayList()
    private val operatorButtons: ArrayList<Button?>? = ArrayList()
    private var calcModel: CalculationModel? = CalculationModel()
    private var secondValueInputStarted = false
    private var packageName: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME")
            calcModel = restoreSavedInstance(savedInstanceState)
        }
        val view = inflater.inflate(R.layout.fragment_standard, container, false)
        val btnHistory = view.findViewById<Button?>(R.id.buttonHistory)
        btnHistory.setOnClickListener {
            val intent = Intent(activity, HistoryActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = getView().findViewById(R.id.u5h_tekst_viyu)
        fillNumberButtons()
        fillOperatorButtons()
        setupCalculateButton()
        setupDeleteButton()
        setupClearButton()
        setupSignButton()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState, calcModel, packageName)
    }

    fun setupFragment(packageName: String?) {
        this.packageName = packageName
    }

    private fun fillNumberButtons() {
        for (i in 0..9) {
            val button = view.findViewById<Button?>(resources.getIdentifier("button$i", "id",
                    packageName))
            button.setOnClickListener { v: View? ->
                val button1 = v as Button?
                println(button1.getText().toString())
                usePressedNumber(button1.getText().toString())
            }
            numberButtons.add(button)
        }

        //Adding "." button separately
        val button = view.findViewById<Button?>(R.id.button_decimal_point)
        button.setOnClickListener { v: View? ->
            val button12 = v as Button?
            println(button12.getText().toString())
            if (!currentString().contains(".")) {
                usePressedNumber(button12.getText().toString())
            }
        }
        numberButtons.add(button)
        val buttonPi = view.findViewById<Button?>(R.id.buttonPi)
        buttonPi.setOnClickListener { v: View? ->
            val button13 = v as Button?
            println(button13.getText().toString())
            usePiPressedNumber()
        }
        numberButtons.add(buttonPi)
    }

    private fun currentString(): String? {
        return textView.getText().toString()
    }

    private fun fillOperatorButtons() {
        operatorButtons.add(view.findViewById(R.id.buttonPlus))
        operatorButtons.add(view.findViewById(R.id.buttonMinus))
        operatorButtons.add(view.findViewById(R.id.buttonRDivide))
        operatorButtons.add(view.findViewById(R.id.buttonMultiply))
        operatorButtons.add(view.findViewById(R.id.buttonPercent))
        if (isInLandscapeOrientation()) {
            operatorButtons.add(view.findViewById(R.id.buttonAsin))
            operatorButtons.add(view.findViewById(R.id.buttonAcos))
            operatorButtons.add(view.findViewById(R.id.buttonAtan))
            operatorButtons.add(view.findViewById(R.id.buttonSin))
            operatorButtons.add(view.findViewById(R.id.buttonCos))
            operatorButtons.add(view.findViewById(R.id.buttonTan))
            operatorButtons.add(view.findViewById(R.id.buttonLn))
            operatorButtons.add(view.findViewById(R.id.buttonLog))
            operatorButtons.add(view.findViewById(R.id.buttonRev))
            operatorButtons.add(view.findViewById(R.id.buttonEpow))
            operatorButtons.add(view.findViewById(R.id.buttonSquare))
            operatorButtons.add(view.findViewById(R.id.buttonPower))
            operatorButtons.add(view.findViewById(R.id.buttonAbs))
            operatorButtons.add(view.findViewById(R.id.buttonSqrt))
            operatorButtons.add(view.findViewById(R.id.buttonFactorial))
        }
        for (button in operatorButtons) {
            button.setOnClickListener(View.OnClickListener { v: View? ->
                val button1 = v as Button?
                println(button1.getText().toString())
                val operator = operatorForTitle(button1.getText().toString())
                usePressedOperator(operator)
            }
            )
        }
    }

    private fun setupCalculateButton() {
        val equalsButton = view.findViewById<Button?>(R.id.buttonEquals)
        equalsButton.setOnClickListener { v: View? ->
            val button = v as Button?
            println(button.getText().toString())
            useEqualsOperator()
        }
    }

    private fun setupDeleteButton() {
        val delButton = view.findViewById<Button?>(R.id.buttonDel)
        delButton.setOnClickListener { v: View? ->
            var currentString = currentString()
            val isOneDigit = currentString.length == 1
            val isOneNegativeDigit = currentString.length == 2 && currentString.startsWith("-")
            if (isOneDigit || isOneNegativeDigit) {
                updateText(calcModel.textForValue(0.0))
            } else {
                currentString = currentString.substring(0, currentString.length - 1)
                updateText(currentString)
            }
        }
    }

    private fun setupClearButton() {
        val clearButton = view.findViewById<Button?>(R.id.buttonClear)
        clearButton.setOnClickListener { v: View? ->
            calcModel.resetCalcState()
            updateText(calcModel.textForValue(0.0))
        }
    }

    private fun setupSignButton() {
        val signButton = view.findViewById<Button?>(R.id.buttonSign)
        signButton.setOnClickListener { v: View? ->
            val currentValue = currentString().toDouble()
            if (currentValue == 0.0) { //do not make "-0"
                return@setOnClickListener
            }
            var updatedString = currentString()
            updatedString = if (currentValue > 0) {
                "-$updatedString"
            } else {
                updatedString.substring(1)
            }
            updateText(updatedString)
        }
    }

    private fun usePressedNumber(number: String?) {
        if (currentString() == "0" && number != "." || currentString() == getString(R.string.not_a_number)) {
            textView.setText("") //clear text view from 0 value.
        }
        val newString: String?
        if (secondValueInputStarted) {
            newString = number
            secondValueInputStarted = false
        } else {
            newString = textView.getText().toString() + number
        }
        updateText(newString)
    }

    private fun usePiPressedNumber() {
        val newString = java.lang.Double.toString(Math.PI)
        if (secondValueInputStarted) {
            secondValueInputStarted = false
        } else {
            calcModel.resetCalcState()
        }
        updateText(newString)
    }

    private fun usePressedOperator(operator: Operator?) {
        val readyToSaveOperator = calcModel.firstValue != null
        if (!readyToSaveOperator) {
            return
        }
        if (!operator.requiresTwoValues()) {
            if (operator === Operator.FACTORIAL && !calcModel.isFirstIntegerValue) {
                handleNotANumberCase()
                return
            }
            val result: Double
            if (calcModel.secondValue == null) {
                //apply to first value
                val number = calcModel.firstValue.toDouble()
                result = calculateResultForOneSidedOperator(number, operator)
                HistoryManager.Companion.getSharedInstance().save(calcModel.textForValue(result))
                calcModel.setFirstValue(result)
            } else if (operator === Operator.PERCENT && calcModel.secondValue != null) {
                //special case for 6 - 10%
                result = calculatePercentForData(calcModel)
                calcModel.setSecondValue(result)
            } else {
                //apply to second value
                val number = calcModel.secondValue.toDouble()
                result = calculateResultForOneSidedOperator(number, operator)
                calcModel.setSecondValue(result)
            }
            val text = calcModel.textForValue(result)
            textView.setText(text)
            return
        }
        val readyToCalcTwoSides = calcModel.operator != null && calcModel.firstValue != null && calcModel.secondValue != null
        if (readyToCalcTwoSides) {
            calculateResult()
        } else {
            secondValueInputStarted = true
        }
        calcModel.operator = operator
    }

    private fun useEqualsOperator() {
        if (calcModel.operator == null) {
            return
        }
        calculateResult()
    }

    private fun calculateResult() {
        if (calcModel.isNotNumber) {
            handleNotANumberCase()
            return
        }
        val result = calculateResultForTwoSidedOperator(calcModel)
        HistoryManager.Companion.getSharedInstance().save(calcModel.textForValue(result))
        calcModel.resetCalcState()
        calcModel.updateAfterCalculation(result)
        updateText(calcModel.textForValue(result))
        secondValueInputStarted = true
    }

    private fun handleNotANumberCase() {
        calcModel.resetCalcState()
        textView.setText(getString(R.string.not_a_number))
    }

    private fun updateText(updatedText: String?) {
        if (updatedText.length == StandardOperationsUtil.SCALE) {
            showDigitsLimitWarning()
            return
        }
        textView.setText(updatedText)
        if (updatedText.length > 10) {
            textView.setTextSize(24f)
        } else {
            textView.setTextSize(30f)
        }
        calcModel.updateValues(updatedText)
    }

    private fun showDigitsLimitWarning() {
        val context = activity.getApplicationContext()
        Toast.makeText(context, R.string.max_digits_warning, Toast.LENGTH_SHORT).show()
    }

    private fun isInLandscapeOrientation(): Boolean {
        val orientation = resources.configuration.orientation
        return orientation == Configuration.ORIENTATION_LANDSCAPE
    }
}