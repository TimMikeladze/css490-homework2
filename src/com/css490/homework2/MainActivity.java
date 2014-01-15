
package com.css490.homework2;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements OnEditorActionListener, OnClickListener {
    private static final int DEFAULT_TIP_PERCENTAGE = 17;

    private EditText billTotalTextField;
    private EditText tipTextField;
    private EditText totalTextField;
    private EditText partySizeTextField;
    private EditText splitTotalTextField;

    private ImageButton decrementTipButton;
    private ImageButton incrementTipButton;

    private ImageButton decrementPartySizeButton;
    private ImageButton incrementPartySizeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billTotalTextField = (EditText) findViewById(R.id.edittext_bill_total);
        billTotalTextField.setOnEditorActionListener(this);
        tipTextField = (EditText) findViewById(R.id.edittext_tip);
        tipTextField.setText(String.valueOf(DEFAULT_TIP_PERCENTAGE));

        totalTextField = (EditText) findViewById(R.id.edittext_total);
        partySizeTextField = (EditText) findViewById(R.id.edittext_party_size);
        splitTotalTextField = (EditText) findViewById(R.id.edittext_split_total);
        decrementTipButton  = (ImageButton) findViewById(R.id.button_decrement_tip);
        decrementTipButton.setOnClickListener(this);
        incrementTipButton  = (ImageButton) findViewById(R.id.button_increment_tip);
        incrementTipButton.setOnClickListener(this);
        incrementPartySizeButton  = (ImageButton) findViewById(R.id.button_increment_party_size);
        incrementPartySizeButton.setOnClickListener(this);
        decrementPartySizeButton  = (ImageButton) findViewById(R.id.button_decrement_party_size);
        decrementPartySizeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // TODO Auto-generated method stub
        return false;
    }

}
