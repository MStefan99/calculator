package com.annushkaproject.programmerscalculator.utils;

import android.app.Activity;
import android.content.SharedPreferences;

import com.annushkaproject.programmerscalculator.model.ThemeSetting;

public class SharedPreferencesUtil {

    private static final String PREF = "Preferences";
    private static final String THEME_SETTING_KEY = "ThemeSettingKey";

    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    public SharedPreferencesUtil(Activity activity) {
        preferences = activity.getSharedPreferences(PREF, Activity.MODE_PRIVATE);
        preferencesEditor = preferences.edit();
    }

    public void saveThemeSetting(ThemeSetting themeSetting) {
        preferencesEditor.putInt(THEME_SETTING_KEY, ThemeSetting.getNumberByThemeSetting(themeSetting));
        preferencesEditor.commit();
    }

    public ThemeSetting loadThemeSetting() {
        int value = preferences.getInt(THEME_SETTING_KEY, ThemeSetting.getNumberByThemeSetting(ThemeSetting.LIGHT));

        return ThemeSetting.getThemeSettingByNumber(value);
    }

}
