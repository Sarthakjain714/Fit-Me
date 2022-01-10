package com.example.fitme;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class dashboard_menu extends Fragment {
    View view;
    CardView Yoga,mediation;

    //username variables
    


    TextView datetext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        datetext=view.findViewById(R.id.datetext);
        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);


        view = inflater.inflate(R.layout.fragment_dashboard_menu, container, false);
        Yoga= view.findViewById(R.id.yoga);
        mediation= view.findViewById(R.id.meditation);

        //Date and Time Display
        Log.d("myLOG",currentTime.toString());
        datetext.setText(formattedDate);


        Yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Yoga_postures.class);
                startActivity(intent);
            }
        });
        mediation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Meditation.class);
                startActivity(intent);
            }
        });

        return view;

    }

}