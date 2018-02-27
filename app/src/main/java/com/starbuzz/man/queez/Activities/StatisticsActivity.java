package com.starbuzz.man.queez.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.starbuzz.man.queez.MainActivity;
import com.starbuzz.man.queez.R;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    private ArrayList<Integer> idQuestionsArray;
    private int idQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView textStats = findViewById(R.id.textStats);
        Intent intent = getIntent();
        setIdQuestion(intent.getIntExtra("EXTRA_ID_QUESTION", 0));
        setIdQuestionsArray(intent.getIntegerArrayListExtra("EXTRA_ARRAY_ID"));
        String wellDoneText = " GG well done";
        textStats.setText(wellDoneText);

    }

    public void onClickNextQuestion(View view) {

        setIdQuestion(getIdQuestion()+1);
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("EXTRA_ID_QUESTION", getIdQuestion());
        intent.putExtra("EXTRA_ARRAY_ID", getIdQuestionsArray());
        startActivity(intent);
        finish();
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public ArrayList<Integer> getIdQuestionsArray() {
        return idQuestionsArray;
    }

    public void setIdQuestionsArray(ArrayList<Integer> idQuestionsArray) {
        this.idQuestionsArray = idQuestionsArray;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
