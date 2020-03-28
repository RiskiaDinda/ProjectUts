package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.projectuts.models.DarkMode;

public class SettingActivity extends AppCompatActivity {

    private TextView labeldarkMode;
    private Switch switchdarkMode;
    DarkMode pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = new DarkMode(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        labeldarkMode = findViewById(R.id.labelMode);
        switchdarkMode = findViewById(R.id.darkmode);
        if (pref.isDarkMode()==true){
            switchdarkMode.setChecked(true);
        } else {
            switchdarkMode.setChecked(false);
        }

        switchdarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pref.setDarkMode(true);
                    if (pref.isDarkMode()==true){
                        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        switchdarkMode.setChecked(true);
                    }
                }else {
                    pref.setDarkMode(false);
                    if (pref.isDarkMode()==false){
                        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        switchdarkMode.setChecked(false);
                    }
                }
            }
        });
    }
}
