package com.example.ecibcoin.webStuffs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ecibcoin.R;
import com.example.ecibcoin.SocialMedia;

import java.util.Objects;

public class Instagram extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        Objects.requireNonNull(getSupportActionBar()).hide();

        WebView webView = findViewById(R.id.webInstagram);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.instagram.com/investitorii/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);

    }

    int counter=0;
    public void onBackPressed(){
        counter++;
        if(counter==1){
            super.onBackPressed();
        }
    }
}