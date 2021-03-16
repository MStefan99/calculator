package com.annushkaproject.programmerscalculator.model

import com.annushkaproject.programmerscalculator.R

enum class ThemeSetting {
    LIGHT, DARK, AUTO, UNKNOWN;

    companion object {
        @JvmStatic
        fun getNumberByThemeSetting(themeSetting: ThemeSetting?): Int {
            return when (themeSetting) {
                LIGHT -> 0
                DARK -> 1
                AUTO -> 2
                else -> -1
            }
        }

        @JvmStatic
        fun getThemeSettingByNumber(number: Int): ThemeSetting {
            return when (number) {
                0 -> LIGHT
                1 -> DARK
                2 -> AUTO
                else -> UNKNOWN
            }
        }

        @JvmStatic
        fun getThemeStyleByThemeSetting(themeSetting: ThemeSetting?): Int {
            return when (themeSetting) {
                LIGHT -> R.style.AppTheme
                DARK -> R.style.AppTheme_DarkTheme
                AUTO -> R.style.AppTheme
                else -> R.style.AppTheme
            }
        }
    }
}