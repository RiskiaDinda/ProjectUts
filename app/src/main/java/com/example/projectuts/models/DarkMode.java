package com.example.projectuts.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class DarkMode {
    public static final String DARK_MODE = "darkmode";
    SharedPreferences preferences;

    public DarkMode(Context context) {
        preferences = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }

    public boolean isDarkMode() {
        return preferences.getBoolean(DARK_MODE, false);
    }

    public void setDarkMode(Boolean state) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(DARK_MODE,state);
        editor.commit();
    }
}
