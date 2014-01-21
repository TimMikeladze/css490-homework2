package com.css490.homework2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;


public class CurrencyEditText extends EditText {
    private double value;

    public CurrencyEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CurrencyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CurrencyEditText(Context context) {
        super(context);
    }

    public void setValue(double value) {
        this.value = value;
        setText("$" + String.valueOf(value));
    }

    public double getValue(){
        return value;
    }


}
