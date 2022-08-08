package com.example.ecibcoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecibcoin.DespreCriptomonede.DespreCriptomonede;
import com.example.ecibcoin.Utilizator.Evenimente;
import com.example.ecibcoin.Utilizator.Notite;
import com.example.ecibcoin.webStuffs.BrowseWeb;

import java.util.Objects;

public class MeniuAplicatie extends AppCompatActivity {
        private TextView tvBrowser, tvDespre, tvSocialMedia, tvCriptomonede,
    tvFeedback, tvStiri, tvNotite, tvEvenimente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_aplicatie);
        Objects.requireNonNull(getSupportActionBar()).hide();
        tvBrowser=  findViewById(R.id.tvBrowser);
        tvBrowser.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), BrowseWeb.class);
            startActivity(intent);
        });

        tvDespre=findViewById(R.id.tvDespre);
        tvDespre.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), DespreCriptomonede.class);
            startActivity(intent);
        });

        tvSocialMedia=findViewById(R.id.tvSocialMedia);
        tvSocialMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), SocialMedia.class);
                startActivity(intent);
            }
        });
        tvCriptomonede=findViewById(R.id.tvCriptomonede);
        tvCriptomonede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Criptomonede.class);
                startActivity(intent);
            }
        });
        tvStiri=findViewById(R.id.tvStiri);
        tvStiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Stiri.class);
                startActivity(intent);
            }
        });
        tvFeedback=findViewById(R.id.Feedback);
        tvFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Feedback.class);
                startActivity(intent);
            }
        });

        tvNotite=findViewById(R.id.tvNotite);
        tvNotite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Notite.class);
                startActivity(intent);
            }
        });
        tvEvenimente=findViewById(R.id.Evenimente);
        tvEvenimente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Evenimente.class);
                startActivity(intent);
            }
        });
    }
}