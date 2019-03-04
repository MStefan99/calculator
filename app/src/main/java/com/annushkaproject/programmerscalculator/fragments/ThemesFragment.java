package com.annushkaproject.programmerscalculator.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.annushkaproject.programmerscalculator.R;
import com.annushkaproject.programmerscalculator.activities.MainActivity;
import com.annushkaproject.programmerscalculator.utils.ThemeUtil;

public class ThemesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTheme(ThemeUtil.getCurrentTheme());
        return inflater.inflate(R.layout.fragment_themes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button themeButton = getView().findViewById(R.id.buttonThemeToggle);
        themeButton.setOnClickListener((v) -> {
            int currentTheme = ThemeUtil.getCurrentThemeID();
            if (currentTheme == 1) {
                currentTheme = 0;
            } else {
                ++currentTheme;
            }
            ThemeUtil.setCurrentThemeID(currentTheme);
            getActivity().recreate();
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
