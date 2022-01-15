package com.example.fitme.Activities.Meditation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitme.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class Meditation extends AppCompatActivity {
    static int totaltime = 600000;
    static int music = R.raw.sunrise;
    public int START_TIME_IN_MILLIS = totaltime;
    MediaPlayer player;
    FloatingActionButton play, stop, settings;
    ProgressBar determinetime;
    int count = 0;
    int i = 0;
    private CountDownTimer countDownTimer;
    private boolean TimerRunning;
    private long TimeLeftInMillis = START_TIME_IN_MILLIS;
    private TextView timer;

    public static void getcustommusic(int musicid) {
        music = musicid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        play = findViewById(R.id.playpause);
        stop = findViewById(R.id.stop);
        settings = findViewById(R.id.settings);
        timer = findViewById(R.id.timer);
        determinetime = findViewById(R.id.determinetime);
        determinetime.setProgress(0);
        determinetime.setProgress(0);
        determinetime.setMax(100);

        Log.d("timer", "onCreate: " + determinetime.getProgress());
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TimerRunning) {
                    pauseTimer();
                } else {
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
                startTimer();
                pauseTimer();
                resettimer();
                Intent intent = new Intent(getApplicationContext(), settingsmeditation.class);
                startActivity(intent);
                finish();
            }
        });
        updateCountDownText();
    }

    private void startTimer() {
        if (player == null) {
            player = MediaPlayer.create(this, music);
        }
        player.start();
        determinetime.setProgress(1);
        countDownTimer = new CountDownTimer(TimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TimeLeftInMillis = millisUntilFinished;
                i++;
                int timeleft = (int) (TimeLeftInMillis);
                determinetime.setProgress(((int) i * 100 / (int) (TimeLeftInMillis / 1000)) / 4);
                updateCountDownText();
            }

            public void onFinish() {
                TimerRunning = false;
                determinetime.setProgress(100);
            }
        }.start();
        TimerRunning = true;
        play.setImageResource(R.drawable.pause);
    }

    private void pauseTimer() {
        if (player != null) {
            player.pause();
        }
        countDownTimer.cancel();
        TimerRunning = false;
        play.setImageResource(R.drawable.play);
        if (count > 0) {
            determinetime.setProgress(0);
        }
    }

    private void updateCountDownText() {
        int minutes = (int) (TimeLeftInMillis / 1000) / 60;
        int seconds = (int) (TimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timer.setText(timeLeftFormatted);
    }

    private void resettimer() {
        if (player != null) {
            player.release();
            player = null;
        }
        pauseTimer();
        TimeLeftInMillis = START_TIME_IN_MILLIS;
        determinetime.setProgress(0);
        TimerRunning = false;
        count++;
        updateCountDownText();
    }
}