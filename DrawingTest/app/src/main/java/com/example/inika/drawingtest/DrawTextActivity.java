package com.example.inika.drawingtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DrawTextActivity extends DrawingActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//show the new view
		setContentView(new ViewWithText(this));
	}

	 private static class ViewWithText extends View {
	        private Paint    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	        private Typeface mType;
	        
	        public ViewWithText(Context context) {
	            super(context);

	            mPaint.setTextSize(40);
	        }
	        
	        @Override protected void onDraw(Canvas canvas) {
	            //set the background
	        	canvas.drawColor(Color.WHITE);
				//set the default font
	            mPaint.setTypeface(null);
				mPaint.setTextSize(40);
	            canvas.drawText("Default Typeface (Normal)", 30, 40, mPaint);

	            mType = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Sans Serif Typeface (Normal)", 30, 80, mPaint);
	            
	            mType = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Sans Serif Typeface (Bold)", 30, 120, mPaint);
	            	          
	            mType = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Monospace Typeface (Normal)", 30, 160, mPaint);
	            
	            mType = Typeface.create(Typeface.SERIF, Typeface.NORMAL);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Serif Typeface (Normal)", 30, 200, mPaint);
	            
	            mType = Typeface.create(Typeface.SERIF, Typeface.BOLD);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Serif Typeface (Bold)", 30, 240, mPaint);
	            
	            mType = Typeface.create(Typeface.SERIF, Typeface.ITALIC);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Serif Typeface (Italic)", 30, 280, mPaint);

	            mType = Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Serif Typeface (Bold Italic)", 30, 320, mPaint);
	                  	      
	            mPaint.setTypeface(null);
	            mPaint.setTextSize(30);
	            canvas.drawText("Text Size 18", 30, 400, mPaint);
	            
	            mPaint.setTextSize(30);
	            canvas.drawText("Text Size 22", 30, 440, mPaint);

	            mPaint.setTextSize(30);
	            mPaint.setAntiAlias(false);
	            canvas.drawText("Text Not Anti-Aliased", 30, 520, mPaint);

	            mPaint.setAntiAlias(true);
	            mPaint.setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
	            canvas.drawText("Strike through", 30, 560, mPaint);
	            
	            mPaint.setFlags(Paint.UNDERLINE_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
	            canvas.drawText("Underlined", 30, 600, mPaint);
	            
	        }
	    }
}
