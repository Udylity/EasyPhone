package com.udylity.easyphone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Phonedialer extends AppCompatActivity implements OnClickListener{

	Button call, contacts, zero, one,two,three,four,five,six,seven,eight,nine,multiplication,numbersingn;
	ImageButton backspace;
	
	EditText phonenumber;
	
	String stringphonenumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phonedialer);
		setup();
	}

	private void setup() {
		phonenumber = (EditText)findViewById(R.id.phonenuberedittext);
		call = (Button)findViewById(R.id.call);
		contacts = (Button)findViewById(R.id.callfromcontacts);
		multiplication = (Button)findViewById(R.id.phonenumbermultiplication);
		numbersingn = (Button)findViewById(R.id.phonenumbernumbersing);
		backspace = (ImageButton)findViewById(R.id.backspace);
		zero = (Button) findViewById(R.id.phonenumber0);
		one = (Button) findViewById(R.id.phonenumber1);
		two = (Button) findViewById(R.id.phonenumber2);
		three = (Button) findViewById(R.id.phonenumber3);
		four = (Button) findViewById(R.id.phonenumber4);
		five = (Button) findViewById(R.id.phonenumber5);
		six = (Button) findViewById(R.id.phonenumber6);
		seven = (Button) findViewById(R.id.phonenumber7);
		eight = (Button) findViewById(R.id.phonenumber8);
		nine = (Button) findViewById(R.id.phonenumber9);
		
		call.setOnClickListener(this);
		contacts.setOnClickListener(this);
		zero.setOnClickListener(this);
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		multiplication.setOnClickListener(this);
		numbersingn.setOnClickListener(this);
		backspace.setOnClickListener(this);
		
	}

	public void onClick(View v) {
		switch (v.getId()){
		
		case R.id.call:
			String callphonenumber = "tel:" + phonenumber.getText().toString().trim();
			Intent callphoneIntent = new Intent (Intent.ACTION_CALL,Uri.parse(callphonenumber));
			startActivity(callphoneIntent);
			finish();
			break;
		case R.id.callfromcontacts:
			Intent phonecontactsIntent = new Intent (Phonedialer.this, Phonecontacts.class);
			startActivity(phonecontactsIntent);
			finish();
			break;
		case R.id.backspace:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber.substring(0, stringphonenumber.length()-1);
			phonenumber.setText(stringphonenumber);
			break;
			
		case R.id.phonenumber0:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "0";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber1:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "1";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber2:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "2";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber3:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "3";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber4:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "4";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber5:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "5";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber6:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "6";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber7:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "7";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber8:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "8";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumber9:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "9";
			phonenumber.setText(stringphonenumber);
			break;
			
		case R.id.phonenumbermultiplication:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "*";
			phonenumber.setText(stringphonenumber);
			break;
		case R.id.phonenumbernumbersing:
			stringphonenumber = phonenumber.getText().toString();
			stringphonenumber = stringphonenumber + "#";
			phonenumber.setText(stringphonenumber);
			break;
			
		}
	}

}
