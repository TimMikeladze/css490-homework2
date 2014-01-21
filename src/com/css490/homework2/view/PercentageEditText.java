package com.css490.homework2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;


public class PercentageEditText extends EditText {
    private double value;

    public PercentageEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public PercentageEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentageEditText(Context context) {
        super(context);
    }

    public void setText(double value) {
        setText(String.valueOf(value) + "%");
    }

    public double getValue(){
        return value;
    }

}
