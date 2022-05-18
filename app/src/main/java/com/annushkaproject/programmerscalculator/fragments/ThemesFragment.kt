package com.annushkaproject.programmerscalculator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.annushkaproject.programmerscalculator.R
import com.annushkaproject.programmerscalculator.model.ThemeSetting
import com.annushkaproject.programmerscalculator.model.ThemeSetting.Companion.getNumberByThemeSetting
import com.annushkaproject.programmerscalculator.model.ThemeSetting.Companion.getThemeSettingByNumber
import com.annushkaproject.programmerscalculator.utils.SharedPreferencesUtil

class ThemesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_themes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lightRadio = activity.findViewById<RadioButton?>(R.id.lightThemeButton)
        val darkRadio = activity.findViewById<RadioButton?>(R.id.darkThemeButton)
        val prefUtil = SharedPreferencesUtil(activity)
        val themeSetting = prefUtil.loadThemeSetting()
        when (themeSetting) {
            ThemeSetting.LIGHT -> {
                lightRadio.isChecked = true
                darkRadio.isChecked = false
            }
            ThemeSetting.DARK -> {
                lightRadio.isChecked = false
                darkRadio.isChecked = true
            }
            ThemeSetting.UNKNOWN -> {
                lightRadio.isChecked = false
                darkRadio.isChecked = false
            }
        }
        lightRadio.setOnClickListener { v: View? ->
            val theme = ThemeSetting.LIGHT
            prefUtil.saveThemeSetting(getThemeSettingByNumber(getNumberByThemeSetting(theme)))
            Log.d("ThemeChanged", "mode_enum radio pressed, current value: $theme")
            activity.recreate()
        }
        darkRadio.setOnClickListener { v: View? ->
            val theme = ThemeSetting.DARK
            prefUtil.saveThemeSetting(getThemeSettingByNumber(getNumberByThemeSetting(theme)))
            Log.d("ThemeChanged", "mode_enum radio pressed, current value: $theme")
            activity.recreate()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}