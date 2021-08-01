package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginactivity extends AppCompatActivity {
    Button loginbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        loginbutton2= findViewById(R.id.loginbutton2);
        loginbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedicalDetailsForm();
            }
        });
    }
    public void openMedicalDetailsForm(){
        Intent intent = new Intent(this,medicaldetails.class);
        startActivity(intent);
    }
}