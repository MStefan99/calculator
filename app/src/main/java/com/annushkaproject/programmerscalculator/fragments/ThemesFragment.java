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

public class ThemesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTheme(((MainActivity)getActivity()).getCurrentTheme());
        return inflater.inflate(R.layout.fragment_themes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button themeButton = getView().findViewById(R.id.buttonThemeToggle);
        themeButton.setOnClickListener((v) -> {
            int currentTheme = ((MainActivity)getActivity()).getCurrentThemeID();
            if (currentTheme == 1) {
                currentTheme = 0;
            } else {
                ++currentTheme;
            }
            ((MainActivity)getActivity()).setCurrentThemeID(currentTheme);
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
