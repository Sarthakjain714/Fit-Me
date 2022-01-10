package com.example.fitme;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.List;

public class dashboard_menu extends Fragment {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String username1; 
    String emialaddress;
    View view;
    CardView Yoga,mediation,waterreminder,dietplanner;
    TextView welcomeuser;
    ProgressBar dashboardprogressbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard_menu, container, false);
        dashboardprogressbar=view.findViewById(R.id.dashboardprogressbar);
        Yoga= view.findViewById(R.id.yoga);
        mediation= view.findViewById(R.id.meditation);
        waterreminder=view.findViewById(R.id.waterreminder);
        welcomeuser=view.findViewById(R.id.welcomeuser);
        dietplanner=view.findViewById(R.id.dietplanner);

        Yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Yoga_postures.class);
                startActivity(intent);
            }
        });
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        emialaddress = fAuth.getCurrentUser().getEmail();
        DocumentReference documentReference=fStore.collection("users").document(emialaddress);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        Log.i("LOGGER","First "+document.getString("username"));
                        username1=(String)document.getString("username");

                        welcomeuser.setText("Welcome "+username1);
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
                Intent intent = new Intent(getContext(),Meditation.class);
                startActivity(intent);
            }
        });
        waterreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), waterreminder.class);
                startActivity(intent);
            }
        });
        dietplanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),DietPlanner.class);
                startActivity(intent);
            }
        });
        return view;

    }

}