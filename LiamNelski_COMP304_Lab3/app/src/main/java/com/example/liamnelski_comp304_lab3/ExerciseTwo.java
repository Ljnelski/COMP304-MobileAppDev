package com.example.liamnelski_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ExerciseTwo extends AppCompatActivity {

    private AnimationDrawable dinoRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_two);

        // set up controls
        Button playButton = findViewById(R.id.startAnimationButton);
        Button pauseButton = findViewById(R.id.pauseAnimationButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseAnimation();
            }
        });

        ImageView animDisplayImageView = findViewById(R.id.animationDisplay);

        // Set up animation
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.dino_walk_0000);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.dino_walk_0001);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.dino_walk_0002);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.dino_walk_0003);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.dino_walk_0004);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.dino_walk_0005);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.dino_walk_0006);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.dino_walk_0007);

        int frameDuration = 100;

        dinoRunning = new AnimationDrawable();
        dinoRunning.setOneShot(false);
        dinoRunning.addFrame(frame1, frameDuration);
        dinoRunning.addFrame(frame2, frameDuration);
        dinoRunning.addFrame(frame3, frameDuration);
        dinoRunning.addFrame(frame4, frameDuration);
        dinoRunning.addFrame(frame5, frameDuration);
        dinoRunning.addFrame(frame6, frameDuration);
        dinoRunning.addFrame(frame7, frameDuration);
        dinoRunning.addFrame(frame8, frameDuration);

        animDisplayImageView.setBackground(dinoRunning);


    }

    private void startAnimation() {
        dinoRunning.setVisible(true, true);
        dinoRunning.start();
    }

    private void pauseAnimation() {
        dinoRunning.stop();
    }
}