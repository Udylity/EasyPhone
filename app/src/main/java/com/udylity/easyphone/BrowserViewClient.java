package com.udylity.easyphone;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserViewClient extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView v, String url){
		v.loadUrl(url);
	
		return true;
	}
}
