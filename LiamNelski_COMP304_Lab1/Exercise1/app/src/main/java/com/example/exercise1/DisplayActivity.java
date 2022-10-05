package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView messageView = (TextView)findViewById(R.id.messageView);


        Bundle messageBundle = getIntent().getExtras();

        if(messageBundle != null) {
            messageView.setText(messageBundle.getString("message"));
        }
    }
}