package com.annushkaproject.programmerscalculator.managers;

import com.annushkaproject.programmerscalculator.model.ThemeSetting;

public class SharedPreferencesManager {

    private static final SharedPreferencesManager sharedInstance = new SharedPreferencesManager();

    public static SharedPreferencesManager getSharedInstance() {
        return sharedInstance;
    }

    private SharedPreferencesManager() {
    }

    public void updateThemeSetting(ThemeSetting themeSetting) {

    }

    public ThemeSetting getCurrentThemeSetting() {
        //TODO: implement
        return ThemeSetting.UNKNOWN;
    }

}
