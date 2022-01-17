package com.example.fitme.Activities.LoginAndStarting;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fitme.Activities.Disease.medicaldetails;
import com.example.fitme.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class genderselection extends AppCompatActivity {
    public static String gender;
    int selected=0;
    String email;
    FirebaseAuth fAtuh;
    FirebaseFirestore fStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genderselection);
        Button genderselected;
        CardView femaleCardView;
        fAtuh=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        email=fAtuh.getCurrentUser().getEmail();
        CardView maleCardview;
        int color1 = Color.parseColor("#0E1C36");
        int color2 = Color.parseColor("#C5D5EA");
        femaleCardView = findViewById(R.id.femalecardView);
        maleCardview = findViewById(R.id.malecardView);
        genderselected=findViewById(R.id.genderselected);
        femaleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femaleCardView.setCardBackgroundColor(color1);
                maleCardview.setCardBackgroundColor(color2);
                gender="Female";
                selected=1;
            }
        });
        maleCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleCardview.setCardBackgroundColor(color1);
                femaleCardView.setCardBackgroundColor(color2);
                gender="Male";
                selected=2;
            }
        });

        genderselected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected==0){
                    Toast.makeText(genderselection.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                }
                else{
                    DocumentReference documentReference = fStore.collection("users").document(email);
                    documentReference.update("gender", gender);
                    Intent intent = new Intent(getApplicationContext(), medicaldetails.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    public static String getgender(){
        return gender;
    }
}
