/*
 * Professional Android, 4th Edition
 * Reto Meier and Ian Lake
 * Copyright 2018 John Wiley Wiley & Sons, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.modifiedviewexample;
/*
 * Listing 5-8: Extending Text View
 */
import android.content.Context;
import java.text.NumberFormat;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

public class PriceTextView extends android.support.v7.widget.AppCompatTextView {
  private static NumberFormat CURRENCY_FORMAT =
          NumberFormat.getCurrencyInstance();
  private float mPrice;
  // These three constructors are required for all Views
  public PriceTextView(Context context) {
    this(context, null);
  }

  public PriceTextView(Context context, AttributeSet attrs) {
    this(context, attrs,0);
  }
  // Constructor used when inflating the View from XML when it has a
  // style attribute
  public PriceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    //read the custom attributes in your class by using
    // the obtainStyledAttributes method:
    final TypedArray a = context.obtainStyledAttributes(attrs,
            R.styleable.PriceTextView, // The <declare-styleable> name
            defStyleAttr,
            0); // An optional R.style to use for default values
    if (a.hasValue(R.styleable.PriceTextView_price)) {
      setPrice(a.getFloat(R.styleable.PriceTextView_price,
              0)); // default value
    }
    a.recycle(); //recycles the TypedArray

  }
  //
  //define price attribute
  public void setPrice(float price) {
    mPrice = price;
    setText(CURRENCY_FORMAT.format(price));
  }
  public float getPrice() {
    return mPrice;
  }
}