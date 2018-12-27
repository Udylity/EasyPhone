package com.udylity.easyphone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity implements OnClickListener{
	
	EditText emailaddress,subject,cc,bcc,message;
	String stringemailaddress, stringsubject, /*stringcc, stringbcc,*/ stringmessage;
	Button send;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		setup();
	}

	private void setup() {
		emailaddress = (EditText) findViewById(R.id.emailaddress);
		subject = (EditText) findViewById(R.id.subject);
		//cc = (EditText) findViewById(R.id.cc);
		//bcc = (EditText) findViewById(R.id.bcc);
		message = (EditText) findViewById(R.id.message);
		
		send = (Button) findViewById(R.id.sendemail);
		send.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()){
		case R.id.sendemail:
			converttostring();
			String emailaddress[]= { stringemailaddress };
			Intent sendemailIntent = new Intent (Intent.ACTION_SEND);
			sendemailIntent.putExtra(Intent.EXTRA_EMAIL, emailaddress);
			sendemailIntent.putExtra(Intent.EXTRA_SUBJECT, stringsubject);
			sendemailIntent.setType("plain/text");
			//sendemailIntent.putExtra(android.content.Intent.EXTRA_CC, stringcc);
			//sendemailIntent.putExtra(android.content.Intent.EXTRA_BCC, stringbcc);
			sendemailIntent.putExtra(Intent.EXTRA_TEXT, stringmessage);
			startActivity(sendemailIntent);
			break;
		}
		
	}

	private void converttostring() {
		stringemailaddress = emailaddress.getText().toString();
		stringsubject = subject.getText().toString();
		//stringcc = cc.getText().toString();
		//stringbcc = bcc.getText().toString();
		stringmessage = message.getText().toString();
	}

}
