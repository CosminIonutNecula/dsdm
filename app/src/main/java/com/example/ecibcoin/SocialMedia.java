package com.example.ecibcoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecibcoin.webStuffs.Facebook;
import com.example.ecibcoin.webStuffs.Instagram;
import com.example.ecibcoin.webStuffs.Youtube;

import java.util.Objects;

public class SocialMedia extends AppCompatActivity {
    Button btnFacebook, btnYoutube, btnInstagram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnFacebook=findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Facebook.class);
                startActivity(intent);
            }
        });

        btnYoutube=findViewById(R.id.btnYoutube);
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Youtube.class);
                startActivity(intent);
            }
        });
        btnInstagram=findViewById(R.id.btnInstagram);
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Instagram.class);
                startActivity(intent);
            }
        });
    }
}