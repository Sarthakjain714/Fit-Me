package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;


import android.widget.Button;

public class Startpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);


        Button loginbutton, signupbutton;

        loginbutton=findViewById(R.id.loginbutton1);
        signupbutton=findViewById(R.id.signupbutton1);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupActivity();
            }
        });

    }
    public void openLoginActivity()
    {
        Intent intent = new Intent(this,loginactivity.class);
        startActivity(intent);
    }

    public void openSignupActivity()
    {
        Intent intent = new Intent(this,signup.class);
        startActivity(intent);
    }
}