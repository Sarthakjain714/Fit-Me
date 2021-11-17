package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.Math;

public class waterreminder extends AppCompatActivity {
    ProgressBar watertracker;
    TextView waterprogress;
    FloatingActionButton addtoprogress;
    CardView addwater,addcofee,addtea,addsoftdrink,addjuice;
    int selected;
    int color2= Color.parseColor("#ABC9FB");
    int colorwhite = Color.parseColor("#FFFFFF");
    float progress=0;
    int textprogress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterreminder);
        selected=10;
        watertracker=findViewById(R.id.waterlevel);
        watertracker.setMax(100);
        waterprogress=findViewById(R.id.waterprogress);
        addtoprogress=findViewById(R.id.addtotarget);
        addwater=findViewById(R.id.addwater);
        addcofee=findViewById(R.id.addcofee);
        addtea=findViewById(R.id.addtea);
        addsoftdrink=findViewById(R.id.addsoftdrink);
        addjuice=findViewById(R.id.addjuice);

        addtoprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected==0){
                    progress = progress+(200*100/2400);
                    watertracker.setProgress(Math.round(progress));
                    textprogress=textprogress+200;
                    waterprogress.setText(""+textprogress+"OF 2400");
                    addwater.setCardBackgroundColor(colorwhite);
                    selected=10;
                }
                else if(selected==1){
                    progress = progress+(100*100/2400);
                    watertracker.setProgress(Math.round(progress));
                    textprogress=textprogress+100;
                    waterprogress.setText(""+textprogress+"OF 2400");
                    addcofee.setCardBackgroundColor(colorwhite);
                    selected=10;
                }
                else if(selected==2){
                    progress = progress+(150*100/2400);
                    watertracker.setProgress(Math.round(progress));
                    textprogress=textprogress+150;
                    waterprogress.setText(""+textprogress+"OF 2400");
                    addtea.setCardBackgroundColor(colorwhite);
                    selected=10;
                }
                else if(selected==3){
                    progress = progress+(250*100/2400)+1;
                    watertracker.setProgress(Math.round(progress));
                    textprogress=textprogress+250;
                    waterprogress.setText(""+textprogress+"OF 2400");
                    addsoftdrink.setCardBackgroundColor(colorwhite);
                    selected=10;
                }
                else if(selected==4){
                    progress = progress+(200*100/2400);
                    watertracker.setProgress(Math.round(progress));
                    textprogress=textprogress+200;
                    waterprogress.setText(""+textprogress+"OF 2400");
                    addjuice.setCardBackgroundColor(colorwhite);
                    selected=10;
                }
                else if(selected==10){
                    Toast.makeText(waterreminder.this, "Please select an item to add", Toast.LENGTH_SHORT).show();
                }
                Log.d("waterprogress", "onClick: "+progress);
            }
        });
        addwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected=0;
                addwater.setCardBackgroundColor(color2);
                addcofee.setCardBackgroundColor(colorwhite);
                addjuice.setCardBackgroundColor(colorwhite);
                addtea.setCardBackgroundColor(colorwhite);
                addsoftdrink.setCardBackgroundColor(colorwhite);
            }
        });
        addcofee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected=1;
                addwater.setCardBackgroundColor(colorwhite);
                addcofee.setCardBackgroundColor(color2);
                addjuice.setCardBackgroundColor(colorwhite);
                addtea.setCardBackgroundColor(colorwhite);
                addsoftdrink.setCardBackgroundColor(colorwhite);
            }
        });
        addtea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected=2;
                addwater.setCardBackgroundColor(colorwhite);
                addcofee.setCardBackgroundColor(colorwhite);
                addjuice.setCardBackgroundColor(colorwhite);
                addtea.setCardBackgroundColor(color2);
                addsoftdrink.setCardBackgroundColor(colorwhite);
            }
        });
        addsoftdrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected=3;
                addwater.setCardBackgroundColor(colorwhite);
                addcofee.setCardBackgroundColor(colorwhite);
                addjuice.setCardBackgroundColor(colorwhite);
                addtea.setCardBackgroundColor(colorwhite);
                addsoftdrink.setCardBackgroundColor(color2);
            }
        });
        addjuice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected=4;
                addwater.setCardBackgroundColor(colorwhite);
                addcofee.setCardBackgroundColor(colorwhite);
                addjuice.setCardBackgroundColor(color2);
                addtea.setCardBackgroundColor(colorwhite);
                addsoftdrink.setCardBackgroundColor(colorwhite);
            }
        });

    }
}