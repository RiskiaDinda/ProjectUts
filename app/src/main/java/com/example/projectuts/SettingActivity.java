package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
            setTheme(R.style.DarkTheme);
            switchdarkMode.setChecked(true);
        } else {
            setTheme(R.style.AppTheme);
            switchdarkMode.setChecked(false);
        }

        switchdarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pref.setDarkMode(true);
                    if (pref.isDarkMode()==true){
                        setTheme(R.style.DarkTheme);
                        labeldarkMode.setText("hai");
                        switchdarkMode.setChecked(true);
                    }
                }else {
                    pref.setDarkMode(false);
                    if (pref.isDarkMode()==false){
                        setTheme(R.style.AppTheme);
                        labeldarkMode.setText("sisi");
                        switchdarkMode.setChecked(false);
                    }
                }
            }
        });
    }
}
