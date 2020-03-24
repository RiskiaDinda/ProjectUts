package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectuts.models.Diary;

import static com.example.projectuts.DiaryActivity.DIARY_KEY;

public class InputDiaryActivity extends AppCompatActivity {

    private EditText dateInput, titleInput, momentInput;
    private Diary item;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_diary);

        dateInput = findViewById(R.id.date_text);
        titleInput = findViewById(R.id.subject_text);
        momentInput = findViewById(R.id.isi_text);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            item = extras.getParcelable(DIARY_KEY);
            index = extras.getInt(DiaryActivity.INDEX_KEY, 0);
            dateInput.setText(item.getDate());
            titleInput.setText(item.getTitle());
            momentInput.setText(item.getMoment());
        }
    }

    public void handleSave(View view) {
        String date = dateInput.getText().toString();
        String title = titleInput.getText().toString();
        String moment = momentInput.getText().toString();

        if (date.isEmpty()){
            dateInput.setError("Please fill your moment date");
        }else if (title.isEmpty()){
            titleInput.setError("Please fill the title");
        }else if (moment.isEmpty()){
            momentInput.setError("Write your story here");
        }else {
            item.setDate(date);
            item.setTitle(title);
            item.setMoment(moment);

            Intent intent = new Intent();
            intent.putExtra(DIARY_KEY, item);
            intent.putExtra(DiaryActivity.INDEX_KEY, index);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
