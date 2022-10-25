package com.example.week6inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FetchDataActivity extends AppCompatActivity {
    public static TextView fetchDataTextView;
    private Button fetchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        fetchDataTextView = findViewById(R.id.fetchDataTextView);
        fetchButton = findViewById(R.id.fetchDataButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FetchData fetchData = new FetchData();
                fetchData.execute();
            }
        });
    }
}