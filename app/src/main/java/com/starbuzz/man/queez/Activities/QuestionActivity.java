package com.starbuzz.man.queez.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.starbuzz.man.queez.MainActivity;
import com.starbuzz.man.queez.Objects.Question;
import com.starbuzz.man.queez.R;

import java.util.ArrayList;


public class QuestionActivity extends AppCompatActivity {

    private int numberQuestion;
    private ArrayList<Integer> idQuestionsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        setNumberQuestion(intent.getIntExtra("EXTRA_ID_QUESTION", 0));
        setIdQuestionsArray(intent.getIntegerArrayListExtra("EXTRA_ARRAY_ID"));

        Question question = Question.questions.get(getIdQuestionsArray().get(getNumberQuestion()));
        TextView testQuestion = findViewById(R.id.textQuestion);
        testQuestion.setText(question.getQuestionText());
        Button[] buttons = {
                findViewById(R.id.btnAnswer1),
                findViewById(R.id.btnAnswer2),
                findViewById(R.id.btnAnswer3),
                findViewById(R.id.btnAnswer4)
        };

        for(int i=0; i<4; i++){
            buttons[i].setText(question.getAnswer()[i]);
        }

    }

    public void onClickCheckAnswer(View view) {

        Question question = Question.questions.get(getIdQuestionsArray().get(getNumberQuestion()));

        Button button = (Button) view;
        String getAnswer = question.getAnswer()[question.getTrueAnswer()];

        if(button.getText().toString().equals(getAnswer)){
            if(getNumberQuestion()+1 == getIdQuestionsArray().size()){
                Intent intent = new Intent(this, WinActivity.class);
                intent.putExtra("EXTRA_GETWIN", getAnswer);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, StatisticsActivity.class);
                intent.putExtra("EXTRA_ID_QUESTION", getNumberQuestion());
                intent.putExtra("EXTRA_ARRAY_ID", getIdQuestionsArray());

                startActivity(intent);
            }

        } else {
            Intent intent = new Intent(this, LoseActivity.class);
            intent.putExtra("EXTRA_LOSEANSWER", "You lose! Right answer was " + getAnswer);
            startActivity(intent);
        }
        finish();
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
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
