package com.example.fitme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class Meditation extends AppCompatActivity {
    private  FloatingActionButton play, stop, settings;
    private static final int START_TIME_IN_MILLIS = 600000;
    private CountDownTimer countDownTimer;

    ProgressBar determinetime;
    private boolean TimerRunning;
    private long TimeLeftInMillis = START_TIME_IN_MILLIS;
    private TextView timer;
    FrameLayout settingfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        play= findViewById(R.id.playpause);
        stop= findViewById(R.id.stop);
        settings= findViewById(R.id.settings);
        timer= findViewById(R.id.timer);
        determinetime = findViewById(R.id.determinetime);
        determinetime.setProgress(3);
        determinetime.setMax(100);
        settingfragment = findViewById(R.id.settingfragments);

        Log.d("timer", "onCreate: "+determinetime.getProgress());

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TimerRunning){
                    pauseTimer();
                }
                else{
                    startTimer();
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resettimer();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingfragment.setVisibility(View.VISIBLE);
            }
        });
        updateCountDownText();
    }


    int i=0;
    private void startTimer() {

        countDownTimer = new CountDownTimer(TimeLeftInMillis,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                TimeLeftInMillis =millisUntilFinished;
                i++;
                Log.d("Testting", "onTick: "+millisUntilFinished);
                int timeleft= (int)(TimeLeftInMillis);
                Log.d("timeleft", "onTick: "+timeleft/START_TIME_IN_MILLIS);
                determinetime.setProgress((int)i*100/(int)(millisUntilFinished/1000));
                updateCountDownText();
            }

            public void onFinish() {
                TimerRunning=false;
                determinetime.setProgress(100);
            }
        }.start();
        TimerRunning= true;
        play.setImageResource(R.drawable.pause);
    }
    private void pauseTimer() {
        countDownTimer.cancel();
        TimerRunning = false;
        play.setImageResource(R.drawable.play);
        determinetime.setProgress((int)i*100/(int)(TimeLeftInMillis/1000));
    }

    private void updateCountDownText() {
        int minutes = (int) (TimeLeftInMillis/1000)/60;
        int seconds = (int) (TimeLeftInMillis/1000)%60;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timer.setText(timeLeftFormatted);
    }

    private void resettimer() {
        determinetime.setProgress(0);
        pauseTimer();
        TimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
    }

}