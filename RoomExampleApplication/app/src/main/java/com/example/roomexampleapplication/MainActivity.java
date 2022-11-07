package com.example.roomexampleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDataBase myAppDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        myAppDataBase = Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "userDataBase").allowMainThreadQueries().build();

        View status = findViewById(R.id.fragmentContainer);

        if(status != null) {
            if(savedInstanceState != null) {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragmentContainer, new HomeFragment()).commit();
        }

    }
}