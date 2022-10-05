package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AI_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);
        setTextView(R.id.AI_onCreateView, "OnCreate executed");

    }

    @Override
    protected void onStart() {
        super.onStart();
        setTextView(R.id.AI_onStartView, "OnStart executed");
    }

    @Override
    protected void onStop() {
        setTextView(R.id.AI_onStopView, "OnStop executed");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        setTextView(R.id.AI_onDestroyView, "OnDestroy executed");
        super.onDestroy();
    }

    private void setTextView(int Id, String msg) {
        TextView textView = (TextView) findViewById(Id);
        textView.setText(msg);
    }
}