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
import android.widget.TextView;

import com.example.liamnelski_comp304_lab4.Adaptors.TestAdaptor;
import com.example.liamnelski_comp304_lab4.Database.Models.Test;
import com.example.liamnelski_comp304_lab4.ViewModel.TestViewModel;

import java.util.ArrayList;
import java.util.List;

public class TestInfoViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TestViewModel testViewModel;
    private TestAdaptor testAdaptor;

    private List<Test> unfilteredTests;
    private List<Test> filteredTests;

    private Button addTestActivityButton;
    private Button returnButton;
    private TextView noTestsTextView;

    private int applicantId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_info_view);

        SharedPreferences examinerSharedPreferences = getSharedPreferences("examiner", MODE_PRIVATE);
        unfilteredTests = new ArrayList<>();
        testViewModel = new ViewModelProvider(this).get(TestViewModel.class);

        noTestsTextView = findViewById(R.id.noTestsMessageTextView);
        addTestActivityButton = findViewById(R.id.addTestActivityButton);
        addTestActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestInfoViewActivity.this, TestActivity.class);
                intent.putExtra("focusedApplicantId", getIntent().getIntExtra("focusedApplicantId", -2));
                startActivity(intent);
            }
        });

        returnButton = findViewById(R.id.testInfoViewToApplicationButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestInfoViewActivity.this, ApplicantActivity.class);
                startActivity(intent);
            }
        });

        testViewModel.repository.getTests().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(List<Test> tests) {
                unfilteredTests = tests;
                applicantId = getIntent().getIntExtra("focusedApplicantId", applicantId);
                filterTests();
            }
        });

        recyclerView = findViewById(R.id.testRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        testAdaptor = new TestAdaptor();
        recyclerView.setAdapter(testAdaptor);
    }

    @Override
    protected void onStart() {
        super.onStart();
        applicantId = getIntent().getIntExtra("focusedApplicantId", applicantId);
        filteredTests = new ArrayList<>();
        filterTests();
    }

    private void filterTests() {
        for (int i = 0; i < unfilteredTests.size(); i++) {
            Test currentTest = unfilteredTests.get(i);
            if(currentTest.getApplicantId() == applicantId) {
                filteredTests.add(currentTest);
            }
        }

        if(filteredTests.size() <= 0)
            noTestsTextView.setVisibility(View.VISIBLE);
        else
            noTestsTextView.setVisibility(View.INVISIBLE);

        testAdaptor.setTests(filteredTests);
    }
}

//tests.stream().filter(new Predicate<Test>() {
//@Override
//public boolean test(Test test) {
//        if(test.getApplicantId() == getIntent().getIntExtra("applicantId", -1))
//        return true;
//        return false;
//        }
//        });