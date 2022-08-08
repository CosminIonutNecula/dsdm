package com.example.ecibcoin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class CreareCont extends AppCompatActivity {

    Button createACC;
    TextInputEditText tietEmail;
    TextInputEditText tietParola;
    FirebaseAuth mAuth;
    TextView tvGoToLoginPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_cont);
        Objects.requireNonNull(getSupportActionBar()).hide();

        mAuth = FirebaseAuth.getInstance();

        tietEmail=findViewById(R.id.tietEmail);
        tietParola=findViewById(R.id.tietParola);
        createACC=findViewById(R.id.btnCreareContNou);
        tvGoToLoginPage=findViewById(R.id.tvGoToLoginPage);
        tvGoToLoginPage.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),Logare.class);
            startActivity(intent);
        });

        createACC.setOnClickListener(view -> registerNewUser());
    }

    private void registerNewUser(){
        String email, parola;
        email= Objects.requireNonNull(tietEmail.getText()).toString();
        parola= Objects.requireNonNull(tietParola.getText()).toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),
                    "Introduceti adresa de email!",
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

        mAuth
                .createUserWithEmailAndPassword(email, parola)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "Inregistrare cu succes!",
                                    Toast.LENGTH_LONG)
                                    .show();


                            Intent intent
                                    = new Intent(CreareCont.this,
                                    MeniuAplicatie.class);
                            startActivity(intent);
                        }
                        else {

                            Toast.makeText(
                                    getApplicationContext(),
                                    "Inregistrarea a esuat!"
                                            + " Incercati mai tarziu cu alte credentiale",
                                    Toast.LENGTH_LONG)
                                    .show();

                        }
                    }
                });
    }
}