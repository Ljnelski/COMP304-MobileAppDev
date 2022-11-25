package com.example.liamnelski_comp304_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liamnelski_comp304_lab4.ViewModel.ExaminerViewModel;
import com.example.liamnelski_comp304_lab4.Database.Models.Examiner;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Button loginButton, returnButton;

    EditText usernameEditText, passwordEditText;
    ExaminerViewModel examinerViewModel;

    ArrayList<Examiner> examinerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        examinerViewModel = new ViewModelProvider(this).get(ExaminerViewModel.class);
        SharedPreferences examinerSharedPreferences = getSharedPreferences("examiner", MODE_PRIVATE);
        SharedPreferences.Editor examinerEditor = examinerSharedPreferences.edit();

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        returnButton = findViewById(R.id.loginToMainButton);

        examinerViewModel.examiners.observe(this, new Observer<List<Examiner>>() {
            @Override
            public void onChanged(List<Examiner> examiners) {
                examinerList = (ArrayList)examiners;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                for (Examiner examiner : examinerList) {
                    if(username.equals(examiner.getUsername())) {
                        if(password.equals(examiner.getPassword()))
                        {
                          Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                            examinerEditor.putInt("examinerId", examiner.getId());
                            examinerEditor.putString("examinerTestCentre", examiner.getTestCentre());
                            examinerEditor.commit();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Password Incorrect", Toast.LENGTH_LONG).show();
                        }
                        return;
                    }
                }

                Toast.makeText(LoginActivity.this, "Invalid Username", Toast.LENGTH_LONG).show();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}