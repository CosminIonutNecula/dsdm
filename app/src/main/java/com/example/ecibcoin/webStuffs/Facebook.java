package com.example.ecibcoin.webStuffs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;
import com.example.ecibcoin.R;

public class Facebook extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        Objects.requireNonNull(getSupportActionBar()).hide();

        WebView webView = findViewById(R.id.webFacebook);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.facebook.com/ECibCoin-Watcher-100161395978939");
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