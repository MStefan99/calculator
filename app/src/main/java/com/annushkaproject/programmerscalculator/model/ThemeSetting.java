package com.annushkaproject.programmerscalculator.model;
import com.annushkaproject.programmerscalculator.R;
public enum ThemeSetting { LIGHT, DARK, AUTO, UNKNOWN;
    public static int getNumberByThemeSetting(ThemeSetting themeSetting) {
        switch (themeSetting) { case LIGHT: return 0; case DARK: return 1; case AUTO: return 2; default: return -1; }
    }
    public static ThemeSetting getThemeSettingByNumber(int number) {
        switch (number) {
            case 0: return ThemeSetting.LIGHT; case 1: return ThemeSetting.DARK;
            case 2: return ThemeSetting.AUTO; default: return ThemeSetting.UNKNOWN; }
    }
    public static int getThemeStyleByThemeSetting(ThemeSetting themeSetting) {
        switch (themeSetting) {
            case LIGHT: return R.style.AppTheme; case DARK: return R.style.AppTheme_DarkTheme;
            case AUTO: default: return R.style.AppTheme; }
    }
}
