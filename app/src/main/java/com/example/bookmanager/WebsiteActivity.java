package com.example.bookmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteActivity extends AppCompatActivity {

	private WebView webView;
	public static final String URL_NAME_TAG = "url";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_website);

		webView = findViewById(R.id.website_web_view);
		Intent intent = getIntent();

		if (null != intent) {
			String url = intent.getStringExtra(URL_NAME_TAG);
			webView.loadUrl(url);
		} else {
			webView.loadUrl("https://www.google.com/");
		}
		webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);
	}

	@Override
	public void onBackPressed() {
		if (webView.canGoBack()) {
			webView.goBack();
		} else {
			super.onBackPressed();
		}
	}
}
