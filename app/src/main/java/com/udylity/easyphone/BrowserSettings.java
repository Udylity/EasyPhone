package com.udylity.easyphone;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class BrowserSettings extends PreferenceActivity {
	
	//public WebView mybrowser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.browsersettings);
	/*	mybrowser = (WebView)findViewById(R.id.webviewbrowser);
		Preference clearhistory = findPreference("clearhistory");
		
		clearhistory.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			
			public boolean onPreferenceClick(Preference preference) {
				mybrowser.clearHistory();
				return false;
			}
		});*/
	}
}
