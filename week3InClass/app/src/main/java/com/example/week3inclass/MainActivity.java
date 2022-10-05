package com.example.week3inclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button click = (Button) findViewById(R.id.click);
        TextView textView = findViewById(R.id.textView);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("You clicked on the Button!");
            }
        });

        // add ToggleButton
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) textView.setText("ToggleButton is enabled");
                else textView.setText("ToggleButton is disabled");
            }
        });

        // add Checkbox
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code Runs when checkbox is selected
                if (checkBox.isChecked()) DisplayToast("Checkbox is checked", Toast.LENGTH_SHORT);
            }
        });

        // add RadioGroup
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // our code that needs to happen when user selects the radio buttons
                if(i != -1) {
                    RadioButton radioButton = findViewById(i);
                    if(radioButton != null) {
                        DisplayToast("You chose: " + radioButton.getText().toString(), Toast.LENGTH_SHORT);
                    }
                    else {
                        DisplayToast("Please choose one Radio button ", Toast.LENGTH_SHORT);
                    }
                }
            }
        });

        //add Spinner
        Spinner spin = findViewById(R.id.spinner);
        Button submit = findViewById(R.id.button2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.provinces, android.R.layout.simple_spinner_item);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text_sel = (TextView) spin.getSelectedView();
                DisplayToast("You Selected: " + text_sel.getText(), Toast.LENGTH_SHORT);
            }
        });

        //add rating
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ((TextView) findViewById(R.id.textRating)).setText("Rating: " + v);
            }
        });
    }

    private void DisplayToast(String s, int duration) {
        Toast toast = Toast.makeText(getApplicationContext(), s, duration);
        toast.show();
    };
}