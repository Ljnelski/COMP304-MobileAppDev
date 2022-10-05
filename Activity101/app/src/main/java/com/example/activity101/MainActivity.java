package com.example.activity101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String tag = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log message in run window
        Log.d(tag, "In the onCreate() event");
        //Toast message on the screen
        Toast.makeText(getApplicationContext(),"In the onCreate() event",Toast.LENGTH_LONG).show();
    }

    //onStart() life cycle method
    public void onStart()
    {
        super.onStart();
        Log.d(tag, "In the onStart() event");
        Toast.makeText(getApplicationContext(),"In the onStart() event",Toast.LENGTH_LONG).show();
    }

    //onRestart() life cycle method
    public void onRestart()
    {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
        Toast.makeText(getApplicationContext(),"In the onRestart() event",Toast.LENGTH_LONG).show();
    }

    //onResume() life cycle method
    public void onResume()
    {
        super.onResume();
        Log.d(tag, "In the onResume() event");
        Toast.makeText(getApplicationContext(),"In the onResume() event",Toast.LENGTH_LONG).show();
    }

    //onPause() life cycle method
    public void onPause()
    {
        super.onPause();
        Log.d(tag, "In the onPause() event");
        Toast.makeText(getApplicationContext(),"In the onPause() event",Toast.LENGTH_LONG).show();
    }

    //onStop() life cycle method
    public void onStop()
    {
        super.onStop();
        Log.d(tag, "In the onStop() event");
        Toast.makeText(getApplicationContext(),"In the onStop() event",Toast.LENGTH_LONG).show();
    }

    //onDestroy() life cycle method
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
        Toast.makeText(getApplicationContext(),"In the onDestroy() event",Toast.LENGTH_LONG).show();
    }
}