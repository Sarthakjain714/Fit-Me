package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup extends AppCompatActivity {
    Button signupbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupbutton2=findViewById(R.id.signupbutton2);

        signupbutton2.setOnClickListener(new View.OnClickListener() {
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