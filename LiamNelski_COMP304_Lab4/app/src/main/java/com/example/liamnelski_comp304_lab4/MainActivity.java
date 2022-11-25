package com.example.liamnelski_comp304_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button loginActivityButton, applicantActivityButton;
    private SharedPreferences examinerSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        examinerSharedPreferences = getSharedPreferences("examiner", MODE_PRIVATE);

        loginActivityButton= findViewById(R.id.loginActivityButton);
        applicantActivityButton = findViewById(R.id.applicantActivityButton);

        loginActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        applicantActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ApplicantActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        int examinerId = examinerSharedPreferences.getInt("examinerId", -1);
        Log.d("Main Activity: "," logged in examiner ID: " + Integer.toString(examinerId));
        if (examinerId == -1) {
            applicantActivityButton.setVisibility(View.INVISIBLE);
        } else {
            applicantActivityButton.setVisibility(View.VISIBLE);
        }
    }
}