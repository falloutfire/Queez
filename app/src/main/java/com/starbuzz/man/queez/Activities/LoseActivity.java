package com.starbuzz.man.queez.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.starbuzz.man.queez.MainActivity;
import com.starbuzz.man.queez.R;

public class LoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        TextView textView = findViewById(R.id.loseText);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("EXTRA_LOSEANSWER"));
    }

    public void onClickCloseTour(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
