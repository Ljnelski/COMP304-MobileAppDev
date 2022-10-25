package com.example.week6inclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        // create ViewModel Object
        DemoViewModel demoViewModel = new ViewModelProvider(this).get(DemoViewModel.class);
        demoViewModel.init();
        // add observer
        demoViewModel.getDemoString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        Button fetchActivityButton = findViewById(R.id.detchActivityButton);
        fetchActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FetchDataActivity.class);
                startActivity(intent);
            }
        });
    }
}