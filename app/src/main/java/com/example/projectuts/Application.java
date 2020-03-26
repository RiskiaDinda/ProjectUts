package com.example.projectuts;

import com.example.projectuts.models.Insert;

public class Application extends android.app.Application {

    private static Insert insert;

    @Override
    public void onCreate() {
        super.onCreate();
        insert = new Insert();
    }

    public static Insert getInsert() {
        return insert;
    }
}
