package com.example.liamnelski_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ExerciseThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_three);

        ImageView earthImageView = findViewById(R.id.earthImageView);
        Animation earthAnimation = AnimationUtils.loadAnimation(this, R.anim.earth);

        ImageView moonImageView = findViewById(R.id.moonImageView);
        Animation moonAnimation = AnimationUtils.loadAnimation(this, R.anim.moon);

        earthImageView.startAnimation(earthAnimation);
        moonImageView.startAnimation(moonAnimation);

    }
}