package com.annushkaproject.programmerscalculator.utils

import android.app.Activity
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.util.Log
import com.annushkaproject.programmerscalculator.Interfaces.AppearanceUpdateInterface
import com.annushkaproject.programmerscalculator.model.ThemeSetting

class SharedPreferencesUtil(activity: Activity) {
    private val preferences: SharedPreferences
    private val preferencesEditor: Editor
    fun saveThemeSetting(themeSetting: ThemeSetting?) {
        preferencesEditor.putInt(THEME_SETTING_KEY, ThemeSetting.getNumberByThemeSetting(themeSetting))
        preferencesEditor.commit()
    }

    fun loadThemeSetting(): ThemeSetting {
        val value = preferences.getInt(THEME_SETTING_KEY, ThemeSetting.getNumberByThemeSetting(ThemeSetting.LIGHT))
        return ThemeSetting.getThemeSettingByNumber(value)
    }

    fun onPreferencesUpdated(updateInterface: AppearanceUpdateInterface?) {
        if (updateInterface == null) {
            Log.d(PREFERENCES_LOG_TAG, "onPreferencesUpdated: updateInterface is null")
            return
        }
        preferences.registerOnSharedPreferenceChangeListener { prefs: SharedPreferences?, key: String? -> updateInterface.needUpdateAppearance(loadThemeSetting()) }
    }

    companion object {
        private const val PREF = "Preferences"
        private const val THEME_SETTING_KEY = "ThemeSettingKey"
        private const val PREFERENCES_LOG_TAG = "PreferencesLog"
    }

    init {
        preferences = activity.getSharedPreferences(PREF, Activity.MODE_PRIVATE)
        preferencesEditor = preferences.edit()
    }
}