package com.example.liamnelski_comp304_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Update;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.liamnelski_comp304_lab4.Database.Models.Applicant;
import com.example.liamnelski_comp304_lab4.ViewModel.ApplicantViewModel;

public class UpdateInfoActivity extends AppCompatActivity {

    private ApplicantViewModel applicantViewModel;
    private SharedPreferences examinerSharedPreferences;

    private Button updateApplicantButton;
    private Button returnButton;

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText testCentreEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        applicantViewModel = new ViewModelProvider(this).get(ApplicantViewModel.class);
        examinerSharedPreferences = getSharedPreferences("examiner", MODE_PRIVATE);

        updateApplicantButton = findViewById(R.id.updateApplicantButton);
        returnButton = findViewById(R.id.updateInfoToApplicantButton);

        firstNameEditText = findViewById(R.id.updateApplicantFirstNameEditText);
        lastNameEditText = findViewById(R.id.updateApplicantLastNameEditText);
        testCentreEditText = findViewById(R.id.updateApplicantTestCentreEditText);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateInfoActivity.this, ApplicantActivity.class);
                startActivity(intent);
            }
        });

        updateApplicantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Applicant newApplicant = new Applicant(
                        getIntent().getIntExtra("focusedApplicantId", -1),
                        firstNameEditText.getText().toString(),
                        lastNameEditText.getText().toString(),
                        testCentreEditText.getText().toString(),
                        examinerSharedPreferences.getInt("examinerId", -1)
                );

                applicantViewModel.update(newApplicant);

                Intent intent = new Intent(UpdateInfoActivity.this, ApplicantActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firstNameEditText.setText(getIntent().getStringExtra("focusedApplicantFirstname"));
        lastNameEditText.setText(getIntent().getStringExtra("focusedApplicantLastname"));
        testCentreEditText.setText(getIntent().getStringExtra("focusedApplicantTestCentre"));
    }
}