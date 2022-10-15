package com.example.liamnelski_comp304_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class PayActivity extends AppCompatActivity {
    EditText firstName, lastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
    }

    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("firstName", firstName.getText().toString());
        myEdit.putString("lastName", lastName.getText().toString());
        myEdit.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("firstName", "");
        String s2 = sh.getString("lastName", "");
        firstName.setText(s1);
        lastName.setText(s2);
    }
}