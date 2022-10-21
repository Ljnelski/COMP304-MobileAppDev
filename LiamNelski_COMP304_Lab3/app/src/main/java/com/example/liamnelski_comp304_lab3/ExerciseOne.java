package com.example.liamnelski_comp304_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class ExerciseOne extends AppCompatActivity {

    private ImageView canvasDisplay;
    private ImageView upImageView;
    private ImageView leftImageView;
    private ImageView downImageView;
    private ImageView rightImageView;

    private TextView yValueTextView;
    private TextView xValueTextView;

    private RadioGroup colourRadioGroup;

    private Button clearCanvasButton;

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    //
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_one);

        Spinner lineThicknessSpinner = (Spinner) findViewById(R.id.lineThicknessSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.penThickness, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lineThicknessSpinner.setAdapter(adapter);

        lineThicknessSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int pos, long id) {
                paint.setStrokeWidth(Integer.parseInt(parent.getItemAtPosition(pos).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        colourRadioGroup = findViewById(R.id.colorRadioGroup);
        colourRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Log.d("ColorRadioGroup ", String.valueOf(i));
                if(i != -1) {
                    RadioButton radioButton = findViewById(i);
                    switch (radioButton.getText().toString()) {
                        case "Purple":
                            paint.setColor(Color.MAGENTA);
                            break;
                        case "Gold":
                            paint.setColor(Color.YELLOW);
                            break;
                        case "Black":
                            paint.setColor(Color.BLACK);
                            break;
                    }
                }
            }
        });

        upImageView = findViewById(R.id.upImageView);
        upImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawLine(canvas, DRAW_DIRECTION.UP);
            }
        });

        leftImageView = findViewById(R.id.leftImageView);
        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawLine(canvas, DRAW_DIRECTION.LEFT);
            }
        });
        downImageView = findViewById(R.id.downImageView);
        downImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawLine(canvas, DRAW_DIRECTION.DOWN);
            }
        });

        rightImageView = findViewById(R.id.rightImageView);
        rightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawLine(canvas, DRAW_DIRECTION.RIGHT);
            }
        });

        clearCanvasButton = findViewById(R.id.clearCanvasButton);
        clearCanvasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearCanvas();
            }
        });

        yValueTextView = findViewById(R.id.yValueTextView);
        xValueTextView = findViewById(R.id.xValueTextView);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);

        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.WHITE); //background
        //setup the image view
        canvasDisplay = (ImageView) findViewById(R.id.canvasImageView);
        //tell image view for the bitmap format/content
        canvasDisplay.setImageBitmap(bitmap);
        canvasDisplay.setVisibility(View.VISIBLE);

        clearCanvas();
    }

    public void clearCanvas() {
        colourRadioGroup.check(R.id.radioButtonPurple);
        canvas.drawColor(Color.WHITE); //background
        startX = 15;
        startY = 15;
        endX = 15;
        endY = 15;
        yValueTextView.setText("Y Value: " + String.valueOf(endY));
        xValueTextView.setText("X Value: " + String.valueOf(endX));
    }


    public void drawLine(Canvas canvas, DRAW_DIRECTION drawDirection) {
        switch (drawDirection) {
            case UP:
                endY = endY - 10;
                break;
            case LEFT:
                endX = endX - 10;
                break;
            case DOWN:
                endY = endY + 10;
                break;
            case RIGHT:
                endX = endX + 10;
                break;
            default:
                break;
        }

        yValueTextView.setText("Y Value: " + String.valueOf(endY));
        xValueTextView.setText("X Value: " + String.valueOf(endX));
        //        canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(startX, startY, endX, endY, paint);
        startX = endX;
        startY = endY;
    }

    private enum DRAW_DIRECTION {
        UP,
        LEFT,
        RIGHT,
        DOWN
    }

}