package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Lanceur extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 2300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanceur);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentSplash = new Intent(Lanceur.this, MainActivity.class);
                startActivity(intentSplash);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
