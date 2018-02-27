package com.starbuzz.man.queez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.starbuzz.man.queez.Activities.QuestionActivity;
import com.starbuzz.man.queez.Objects.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Integer> idQuestionsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickStartGame(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        idQuestionsArray = new LinkedList<>();
        for(int i = 0; i< Question.questions.size(); i++){
            idQuestionsArray.add(Question.questions.get(i).getId());
        }

        Collections.shuffle(idQuestionsArray);
        for(int i = 0; i< idQuestionsArray.size(); i++){
            Log.e("Test array", String.valueOf(idQuestionsArray.get(i)));
        }

        int start = 0;
        intent.putExtra("EXTRA_ID_QUESTION", start);
        intent.putExtra("EXTRA_ARRAY_ID", idQuestionsArray);
        startActivity(intent);
        finish();
    }

    public void onClickExit(View view) {
        moveTaskToBack(true);
        finish();
        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        moveTaskToBack(true);
        finish();
        System.exit(0);
    }
}
