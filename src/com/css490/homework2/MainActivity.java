
package com.css490.homework2;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements TextWatcher, OnTouchListener {
	
	private static final String DEFAULT_TIP_PERCENTAGE = "%17";
	private static final int DEFAULT_PARTY_SIZE = 1;
	
	private RelativeLayout layout;
	private EditText billTotalTextField;
	private EditText tipTextField;
	private EditText totalTextField;
	private EditText partySizeTextField;
	private EditText splitTotalTextField;
	
	private String current;
	private InputMethodManager inputMethodManager;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layout = (RelativeLayout) findViewById(R.id.layout_main);
		layout.setOnTouchListener(this);
		
		billTotalTextField = (EditText) findViewById(R.id.edittext_bill_total);
		billTotalTextField.addTextChangedListener(this);
		tipTextField = (EditText) findViewById(R.id.edittext_tip_percentage);
		tipTextField.setText(DEFAULT_TIP_PERCENTAGE);
		totalTextField = (EditText) findViewById(R.id.edittext_total);
		partySizeTextField = (EditText) findViewById(R.id.edittext_party_size);
		partySizeTextField.setText(String.valueOf(DEFAULT_PARTY_SIZE));
		splitTotalTextField = (EditText) findViewById(R.id.edittext_split_total);
		
		inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		
	}
	
	public void decreaseTip(View v) {
		int percentage = Integer.parseInt(tipTextField.getText()
														.toString()
														.replace("%", ""));
		percentage = percentage - 1;
		if (percentage >= 1) {
			tipTextField.setText("%" + percentage);
			update();
		}
		
	}
	
	public void increaseTip(View v) {
		int percentage = Integer.parseInt(tipTextField.getText()
														.toString()
														.replace("%", ""));
		percentage = percentage + 1;
		tipTextField.setText("%" + percentage);
		update();
	}
	
	public void increasePartySize(View v) {
		int party = Integer.parseInt(partySizeTextField.getText()
														.toString());
		party = party + 1;
		partySizeTextField.setText(String.valueOf(party));
		update();
	}
	
	public void decreasePartySize(View v) {
		int party = Integer.parseInt(partySizeTextField.getText()
														.toString());
		party = party - 1;
		if (party >= 1) {
			partySizeTextField.setText(String.valueOf(party));
			update();
		}
	}
	
	private void update() {
		int percentage = Integer.parseInt(tipTextField.getText()
														.toString()
														.replace("%", ""));
		int party = Integer.parseInt(partySizeTextField.getText()
														.toString());
		if (billTotalTextField.getText()
								.length() > 0 && !billTotalTextField.getText()
																	.toString()
																	.equals(".")) {
			double total = Double.parseDouble(billTotalTextField.getText()
																.toString()
																.replaceAll("[$,.]", ""));
			double billTotal = total + (percentage * total / 100);
			double split = billTotal / party;
			
			totalTextField.setText(String.valueOf(NumberFormat.getCurrencyInstance()
																.format((billTotal / 100))));
			splitTotalTextField.setText(String.valueOf(NumberFormat.getCurrencyInstance()
																	.format((split / 100))));
		}
		
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		if (!s.toString()
				.equals(current)) {
			billTotalTextField.removeTextChangedListener(this);
			
			String cleanString = s.toString()
									.replaceAll("[$,.]", "");
			
			double parsed = Double.parseDouble(cleanString);
			String formated = NumberFormat.getCurrencyInstance()
											.format((parsed / 100));
			
			current = formated;
			billTotalTextField.setText(formated);
			billTotalTextField.setSelection(formated.length());
			
			billTotalTextField.addTextChangedListener(this);
			update();
		}
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		
	}
	
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
		return true;
	}
}
