package com.example.szczka.confitura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Statistic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
