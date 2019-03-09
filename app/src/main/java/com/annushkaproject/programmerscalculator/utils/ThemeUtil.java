package com.annushkaproject.programmerscalculator.utils;

import com.annushkaproject.programmerscalculator.R;

public class ThemeUtil {

    private static int currentTheme;

    public static int getCurrentTheme() {
        switch (currentTheme) {
            case 0:
            default:
                return R.style.AppTheme;
            case 1:
                return R.style.AppTheme_DarkTheme;
        }
    }

    public static int getCurrentThemeID(){
        return currentTheme;
    }

    public static void setCurrentThemeID(int theme) {
        currentTheme = theme;
    }
}
