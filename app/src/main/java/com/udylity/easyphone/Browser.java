package com.udylity.easyphone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity implements OnClickListener {

	public WebView myBrowser;
	EditText addresbar;
	Button go;
	static String theWebsite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);

		setup();

		myBrowser.getSettings().setSupportMultipleWindows(true);
		myBrowser.getSettings().setBuiltInZoomControls(true);
		myBrowser.getSettings().setJavaScriptEnabled(true);
		myBrowser.getSettings().setLoadWithOverviewMode(true);
		myBrowser.getSettings().setUseWideViewPort(true);
		myBrowser.getSettings().getSavePassword();

		myBrowser.setWebViewClient(new BrowserViewClient());
		try {
			myBrowser.loadUrl("https://www.google.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setup() {
		myBrowser = (WebView) findViewById(R.id.webviewbrowser);
		addresbar = (EditText) findViewById(R.id.addressbar);

		go = (Button) findViewById(R.id.gotoaddress);

		go.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.gotoaddress:

			theWebsite = addresbar.getText().toString();
			if (theWebsite.startsWith("http://www.")) {
				checkbackurl();
			} else if (theWebsite.startsWith("https://www.")) {
				checkbackurl();
			} else if (theWebsite.startsWith("www.")) {
				theWebsite = "https://" + theWebsite;
				checkbackurl();
			} else {
				theWebsite = "https://www." + theWebsite;
				if (theWebsite.contains(".com") || theWebsite.contains(".org")
						|| theWebsite.contains(".edu")
						|| theWebsite.endsWith(".html")
						|| theWebsite.endsWith(".gov")) {
					myBrowser.loadUrl(theWebsite);

				} else {
					theWebsite = theWebsite + ".com";
					myBrowser.loadUrl(theWebsite);

				}
			}

			// hiding keyboard
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(addresbar.getWindowToken(), 0);
			break;
		}
	}

	private void checkbackurl() {
		if (theWebsite.contains(".com") || theWebsite.contains(".org")
				|| theWebsite.contains(".edu") || theWebsite.endsWith(".html")
				|| theWebsite.endsWith(".gov")) {
			myBrowser.loadUrl(theWebsite);

		} else {
			theWebsite = theWebsite + ".com";
			myBrowser.loadUrl(theWebsite);

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater menucreate = getMenuInflater();
		menucreate.inflate(R.menu.webbrowser_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.refresh:

			myBrowser.reload();

			return true;
		case R.id.forward:
			if (myBrowser.canGoForward()) {
				myBrowser.goForward();
			}
			return true;

		case R.id.back:
			if (myBrowser.canGoBack()) {
				myBrowser.goBack();
			}
			return true;

		case R.id.webbrowsersettings:
			startActivity(new Intent("com.easyphone.drich81.BROWSERSETTINGS"));
			return true;

		case R.id.quit:
			finish();
			return true;

		case R.id.clearhistory:
			myBrowser.clearHistory();
			return true;
		}
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && myBrowser.canGoBack()) {
			myBrowser.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("thewebsite", theWebsite);
		outState.putString("address", addresbar.getText().toString());
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		addresbar.setText(savedInstanceState.getString("address"));
		myBrowser.loadUrl(theWebsite);
	}

}
