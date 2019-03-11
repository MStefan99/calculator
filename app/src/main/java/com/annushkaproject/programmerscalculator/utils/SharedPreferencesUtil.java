package com.annushkaproject.programmerscalculator.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import com.annushkaproject.programmerscalculator.Interfaces.AppearanceUpdateInterface;
import com.annushkaproject.programmerscalculator.model.ThemeSetting;

/**
 * Used to store data in the shared preferences.
 */
public class SharedPreferencesUtil {

    private static final String PREF = "Preferences";
    private static final String THEME_SETTING_KEY = "ThemeSettingKey";
    private static final String PREFERENCES_LOG_TAG = "PreferencesLog";

    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    /**
     * Used to initialize the util.
     * @param activity Activity used to store shared preferences.
     */
    public SharedPreferencesUtil(Activity activity) {
        preferences = activity.getSharedPreferences(PREF, Activity.MODE_PRIVATE);
        preferencesEditor = preferences.edit();
    }

    /**
     * Used to save current theme.
     * @param themeSetting Theme to be saved.
     */
    public void saveThemeSetting(ThemeSetting themeSetting) {
        preferencesEditor.putInt(THEME_SETTING_KEY, ThemeSetting.getNumberByThemeSetting(themeSetting));
        preferencesEditor.commit();
    }

    /**
     * Used to load the saved theme.
     * @return Saved theme.
     */
    public ThemeSetting loadThemeSetting() {
        int value = preferences.getInt(THEME_SETTING_KEY, ThemeSetting.getNumberByThemeSetting(ThemeSetting.LIGHT));

        return ThemeSetting.getThemeSettingByNumber(value);
    }

    public void onPreferencesUpdated(AppearanceUpdateInterface updateInterface) {
        if (updateInterface == null) {
            Log.d(PREFERENCES_LOG_TAG, "onPreferencesUpdated: updateInterface is null");
            return;
        }

        preferences.registerOnSharedPreferenceChangeListener((prefs, key) -> {
            updateInterface.needUpdateAppearance(loadThemeSetting());
        });

    }
}
