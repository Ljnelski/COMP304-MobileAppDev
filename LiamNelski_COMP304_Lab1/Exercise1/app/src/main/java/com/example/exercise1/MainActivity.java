package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DisplayMessage(View view) {
        EditText messageText = (EditText)findViewById(R.id.messageText);

        Intent messageIntent = new Intent(MainActivity.this, DisplayActivity.class);
        messageIntent.putExtra("message", messageText.getText().toString());

        startActivity(messageIntent);
    }
}