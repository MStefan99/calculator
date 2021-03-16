package com.annushkaproject.programmerscalculator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.annushkaproject.programmerscalculator.R
import com.annushkaproject.programmerscalculator.model.*
import com.annushkaproject.programmerscalculator.model.Operator.Companion.operatorForTitle
import com.annushkaproject.programmerscalculator.utils.InstanceStateUtil.restoreProgrammerSavedInstance
import com.annushkaproject.programmerscalculator.utils.InstanceStateUtil.saveInstanceState
import com.annushkaproject.programmerscalculator.utils.ProgrammerOperationsUtil.calculateWithData
import com.annushkaproject.programmerscalculator.utils.c_nmbr_utils.heks_nmbr_string_to_vrdsstring

class ProgrammerFragment : Fragment() {
    private var u5h_tekst_viyu: TextView? = null
    private var u2b_tekst_viyu: TextView? = null
    private var dizit_tekst_viyu: TextView? = null
    private var ekuation_tekst_viyu: TextView? = null
    private var calcModel: ProgrammerCalcModel? = ProgrammerCalcModel()
    private var secondValueInputStarted = false
    private var packageName: String? = null
    private var bytelengthenum: int_size_enum? = int_size_enum.l8

    //    private mode_enum modeenum = mode_enum.mode_enum_dec;
    private var modeenum: mode_enum? = mode_enum.mode_enum_heks
    private var limit_phen_dizits_recahed = false
    private val limit_dizits = 14

    //    String[] dizit_nems_array = getResources().getStringArray(R.array.dizit_nems_array);
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        if (packageName == null) {
            packageName = savedInstanceState.getString("PACKAGE_NAME")
            calcModel = restoreProgrammerSavedInstance(savedInstanceState)
        }
        return inflater.inflate(R.layout.fragment_programmer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        u5h_tekst_viyu = getView().findViewById(R.id.u5h_tekst_viyu)
        u2b_tekst_viyu = getView().findViewById(R.id.u2b_tekst_viyu)
        dizit_tekst_viyu = getView().findViewById(R.id.dizit_tekst_viyu)
        ekuation_tekst_viyu = getView().findViewById(R.id.ekuation_tekst_viyu)
        //
        setupNumberButtons()
        setupOperatorButtons()
        setupLetterButtons()
        setupCalculateButton()
        setupDeleteButton()
        //setupClearButton(); TODO: add clear button
        setupSignButton()
        //        setupModeRadio();
        setup_heks_cb()
        modeenum = mode_enum.mode_enum_heks
        enableButtonsALL()
        setup_decimal_spinner()
        setupWordLengthButton()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveInstanceState(outState, calcModel, packageName)
    }

    fun setupFragment(packageName: String?) {
        this.packageName = packageName
    }

    private fun setupNumberButtons() {
        for (i in 0..9) {
            val button = view.findViewById<Button?>(resources.getIdentifier("button$i", "id", packageName))
            button.setOnClickListener { v: View? ->
                when (i) {
                    0 -> dizit_tekst_viyu.setText("ziro")
                    1 -> dizit_tekst_viyu.setText("vn")
                    2 -> dizit_tekst_viyu.setText("tuu")
                    3 -> dizit_tekst_viyu.setText("Three")
                    4 -> dizit_tekst_viyu.setText("four")
                    5 -> dizit_tekst_viyu.setText("five")
                    6 -> dizit_tekst_viyu.setText("siks")
                    7 -> dizit_tekst_viyu.setText("seven")
                    8 -> dizit_tekst_viyu.setText("eight")
                    9 -> dizit_tekst_viyu.setText("nine")
                }
                //                dizit_tekst_viyu.setText(dizit_nems_array[finalI]);
                if (!limit_phen_dizits_recahed) usePressedNumber((v as Button?).getText().toString())
            }
        }
    }

    private fun setupLetterButtons() {
        val letterButtonIDs = intArrayOf(R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD, R.id.buttonE, R.id.buttonF)
        //        int for_start_i = 10 ;
        for (buttonID in letterButtonIDs) {
            val button = view.findViewById<Button?>(buttonID)
            //            int finalFor_start_i = for_start_i;
            button.setOnClickListener { v: View? ->
                when (buttonID) {
                    R.id.buttonA -> dizit_tekst_viyu.setText("ten")
                    R.id.buttonB -> dizit_tekst_viyu.setText("zilevn")
                    R.id.buttonC -> dizit_tekst_viyu.setText("kvAlv")
                    R.id.buttonD -> dizit_tekst_viyu.setText("dblyu")
                    R.id.buttonE -> dizit_tekst_viyu.setText("Aksen")
                    R.id.buttonF -> dizit_tekst_viyu.setText("phen")
                }
                if (!limit_phen_dizits_recahed) {
//                    System.out.println(button.getText().toString());
                    usePressedNumber((v as Button?).getText().toString())
                }
            }
            //            for_start_i += 1;
        }
    }

    private fun setupOperatorButtons() {
        val operatorButtonIDs = intArrayOf(R.id.buttonMod, R.id.button_zor, R.id.buttonOR, R.id.buttonAND,
                R.id.buttonLSH, R.id.buttonRSH, R.id.buttonNOT, R.id.buttonRDivide, R.id.buttonMultiply,
                R.id.buttonMinus, R.id.buttonPlus)
        for (buttonID in operatorButtonIDs) {
            val button = view.findViewById<Button?>(buttonID)
            button.setOnClickListener { v: View? ->
                if (!limit_phen_dizits_recahed) {
                    val operator = operatorForTitle(button.text.toString())
                    usePressedOperator(operator)
                }
            }
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
            if (limit_phen_dizits_recahed) {
                enableButtonsALL()
                enableOperatorButtons()
                limit_phen_dizits_recahed = false
            } else if (currentString != "-" && currentString.length > 1) {
                currentString = currentString.substring(0, currentString.length - 1)
                updateText(currentString)
            } else updateText(calcModel.textForValue(0.0))
        }
    }

    private fun setupSignButton() {
        val signButton = view.findViewById<Button?>(R.id.buttonSign)
        signButton.setOnClickListener { v: View? ->
            val currentValue = currentString().toLong(modeenum.base)
            if (currentValue == 0L) return@setOnClickListener
            var updatedString = formatText(currentValue)
            updatedString = if (currentValue > 0) "-$updatedString" else updatedString.substring(1)
            updateText(updatedString)
        }
    }

    private fun currentString(): String? {
        return u5h_tekst_viyu.getText().toString()
    }

    private fun setupWordLengthButton() {
        val modeButton = view.findViewById<Button?>(R.id.buttonLength)
        modeButton.setOnClickListener { v: View? ->
            var `val` = currentString().toLong(modeenum.base)
            bytelengthenum = if (bytelengthenum.ordinal < 3) {
                var num = bytelengthenum.ordinal
                int_size_enum.values()[++num]
            } else int_size_enum.l8
            when (bytelengthenum) {
                int_size_enum.l4 -> `val` = `val` as Int.toLong
                ()
                        int_size_enum . l2 -> `val` = `val` as Short.toLong
                ()
                        int_size_enum . l1 -> `val` = `val` as Byte.toLong
                ()
            }
            calcModel.bytelengthenum = bytelengthenum
            updateText(formatText(`val`))
            Log.d("LengthChanged", "Length button pressed, current value: " + bytelengthenum.toString())
            modeButton.text = bytelengthenum.toString()
        }
    }

    //    private void setupModeRadio() { RadioGroup radioGroup = getView().findViewById(R.id.radioGroup);radioGroup.setOnCheckedChangeListener((v, id) -> {
    //            long number = Long.parseLong(textView.getText().toString(), modeenum.getBase());
    //            switch (id) {
    //                case R.id.radioButtonHex: modeenum = mode_enum.mode_enum_heks; enableButtonsALL(); break;
    //                case R.id.radioButtonDec: modeenum = mode_enum.mode_enum_dec; enableButtonsDEC(); break;
    //                // case R.id.radioButtonOct: modeenum = mode_enum.OCT; enableButtonsOCT(); break; case R.id.radioButtonBin: modeenum = mode_enum.BIN; enableButtonsBIN(); break;
    //            }
    //            updateText(formatText(number));
    //            Log.d("ModeChanged", "mode_enum radio pressed, current value: " + modeenum.toString());
    //        });
    //    }
    private fun setup_heks_cb() {
        val heks_cb = view.findViewById<CheckBox?>(R.id.heks_check_boks)
        heks_cb.setOnCheckedChangeListener { v: CompoundButton?, id: Boolean ->
            val number = u5h_tekst_viyu.getText().toString().toLong(modeenum.base)
            if (heks_cb.isChecked) {
                modeenum = mode_enum.mode_enum_heks
                enableButtonsALL()
            } else {
                modeenum = mode_enum.mode_enum_dec
                enableButtonsDEC()
            }
            updateText(formatText(number))
        }
    }

    private fun setup_decimal_spinner() {
        val spinner = view.findViewById<Spinner?>(R.id.decimal_precision_spinner)
        val decimal_points_items = resources.getStringArray(R.array.decimal_points_selection_array)
        //        ArrayAdapter<String> adapter = ArrayAdapter.createFromResource();//new ArrayAdapter<String>(this, R.layout.fragment_programmer, R.id.text, decimal_points_items);
        val adapter = ArrayAdapter.createFromResource(spinner.context,  // getActivity(),
                R.array.decimal_points_selection_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        //        c_handle_decimal_spinboks spinboks_listener = new c_handle_decimal_spinboks() ;
//        spinner.setOnItemClickListener((AdapterView.OnItemClickListener) spinboks_listener);
    }

    private fun usePressedNumber(number: String?) {
        if (currentString() == "0" && number != ".") {
            u5h_tekst_viyu.setText("")
            u2b_tekst_viyu.setText("")
        }
        val newString: String?
        if (secondValueInputStarted) {
            newString = number
            secondValueInputStarted = false
        } else newString = u5h_tekst_viyu.getText().toString() + number
        updateText(newString)
    }

    private fun usePressedOperator(operator: Operator?) {
        val readyToSaveOperator = calcModel.firstValue != null
        if (!readyToSaveOperator) return
        val readyToCalcOneSide = !operator.requiresTwoValues() && calcModel.firstValue != null
        if (readyToCalcOneSide) {
            calcModel.operator = operator
            calculateResult()
            return
        }
        val readyToCalcTwoSides = calcModel.operator != null && calcModel.firstValue != null && calcModel.secondValue != null
        if (readyToCalcTwoSides) calculateResult() else secondValueInputStarted = true
        calcModel.operator = operator
    }

    private fun useEqualsOperator() {
        if (calcModel.operator == null) return
        calculateResult()
    }

    private fun calculateResult() {
        val result = calculateWithData(calcModel)
        calcModel.resetCalcState()
        calcModel.updateAfterCalculation(result.toDouble())
        updateText(formatText(result))
        secondValueInputStarted = true
    }

    private fun formatText(number: Long): String? {
        return java.lang.Long.toString(number, modeenum.base).toUpperCase()
    }

    private fun updateText(updatedText: String?) {
        if (updatedText.length > limit_dizits) {
            disableAllButtons()
            disableOperatorButtons()
            limit_phen_dizits_recahed = true
        } else {
            if (updatedText.length > 12) {
                val input1_tekst_size_small = resources.getDimension(R.dimen.input1_tekst_size_small) as Int // / getResources().getDisplayMetrics().density) ;
                val input3_tekst_size_small = resources.getDimension(R.dimen.input3_tekst_size_small) as Int // / getResources().getDisplayMetrics().density) ;
                u5h_tekst_viyu.setTextSize(18f)
                u2b_tekst_viyu.setTextSize(27f)
            } else {
                val input1_tekst_size_big = resources.getDimension(R.dimen.input1_tekst_size_big) as Int // / getResources().getDisplayMetrics().density) ;
                val input3_tekst_size_big = resources.getDimension(R.dimen.input3_tekst_size_big) as Int // / getResources().getDisplayMetrics().density) ;
                u5h_tekst_viyu.setTextSize(26f)
                u2b_tekst_viyu.setTextSize(39f)
            }
            u5h_tekst_viyu.setText(updatedText)
            u2b_tekst_viyu.setText(updatedText)
            ekuation_tekst_viyu.setText(heks_nmbr_string_to_vrdsstring(updatedText))
            calcModel.updateValues(updatedText, modeenum)
        }
    }

    private fun setTextViewValue(value: Double?) {
        val isWholeValue = value % 1 == 0.0
        if (isWholeValue) {
            u5h_tekst_viyu.setText(String.format("%.0f", value))
            u2b_tekst_viyu.setText(String.format("%.0f", value))
        } else {
            u5h_tekst_viyu.setText(java.lang.Double.toString(value))
            u2b_tekst_viyu.setText(java.lang.Double.toString(value))
        }
    }

    private fun disableOperatorButtons() {
        setOperatorButtonsClickable(false)
    }

    private fun enableOperatorButtons() {
        setOperatorButtonsClickable(true)
    }

    private fun disableAllButtons() {
        setNumberButtonsClickable(10, false)
        setLetterButtonsClickable(false)
    }

    //    private void enableButtonsBIN() { disableAllButtons();setNumberButtonsClickable(2, true); }
    //    private void enableButtonsOCT() { disableAllButtons();setNumberButtonsClickable(8, true); }
    private fun enableButtonsDEC() {
        disableAllButtons()
        setNumberButtonsClickable(10, true)
    }

    private fun enableButtonsALL() {
        setLetterButtonsClickable(true)
        setNumberButtonsClickable(10, true)
    }

    private fun setLetterButtonsClickable(mode: Boolean) {
        val letterButtonIDs = intArrayOf(R.id.buttonA, R.id.buttonB, R.id.buttonC, R.id.buttonD, R.id.buttonE, R.id.buttonF)
        for (buttonID in letterButtonIDs) {
            val button = view.findViewById<Button?>(buttonID)
            button.isEnabled = mode
        }
    }

    private fun setNumberButtonsClickable(range: Int, mode: Boolean) {
        for (i in 0 until range) {
            val button = view.findViewById<Button?>(resources.getIdentifier("button$i", "id", packageName))
            button.isEnabled = mode
        }
    }

    private fun setOperatorButtonsClickable(mode: Boolean) {
        val letterButtonIDs = intArrayOf(
                R.id.button_decimal_point, R.id.buttonRDivide,  //                R.id.buttonFdivide,
                R.id.buttonMod,
                R.id.buttonMinus, R.id.buttonPlus, R.id.buttonMultiply, R.id.buttonPower,
                R.id.button_decimal_point, R.id.buttonEquals,
                R.id.button_zor, R.id.buttonOR, R.id.buttonNOT, R.id.buttonAND, R.id.buttonLSH, R.id.buttonRSH)
        for (buttonID in letterButtonIDs) {
            val button = view.findViewById<Button?>(buttonID)
            button.isEnabled = mode
        }
    }
}