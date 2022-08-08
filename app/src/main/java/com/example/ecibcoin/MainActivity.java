package com.example.ecibcoin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button btnCreateAccPage;
    private Button btnLoginPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnCreateAccPage=findViewById(R.id.btnCreareContNouPage);
        btnCreateAccPage.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),CreareCont.class);
            startActivity(intent);
        });

        btnLoginPage=findViewById(R.id.btnLogare);
        btnLoginPage.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), Logare.class);
            startActivity(intent);
        });



    }
}