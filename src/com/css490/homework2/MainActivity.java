
package com.css490.homework2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity implements TextWatcher {

    private static final String DEFAULT_TIP_PERCENTAGE = "%17";
    private static final int DEFAULT_PARTY_SIZE = 1;

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
        billTotalTextField.addTextChangedListener(this);
        tipTextField = (EditText) findViewById(R.id.edittext_tip_percentage);
        tipTextField.setText(DEFAULT_TIP_PERCENTAGE);
        totalTextField = (EditText) findViewById(R.id.edittext_total);
        partySizeTextField = (EditText) findViewById(R.id.edittext_party_size);
        partySizeTextField.setText(String.valueOf(DEFAULT_PARTY_SIZE));
        splitTotalTextField = (EditText) findViewById(R.id.edittext_split_total);

    }

    public void decreaseTip(View v) {
        int percentage = Integer.parseInt(tipTextField.getText().toString().replace("%", ""));
        percentage = percentage - 1;
        if (percentage >= 1) {
            tipTextField.setText("%" + percentage);
            update();
        }

    }

    public void increaseTip(View v) {
        int percentage = Integer.parseInt(tipTextField.getText().toString().replace("%", ""));
        percentage = percentage + 1;
        tipTextField.setText("%" + percentage);
        update();
    }

    public void increasePartySize(View v) {
        int party = Integer.parseInt(partySizeTextField.getText().toString());
        party = party + 1;
        partySizeTextField.setText(String.valueOf(party));
        update();
    }

    public void decreasePartySize(View v) {
        int party = Integer.parseInt(partySizeTextField.getText().toString());
        party = party - 1;
        if (party >= 1) {
            partySizeTextField.setText(String.valueOf(party));
            update();
        }
    }

    private void update() {
        int percentage = Integer.parseInt(tipTextField.getText().toString().replace("%", ""));
        int party = Integer.parseInt(partySizeTextField.getText().toString());
        if (billTotalTextField.getText().length() > 0
                && !billTotalTextField.getText().toString().equals(".")) {
            double total = Double.parseDouble(billTotalTextField.getText().toString());

            double billTotal = total + (percentage * total / 100);
            double split = billTotal / party;

            totalTextField.setText(String.valueOf(billTotal));
            splitTotalTextField.setText(String.valueOf(split));
        }

    }

    @Override
    public void afterTextChanged(Editable s) {
        update();

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO Auto-generated method stub

    }

}
