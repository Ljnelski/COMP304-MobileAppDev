package com.example.liamnelski_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.exercise1Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExceriseOne.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.exercise2Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExcersise(ExerciseOne)
            }
        });
        findViewById(R.id.exercise3Button)
    }
    private void openExcersise(AppCompatActivity activity) {
        Intent intent = new Intent(MainActivity.this, activity.class);
        startActivity(intent);
    }
}