package com.annushkaproject.programmerscalculator.Interfaces

import com.annushkaproject.programmerscalculator.model.ThemeSetting

interface AppearanceUpdateInterface {
    open fun needUpdateAppearance(themeSetting: ThemeSetting?)
}