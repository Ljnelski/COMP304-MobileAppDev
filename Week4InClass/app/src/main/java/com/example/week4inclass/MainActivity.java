package com.example.week4inclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String contact = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add pop up menu
        Button popupButton = findViewById(R.id.popButton);
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this, popupButton);
                MenuInflater inflator = popup.getMenuInflater();
                inflator.inflate(R.menu.popup_menu, popup.getMenu());
                popup.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(MainActivity.this, "You Clicked on " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        });

        // Register Context menu to the listview
        ListView listView = findViewById(R.id.contactListView);
        TextView tv = findViewById(R.id.contactListTextView);

        registerForContextMenu(listView);
        registerForContextMenu(tv);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                contact = adapterView.getAdapter().getItem(i).toString();
            }
        });
    }

    // menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    // handle menu item selection

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start:
                Toast.makeText(MainActivity.this, "You clicked on Start", Toast.LENGTH_SHORT).show();
                break;
            case R.id.stop:
                Toast.makeText(MainActivity.this, "You clicked on Stop", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(MainActivity.this, "You clicked on Help", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select The Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.call) {
            Toast.makeText(MainActivity.this, "Calling " + contact, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.sms) {
            Toast.makeText(MainActivity.this, "SMS " + contact, Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return true;
    }

    public void openActionBarActivity(View view) {
        Intent intent = new Intent(this, ActionBarActivity.class);
        startActivity(intent);
    }

    public void openPrefActionBarActivity(View view) {
        Intent intent = new Intent(this, SharedPrefActivity.class);
        startActivity(intent);
    }
}