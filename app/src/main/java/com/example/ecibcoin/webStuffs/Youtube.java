package com.example.ecibcoin.webStuffs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ecibcoin.R;

import java.util.Objects;

public class Youtube extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Objects.requireNonNull(getSupportActionBar()).hide();

        WebView webView = findViewById(R.id.webYoutube);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.youtube.com/watch?v=YqayvXyrbqI");
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
