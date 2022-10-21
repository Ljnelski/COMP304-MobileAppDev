package com.example.liamnelski_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exercise1Button = findViewById(R.id.exercise1Button);
        exercise1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExerciseOne.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.exercise2Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExerciseTwo.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.exercise3Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExerciseThree.class);
                startActivity(intent);
            }
        });
    }
}