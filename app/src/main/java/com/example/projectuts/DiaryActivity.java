package com.example.projectuts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectuts.adapters.DiaryAdapters;
import com.example.projectuts.models.Diary;
import com.example.projectuts.models.Insert;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DiaryActivity extends AppCompatActivity implements DiaryAdapters.OnItemDiaryListener {

    public static final String DIARY_KEY = "DIARY";
    public static final String INDEX_KEY = "INDEX";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    private RecyclerView diaryView;
    private DiaryAdapters adapter;
    private Insert insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diaryView = findViewById(R.id.rv_diary);

        insert = new Insert();

        adapter = new DiaryAdapters(insert.getDiary(), this);
        diaryView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        diaryView.setLayoutManager(layoutManager);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryActivity.this, InputDiaryActivity.class);
                intent.putExtra(DIARY_KEY, new Diary());
                startActivityForResult(intent, INSERT_REQUEST);
            }
        });
    }

    @Override
    public void onDiaryClicked(int index, Diary item) {
        Intent intent = new Intent(DiaryActivity.this, InputDiaryActivity.class);
        intent.putExtra(DIARY_KEY, item);
        intent.putExtra(INDEX_KEY, index);
        startActivityForResult(intent, UPDATE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Diary diary = data.getParcelableExtra(DIARY_KEY);
            if (requestCode == INSERT_REQUEST){
                insert.addDiary(diary);
            }else if (requestCode == UPDATE_REQUEST){
                int index = data.getIntExtra(INDEX_KEY, 0);
                insert.editDiary(index, diary);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
