package com.example.fitme;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class genderselection extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genderselection);

        CardView femaleCardView;
        CardView maleCardview;
        int color1 = Color.parseColor("0E1C36");
        int color2 = Color.parseColor("C5D5EA");
        femaleCardView= findViewById(R.id.femalecardView);
        maleCardview = findViewById(R.id.malecardView);

        femaleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femaleCardView.setCardBackgroundColor(color1);
                maleCardview.setCardBackgroundColor(color2);
            }
        });
        maleCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleCardview.setCardBackgroundColor(color1);
                femaleCardView.setCardBackgroundColor(color2);
            }
        });

    }

}
