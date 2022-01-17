package com.example.fitme.Activities.Meditation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitme.R;
import com.google.android.material.circularreveal.cardview.CircularRevealCardView;

import de.hdodenhof.circleimageview.CircleImageView;

public class settingsmeditation extends AppCompatActivity {
    NumberPicker numberPickerminutes;
    NumberPicker numberPickerseconds;
    LinearLayout timeoptions;
    LinearLayout linearbuttons;
    RelativeLayout sounds;
    CircularRevealCardView tenmins, fivteenmins, twentymins;
    ImageView sound1sunrise, sound2, sound3;
    CircleImageView savedmeditationchanges, meditationsoundoptions, times;
    int totalmilliseconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingsmeditation);
        linearbuttons = findViewById(R.id.options);
        numberPickerminutes = findViewById(R.id.numpicker_minutes);
        numberPickerseconds = findViewById(R.id.numpicker_seconds);
        savedmeditationchanges = findViewById(R.id.savemeditionchange);
        sounds = findViewById(R.id.meditationsounds);
        times = findViewById(R.id.settimes);
        tenmins = findViewById(R.id.tenmins);
        fivteenmins = findViewById(R.id.fivteenmins);
        twentymins = findViewById(R.id.twentymins);
        sound1sunrise = findViewById(R.id.defualtsound1image);
        sound2 = findViewById(R.id.defualtsound2image);
        sound3 = findViewById(R.id.defualtsound3image);
        meditationsoundoptions = findViewById(R.id.musicoptions);
        timeoptions = findViewById(R.id.timeoptions);
        numberPickerseconds.setMaxValue(60);
        numberPickerseconds.setMinValue(1);
        numberPickerminutes.setMinValue(0);
        numberPickerminutes.setMaxValue(60);
        savedmeditationchanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("number picker", "onCreate: " + numberPickerseconds.getValue() + "  " + numberPickerminutes.getValue());
                totalmilliseconds = ((numberPickerseconds.getValue() * 60 + numberPickerminutes.getValue()) * 1000);
                Meditation.totaltime = totalmilliseconds;
                Intent intent = new Intent(getApplicationContext(), Meditation.class);
                startActivity(intent);
                finish();
            }
        });

        meditationsoundoptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sounds.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) linearbuttons.getLayoutParams();
                lp.setMargins(0, 160, 0, 0);
                linearbuttons.setLayoutParams(lp);
            }
        });
        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeoptions.setVisibility(View.VISIBLE);
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) linearbuttons.getLayoutParams();
                lp.setMargins(0, 120, 0, 0);
                linearbuttons.setLayoutParams(lp);
            }
        });
        int timertime = 0;
        tenmins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meditation.totaltime = 600000;
                timeoptions.setVisibility(View.GONE);
            }
        });
        fivteenmins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meditation.totaltime = 900000;

                timeoptions.setVisibility(View.GONE);
            }
        });
        twentymins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meditation.totaltime = 1200000;
                timeoptions.setVisibility(View.GONE);
            }
        });
        sound1sunrise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meditation.getcustommusic(R.raw.sunrise);
                sounds.setVisibility(View.GONE);
            }
        });
        sound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meditation.getcustommusic(R.raw.classic);
                sounds.setVisibility(View.GONE);
            }
        });
        sound3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meditation.getcustommusic(R.raw.waterfall);
                sounds.setVisibility(View.GONE);
            }
        });
    }
}