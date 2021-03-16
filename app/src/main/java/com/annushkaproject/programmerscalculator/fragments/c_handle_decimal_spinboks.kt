package com.annushkaproject.programmerscalculator.fragments

import android.app.Activity
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener

class c_handle_decimal_spinboks : Activity(), OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Another interface callback
    }
}