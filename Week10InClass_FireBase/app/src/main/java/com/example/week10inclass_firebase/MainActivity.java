package com.example.week10inclass_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FireBaseDatabase.getInstance().getReference("exampleDB");
        JSONObject jsonObject;
        String id = databaseReference.push().getKey();
        databaseReference.child(id).setValue("hello world!");
    }
}