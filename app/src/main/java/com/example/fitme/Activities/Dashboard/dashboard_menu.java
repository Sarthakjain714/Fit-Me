package com.example.fitme.Activities.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.fitme.Activities.AllPosture.Yoga_postures;
import com.example.fitme.Activities.Bmi.DietPlanner;
import com.example.fitme.Activities.Meditation.Meditation;
import com.example.fitme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class dashboard_menu extends Fragment {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String username1;
    String emialaddress;
    View view;
    TextView datetext;
    CardView Yoga, mediation;

    //username variables


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        datetext=view.findViewById(R.id.datetext);
        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        CardView Yoga, mediation, waterreminder, dietplanner;
        TextView welcomeuser;
        ProgressBar dashboardprogressbar;

        view = inflater.inflate(R.layout.fragment_dashboard_menu, container, false);
        datetext = view.findViewById(R.id.datetext);
        dashboardprogressbar = view.findViewById(R.id.dashboardprogressbar);
        Yoga = view.findViewById(R.id.yoga);
        mediation = view.findViewById(R.id.meditation);


        //Date and Time Display
        Log.d("myLOG", currentTime.toString());
        datetext.setText(formattedDate);


        waterreminder = view.findViewById(R.id.waterreminder);
        welcomeuser = view.findViewById(R.id.welcomeuser);
        dietplanner = view.findViewById(R.id.dietplanner);


        Yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Yoga_postures.class);
                startActivity(intent);
            }
        });
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        emialaddress = fAuth.getCurrentUser().getEmail();
        DocumentReference documentReference = fStore.collection("users").document(emialaddress);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        Log.i("LOGGER", "First " + document.getString("username"));
                        username1 = (String) document.getString("username");

                        welcomeuser.setText("Welcome " + username1);
                        dashboardprogressbar.setVisibility(View.GONE);

                    } else {
                        Log.d("LOGGER", "No such document");
                    }
                } else {
                    Log.d("LOGGER", "get failed with ", task.getException());
                }
            }
        });

        mediation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Meditation.class);
                startActivity(intent);
            }
        });
        waterreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitme.Activities.Water.waterreminder.class);
                startActivity(intent);
            }
        });
        dietplanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DietPlanner.class);
                startActivity(intent);
            }
        });
        return view;

    }

}