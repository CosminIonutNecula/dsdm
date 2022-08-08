package com.example.ecibcoin.webStuffs;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecibcoin.R;

import java.util.Objects;

public class BrowseWeb extends AppCompatActivity {

private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_web);
        Objects.requireNonNull(getSupportActionBar()).hide();

        WebView webView = findViewById(R.id.webViewBroserWeb);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);

    }
    /*public void onBackPressed(){
        if (webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
*/
    int counter=0;
    public void onBackPressed(){
        counter++;
        if(counter==1){
            super.onBackPressed();
        }
    }
}