package com.example.projectuts.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Diary implements Parcelable {
    private String date;
    private String title;
    private String moment;

    public Diary(String date, String title, String moment) {
        this.date = date;
        this.title = title;
        this.moment = moment;
    }

    public Diary() {
    }

    protected Diary(Parcel in) {
        date = in.readString();
        title = in.readString();
        moment = in.readString();
    }

    public static final Creator<Diary> CREATOR = new Creator<Diary>() {
        @Override
        public Diary createFromParcel(Parcel source) {
            return new Diary(source);
        }

        @Override
        public Diary[] newArray(int size) {
            return new Diary[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(title);
        dest.writeString(moment);
    }
}
