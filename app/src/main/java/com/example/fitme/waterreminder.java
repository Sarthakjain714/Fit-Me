package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class waterreminder extends AppCompatActivity {
    ProgressBar watertracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterreminder);
        watertracker.setProgress(0);
    }
}