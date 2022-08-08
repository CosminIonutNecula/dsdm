package com.example.ecibcoin.Utilizator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecibcoin.R;

import java.util.ArrayList;
import java.util.Objects;

public class DisplayEvenimente extends AppCompatActivity {
    private ArrayList<EventModalClass> eventModalArrayList;
    private DbHelper dbHelper;
    private EventRVAdapter eventRVAdapter;
    private RecyclerView eventsRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_evenimente);
        eventModalArrayList = new ArrayList<>();
        dbHelper = new DbHelper(DisplayEvenimente.this);
        Objects.requireNonNull(getSupportActionBar()).hide();


        eventModalArrayList = dbHelper.readCourses();


        eventRVAdapter = new EventRVAdapter(eventModalArrayList, DisplayEvenimente.this);
        eventsRV = findViewById(R.id.idRVCourses);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DisplayEvenimente.this, RecyclerView.VERTICAL, false);
        eventsRV.setLayoutManager(linearLayoutManager);


        eventsRV.setAdapter(eventRVAdapter);
    }
}