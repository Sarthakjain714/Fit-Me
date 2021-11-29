package com.example.fitme;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class dashboard_menu extends Fragment {
    View view;
    CardView Yoga,mediation,dietplanner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard_menu, container, false);
        Yoga= view.findViewById(R.id.yoga);
        mediation= view.findViewById(R.id.meditation);
        dietplanner= view.findViewById(R.id.dietplanner);
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
        dietplanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),DietPlanner.class);
                startActivity(intent);
            }
        });

        return view;

    }

}