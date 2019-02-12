package com.annushkaproject.programmerscalculator.model;

import android.content.res.Resources;

public enum ThemeSetting {
    LIGHT,
    DARK,
    AUTO,
    UNKNOWN;

    public int getNumberByThemeSetting(ThemeSetting themeSetting) {
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

    public ThemeSetting getThemeSettingByNumber(int number) {
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
}
