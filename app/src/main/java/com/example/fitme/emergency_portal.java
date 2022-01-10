package com.example.fitme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class emergency_portal extends Fragment {
    View view;
    Button startcalculate ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_emergency_portal, container, false);
        startcalculate = view.findViewById(R.id.startmeasurement);
        startcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_DENIED){
                    Toast.makeText(getContext(),"You have denied a necessary permission", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(getContext(),Oxygenprocess.class);
                startActivity(intent);
            }
        });
        return view;
    }
}