package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiCalculator extends AppCompatActivity {
EditText weight,feet,inches;
Button cal;
int wgt,ft,in;
double bm;
  TextView bmi;
          @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
      weight=findViewById(R.id.weight);
      feet=findViewById(R.id.feet);
      inches=findViewById(R.id.inches);
      bmi=findViewById(R.id.bmi);


      cal=findViewById(R.id.cal);
      wgt=Integer.parseInt(weight.getText().toString());
      ft=Integer.parseInt(feet.getText().toString());
      in=Integer.parseInt(inches.getText().toString());
      cal.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              bm=wgt/Math.pow((ft*0.3048)+(in*0.0254),2);
              bmi.setText((int) bm);
          }
      });
    }
}