package com.example.ecibcoin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Logare extends AppCompatActivity {

    TextInputEditText tietEmailLogare, tietParolaLogare;
    Button btnLogare;
    TextView tvGoToCreatePage;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logare);
        Objects.requireNonNull(getSupportActionBar()).hide();

        mAuth = FirebaseAuth.getInstance();
        tvGoToCreatePage=findViewById(R.id.tvGoToCreateAccPage);
        btnLogare=findViewById(R.id.btnLogare_cont);
        tietEmailLogare=findViewById(R.id.tietUtilizatorLogare);
        tietParolaLogare=findViewById(R.id.tietParolaLogareUser);

        tvGoToCreatePage.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), CreareCont.class);
            startActivity(intent);
        });

        btnLogare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logareUser();
            }
        });
    }
    private void logareUser(){
        String email, parola;
        email=tietEmailLogare.getText().toString();
        parola=tietParolaLogare.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Trebuie introdusa adresa de email!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(parola)) {
            Toast.makeText(getApplicationContext(),
                    "Introduceti parola!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, parola)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Logare cu succes!",
                                            Toast.LENGTH_LONG)
                                            .show();


                                    Intent intent
                                            = new Intent(Logare.this,
                                            MeniuAplicatie.class);
                                    startActivity(intent);
                                }

                                else {
                                    Toast.makeText(getApplicationContext(),
                                            "Logarea a esuat. Reincercati!",
                                            Toast.LENGTH_LONG)
                                            .show();

                                }
                            }
                        });
    }
}