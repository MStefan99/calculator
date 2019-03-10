package com.annushkaproject.programmerscalculator.model;

import com.annushkaproject.programmerscalculator.R;

/**
 * Used to store the current theme.
 */
public enum ThemeSetting {
    LIGHT,
    DARK,
    AUTO,
    UNKNOWN;

    /**
     * Used to get the unique number of theme.
     * @param themeSetting Theme.
     * @return Corresponding number.
     */
    public static int getNumberByThemeSetting(ThemeSetting themeSetting) {
        switch (themeSetting) {
            case LIGHT:
                return 0;
            case DARK:
                return 1;
            case AUTO:
                return 2;

            default:
                return -1;
        }
    }

    /**
     * Used to get the theme by its unique number.
     * @param number Theme number.
     * @return Corresponding theme.
     */
    public static ThemeSetting getThemeSettingByNumber(int number) {
        switch (number) {
            case 0:
                return ThemeSetting.LIGHT;
            case 1:
                return ThemeSetting.DARK;
            case 2:
                return ThemeSetting.AUTO;

            default:
                return ThemeSetting.UNKNOWN;
        }
    }

    /**
     * Used to get the resource file of the theme.
     * @param themeSetting Theme.
     * @return Resource file of the theme.
     */
    public static int getThemeStyleByThemeSetting(ThemeSetting themeSetting) {
        switch (themeSetting) {
            case LIGHT:
                return R.style.AppTheme;
            case DARK:
                return R.style.AppTheme_DarkTheme;
            case AUTO:

            default:
                return R.style.AppTheme;
        }
    }
}
