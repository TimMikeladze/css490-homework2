package com.css490.homework2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;


public class PercentageEditText extends EditText {

    public PercentageEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public PercentageEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PercentageEditText(Context context) {
        super(context);
    }

    public void setPercentage(double percentage) {
        setText(String.valueOf(percentage) + "%");
    }


}
