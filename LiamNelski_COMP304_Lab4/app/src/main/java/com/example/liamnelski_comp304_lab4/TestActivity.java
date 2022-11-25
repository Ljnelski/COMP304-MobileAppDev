package com.example.liamnelski_comp304_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liamnelski_comp304_lab4.Database.Models.Test;
import com.example.liamnelski_comp304_lab4.ViewModel.TestViewModel;

import java.util.Calendar;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private TestViewModel testViewModel;

    private DatePickerDialog datePickerDialog;

    private Spinner resultSpinner;
    private Button dateButton;
    private Spinner testTypeSpinner;
    private EditText testRouteEditText;

    private Button addTestButton;
    private Button returnButton;

    private int testCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        SharedPreferences examinerSharedPreferences = getSharedPreferences("examiner", MODE_PRIVATE);

        testViewModel = new ViewModelProvider(this).get(TestViewModel.class);
        testViewModel.getTests().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(List<Test> tests) {
                testCount = tests.size();
            }
        });

        initDatePicker();

        resultSpinner = findViewById(R.id.addTestResultSpinner);

        ArrayAdapter<CharSequence> resultAdapter = ArrayAdapter.createFromResource(this, R.array.testResults, android.R.layout.simple_spinner_item);
        resultSpinner.setAdapter(resultAdapter);

        testRouteEditText = findViewById(R.id.addTestRouteEditText);
        testTypeSpinner = findViewById(R.id.addTestTypeSpinner);

        ArrayAdapter<CharSequence> testTypeAdaptor = ArrayAdapter.createFromResource(this, R.array.testTypes, android.R.layout.simple_spinner_item);
        testTypeSpinner.setAdapter(testTypeAdaptor);

        returnButton = findViewById(R.id.testToTestInfoViewButton);

        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        addTestButton = findViewById(R.id.addTestButton);
        addTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int testId = testCount;
                int applicantId = getIntent().getIntExtra("focusedApplicantId", -1);
                int examinerId = examinerSharedPreferences.getInt("examinerId", -1);
                String testResult = ((TextView)resultSpinner.getSelectedView()).getText().toString();
                String date = dateButton.getText().toString();
                String testType = ((TextView)testTypeSpinner.getSelectedView()).getText().toString();
                String route = testRouteEditText.getText().toString();

                Test newTest = new Test(testId, applicantId, examinerId, date,testResult, testType, route);

                testViewModel.insert(newTest);

                Intent intent = new Intent(TestActivity.this, TestInfoViewActivity.class);
                startActivity(intent);
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, ApplicantActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String newDate = formatYear(year) + "/"
                        + formatMonth(++month) + "/"
                        + formatDay(day);

                dateButton.setText(newDate);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener(onDateSetListener);
        datePickerDialog.updateDate(year, month, day);
    }
    private String formatYear(int year) {
        return Integer.toString(year);
    }

    private String formatMonth(int month) {
        String monthString;
        if(month < 10)
            monthString = "0" + Integer.toString(month);
        else
            monthString = Integer.toString(month);

        return monthString;
    }

    private String formatDay(int day) {
        String dayString;
        if(day < 10)
            dayString = "0" + Integer.toString(day);
        else {
            dayString = Integer.toString(day);
        }
        return dayString;
    }

}