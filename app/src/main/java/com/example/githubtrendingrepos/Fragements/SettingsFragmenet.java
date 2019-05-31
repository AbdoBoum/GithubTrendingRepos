package com.example.githubtrendingrepos.Fragements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.githubtrendingrepos.Activities.MainActivity;
import com.example.githubtrendingrepos.R;

public class SettingsFragmenet extends Fragment {

    MainActivity activity;

    android.support.v7.widget.Toolbar toolbar;

    private static final String TAG = "SettingsFragmenet";

    public static SettingsFragmenet newInstance() {
        SettingsFragmenet fragment = new SettingsFragmenet();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Lunched");
        activity = (MainActivity) getActivity();
    }

}
