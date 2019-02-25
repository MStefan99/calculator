package com.annushkaproject.programmerscalculator.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.annushkaproject.programmerscalculator.R;
import com.annushkaproject.programmerscalculator.activities.MainActivity;

public class ProgrammerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getApplication().setTheme(((MainActivity)getActivity()).getCurrentTheme());
        getActivity().setTheme(((MainActivity)getActivity()).getCurrentTheme());
        return inflater.inflate(R.layout.fragment_programmer, container, false);
    }
}
