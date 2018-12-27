package com.udylity.easyphone;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Weather extends AppCompatActivity implements OnClickListener{

	static final String baseURL = "http://www.google.com/ig/api?weather=";
	String scity,sstate, fullUrl;
	TextView display;
	EditText ecity, estate;
	Button getweather;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		setup();
	}

	private void setup() {
		getweather = (Button) findViewById(R.id.getweatherbutton);
		display = (TextView) findViewById(R.id.currentweather);
		ecity = (EditText) findViewById(R.id.cityedittext);
		estate = (EditText) findViewById(R.id.stateedittext);
		
		getweather.setOnClickListener(this);
	}

	public void onClick(View v) {
		scity = ecity.getText().toString();
		sstate = estate.getText().toString();
		if (scity.contains(" ")){
			scity.replace(" ", "%20");
		}
		if(sstate.contains(" ")){
			sstate.replace(" ", "%20");
		}else{
		StringBuilder URL = new StringBuilder(baseURL);
		URL.append(scity + "," + sstate);
		fullUrl = URL.toString();
		//hiding keyboard
		InputMethodManager immcity = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		immcity.hideSoftInputFromWindow(ecity.getWindowToken(), 0);
		InputMethodManager immstate = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		immstate.hideSoftInputFromWindow(estate.getWindowToken(), 0);}
		try{
			URL website = new URL(fullUrl);
		//Getting xmlreader to parse data
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xmlreader = sp.getXMLReader();
			
			WeatherHandlingxml doingWork = new WeatherHandlingxml();
			xmlreader.setContentHandler(doingWork);
			xmlreader.parse(new InputSource(website.openStream()));
			
			String information = doingWork.getInformation();
			display.setText(information);
		}catch (Exception e) {
			display.setText("Try to put %20 in the space");
		}
	}

}
