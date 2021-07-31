package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button loginbutton1,loginbutton2,signupbutton1,signupbutton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);
loginbutton1 = findViewById(R.id.loginbutton1);
loginbutton2= findViewById(R.id.loginbutton2);
signupbutton1=findViewById(R.id.signupbutton1);
signupbutton2=findViewById(R.id.signupbutton2);


//login and signup
loginbutton1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openLoginActivity();
    }
});
signupbutton1.setOnClickListener(new View.OnClickListener() {
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

    //login and signup
}