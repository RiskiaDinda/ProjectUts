package com.example.projectuts.models;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    private List<Diary> diary;

    public Insert() {
        this.diary = new ArrayList<>();
    }

    public List<Diary> getDiary() {
        return diary;
    }

    public void setDiary(List<Diary> diary) {
        this.diary = diary;
    }

    public void addDiary(Diary diary){
        this.diary.add(diary);
    }

    public void editDiary(int index, Diary diary){
        this.diary.set(index, diary);
    }

    public void removeDiary(int index){
        Diary d = diary.get(index);
        this.diary.remove(d);
    }
}
