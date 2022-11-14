package com.example.week10inclass_sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText idEditText, nameEditText, filterNameEditText;
    Button addDataButton, viewDataButton, filterNameButton;

    ListView dataListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText = findViewById(R.id.idEditText);
        nameEditText = findViewById(R.id.nameEditText);
        filterNameEditText = findViewById(R.id.filterNameEditText);

        dataListView = findViewById(R.id.dataListView);

        addDataButton = findViewById(R.id.addDataButton);
        viewDataButton = findViewById(R.id.viewDataButton);
        filterNameButton = findViewById(R.id.filterNameButton);

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(nameEditText.getText().toString());
                UserDatabase userDatabase = new UserDatabase(MainActivity.this);
                boolean status = userDatabase.addOne(user);
                if(status)
                    Toast.makeText(MainActivity.this, "User Added Successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "User Added Unsuccessfully", Toast.LENGTH_LONG).show();
            }
        });

        viewDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDatabase userDatabase = new UserDatabase(MainActivity.this);
                List<User> everyone = userDatabase.getAll();
                Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_LONG).show();

                ArrayAdapter userArrayAdaptor = new ArrayAdapter<User>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
                dataListView.setAdapter(userArrayAdaptor);
            }
        });

        filterNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDatabase userDatabase = new UserDatabase(MainActivity.this);
                List<User> everyone = userDatabase.getAll();
                Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_LONG).show();

                ArrayAdapter userArrayAdaptor = new ArrayAdapter<User>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
                dataListView.setAdapter(userArrayAdaptor);
            }
        });
    }
}