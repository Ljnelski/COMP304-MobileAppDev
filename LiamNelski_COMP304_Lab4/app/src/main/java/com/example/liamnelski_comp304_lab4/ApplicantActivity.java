package com.example.liamnelski_comp304_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.liamnelski_comp304_lab4.Adaptors.ApplicantAdaptor;
import com.example.liamnelski_comp304_lab4.Database.Models.Applicant;
import com.example.liamnelski_comp304_lab4.ViewModel.ApplicantViewModel;

import java.util.List;

public class ApplicantActivity extends AppCompatActivity {

    private ApplicantViewModel applicantViewModel;

    private EditText applicantFirstnameEditText;
    private EditText applicantLastnameEditText;
    private EditText applicantTestCentreEditText;

    private Button addApplicantButton;
    private Button returnButton;

    private int applicantCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant);

        applicantViewModel = new ViewModelProvider(this).get(ApplicantViewModel.class);
        SharedPreferences examinerSharedPreferences = getSharedPreferences("examiner", MODE_PRIVATE);

        applicantFirstnameEditText = findViewById(R.id.addApplicantFirstNameEditText);
        applicantLastnameEditText = findViewById(R.id.addApplicantLastNameEditText);
        applicantTestCentreEditText = findViewById(R.id.addApplicantTestCentreEditText);

        addApplicantButton = findViewById(R.id.addApplicantButton);
        returnButton = findViewById(R.id.applicantToMainButton);

        addApplicantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = applicantCount;
                String firstName = applicantFirstnameEditText.getText().toString();
                String lastName = applicantLastnameEditText.getText().toString();
                String testCentre = examinerSharedPreferences.getString("examinerTestCentre", "NULL ERROR");
                int examinerId = examinerSharedPreferences.getInt("examinerId", 0);

                applicantViewModel.insert(new Applicant(id, firstName, lastName, testCentre, examinerId));

                applicantFirstnameEditText.setText("");
                applicantLastnameEditText.setText("");
                applicantTestCentreEditText.setText("");
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicantActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.applicantRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ApplicantAdaptor adaptor = new ApplicantAdaptor();
        recyclerView.setAdapter(adaptor);

        applicantViewModel.getApplicants().observe(this, new Observer<List<Applicant>>() {
            @Override
            public void onChanged(List<Applicant> applicants) {
                adaptor.setApplicants(applicants);
                applicantCount = (int)applicants.stream().count();
            }
        });
    }
}