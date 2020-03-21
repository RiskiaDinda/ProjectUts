package com.example.projectuts.models;

public class Diary {
    private String date;
    private String title;
    private String moment;

    public Diary(String date, String title, String moment) {
        this.date = date;
        this.title = title;
        this.moment = moment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }
}
