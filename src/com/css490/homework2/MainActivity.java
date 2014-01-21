
package com.css490.homework2;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements OnEditorActionListener, OnClickListener {
    private static final int DEFAULT_TIP_PERCENTAGE = 17;

    private EditText billTotalTextField;
    private EditText tipTextField;
    private EditText totalTextField;
    private EditText partySizeTextField;
    private EditText splitTotalTextField;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billTotalTextField = (EditText) findViewById(R.id.edittext_bill_total);
        tipTextField = (EditText) findViewById(R.id.edittext_tip_percentage);
        totalTextField = (EditText) findViewById(R.id.edittext_total);
        partySizeTextField = (EditText) findViewById(R.id.edittext_party_size);
        splitTotalTextField =(EditText) findViewById(R.id.edittext_split_total);

    }

    public void decreaseTip(View v) {

    }

    public void increaseTip(View v) {

    }

    public void increasePartySize(View v) {

    }

    public void decreasePartySize(View v) {

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
