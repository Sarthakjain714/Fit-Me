package com.example.fitme;

import android.os.Bundle;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.harrywhewell.scrolldatepicker.DayScrollDatePicker;
import com.harrywhewell.scrolldatepicker.OnDateSelectedListener;

import java.util.Date;

public class dietplanner extends AppCompatActivity {
DayScrollDatePicker dayScrollDatePicker;
String SelectedDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dietplanner);
dayScrollDatePicker = findViewById(R.id.dayScrollDatePicker);
dayScrollDatePicker.setStartDate(06,10,2021);
dayScrollDatePicker.getSelectedDate(new OnDateSelectedListener() {
    @Override
    public void onDateSelected(@Nullable Date date) {
SelectedDate = date.toString();
        Toast.makeText(dietplanner.this,SelectedDate, Toast.LENGTH_SHORT).show();
    }
});
    }
}
