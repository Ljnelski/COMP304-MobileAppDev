package com.example.week10contentprovider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, gradeEditText, idEditText;
    Button addButton, viewDataButton, filterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        gradeEditText = findViewById(R.id.gradeEditText);
        idEditText = findViewById(R.id.filterEditText);

        addButton = findViewById(R.id.addButton);
        viewDataButton = findViewById(R.id.viewDataButton);
        filterButton = findViewById(R.id.filterDataButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(StudentProvider.NAME, nameEditText.getText().toString());
                values.put(StudentProvider.GRADE, gradeEditText.getText().toString());
                Uri uri = getContentResolver().insert(StudentProvider.CONTENT_URI, values);

                Toast.makeText(MainActivity.this, uri.toString(), Toast.LENGTH_LONG).show();
            }
        });

        viewDataButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String URL = "content://com.example.week10contentprovider.StudentProvider/students";
                Uri students = Uri.parse(URL);
                Cursor cursor = getContentResolver().query(students, null, null, null, null, null);
                Log.d("MainActivity Print" , "Cursor is null: " + Boolean.toString(cursor == null));
                String myStudents = "";

                for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    myStudents = myStudents + cursor.getString(cursor.getColumnIndex(StudentProvider._ID)) + " , " +
                            cursor.getString(cursor.getColumnIndex(StudentProvider.NAME)) + " , " +
                            cursor.getString(cursor.getColumnIndex(StudentProvider.GRADE)) + "//";
                }
                Toast.makeText(MainActivity.this, myStudents, Toast.LENGTH_LONG).show();
            }
        });

        filterButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String URL = "content://com.example.week10contentprovider.StudentProvider/students/" + idEditText.getText().toString();
                Uri students = Uri.parse(URL);
                Cursor cursor = getContentResolver().query(students, null, null, null, null, null);

                String myStudents = "";

                for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    myStudents = myStudents + cursor.getString(cursor.getColumnIndex(StudentProvider._ID)) + " , " +
                            cursor.getString(cursor.getColumnIndex(StudentProvider.NAME)) + " , " +
                            cursor.getString(cursor.getColumnIndex(StudentProvider.GRADE)) + "//";
                }
                Toast.makeText(MainActivity.this, myStudents, Toast.LENGTH_LONG).show();
            }
        });
    }
}

