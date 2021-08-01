package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button loginbutton1,signupbutton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);
        loginbutton1 = findViewById(R.id.loginbutton1);
        signupbutton1=findViewById(R.id.signupbutton1);


//login and sign up page
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


//login and sign up page
// Medical details form


//Medical Details form
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
    //login and sign up page


}