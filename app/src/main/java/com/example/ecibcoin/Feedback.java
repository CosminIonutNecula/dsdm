package com.example.ecibcoin;

import android.app.AlertDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.android.material.textfield.TextInputEditText;


public class Feedback extends AppCompatActivity {

    public TextView tvTrimiteFeedback, tvArataFeedback;
    public TextInputEditText tietNume, tietEmail, tietMesaj;
    Firebase firebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        tvTrimiteFeedback=findViewById(R.id.tvTrimiteFeedback);
        tvArataFeedback=findViewById(R.id.tvVizualizeazaFeedback);
        tietNume=findViewById(R.id.tietNumeFeedback);
        tietEmail=findViewById(R.id.tietEmailFeedback);
        tietMesaj=findViewById(R.id.tietMesajFeedback);

        Firebase.setAndroidContext(this);
        String UniqueID= Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase=new Firebase("https://ecibcoin-98771-default-rtdb.europe-west1.firebasedatabase.app//Users"+UniqueID);

        tvTrimiteFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final String nume=tietNume.getText().toString();
                final String email=tietEmail.getText().toString();
                final String mesaj=tietMesaj.getText().toString();

                Firebase child_name=firebase.child("Nume");
                child_name.setValue(nume);
                if(nume.isEmpty()){
                    tietNume.setError("Numele trebuie completat");
                    tvTrimiteFeedback.setEnabled(false);
                }else{
                    tietNume.setError(null);
                    tvTrimiteFeedback.setEnabled(true);
                }
                Firebase child_email=firebase.child("Email");
                child_email.setValue(email);
                if(email.isEmpty()){
                    tietEmail.setError("Adresa de email trebuie completat");
                    tvTrimiteFeedback.setEnabled(false);
                }else{
                    tietEmail.setError(null);
                    tvTrimiteFeedback.setEnabled(true);
                }

                Firebase child_mesaj=firebase.child("Mesaj");
                child_mesaj.setValue(mesaj);
                if(mesaj.isEmpty()){
                    tietMesaj.setError("Completati mesajul pentru noi");
                    tvTrimiteFeedback.setEnabled(false);
                }else{
                    tietMesaj.setError(null);
                    tvTrimiteFeedback.setEnabled(true);
                }

                Toast.makeText(Feedback.this, "Feedback-ul tau a fost receptionat", Toast.LENGTH_SHORT);
                tvArataFeedback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new AlertDialog.Builder(Feedback.this).
                                setTitle("Mesajul trimis: ").setMessage("Nume: "+ nume + "\n\nEmail: "+email + "\n\nMesaj: " + mesaj)
                                .show();
                    }
                });

            }
        });



    }
}