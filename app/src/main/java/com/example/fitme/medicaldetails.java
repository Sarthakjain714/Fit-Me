package com.example.fitme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class medicaldetails extends AppCompatActivity {
    public static ArrayList<String> disease= new ArrayList<>();
    public static ArrayList<Integer> diseaseimage = new ArrayList<>();
    public static ArrayList<String> selecteddisease = new ArrayList<>();
    public static ArrayList<Integer> selecteddiseaseimage = new ArrayList<>();
    public static selectedDiseaseAdapter adapter;
    public static diseaseadapter ad;
    RecyclerView medicaldetails;
    RecyclerView selectedmedicaldetails;
    public static TextView selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicaldetails);
        medicaldetails = findViewById(R.id.medicaldetails);
        selectedmedicaldetails = findViewById(R.id.selectedmedicaldetails);
        disease.add("Stroke");
        disease.add("Diabetes");
        disease.add("Cancer");
        disease.add("Heart Problem");
        disease.add("Respiratory problem");
        disease.add("Spinal Injury");
        diseaseimage.add(R.drawable.stroke);
        diseaseimage.add(R.drawable.diabetes);
        diseaseimage.add(R.drawable.blueribbon);
        diseaseimage.add(R.drawable.heart);
        diseaseimage.add(R.drawable.masks);
        diseaseimage.add(R.drawable.spine);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,RecyclerView.HORIZONTAL,false);
        medicaldetails.setLayoutManager(gridLayoutManager);
        ad=new diseaseadapter(disease,diseaseimage);
        medicaldetails.setAdapter(ad);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        selectedmedicaldetails.setLayoutManager(linearLayoutManager);
        adapter = new selectedDiseaseAdapter(selecteddisease,selecteddiseaseimage);
        selectedmedicaldetails.setAdapter(adapter);
        medicaldetails.setHasFixedSize(true);
        selected = findViewById(R.id.selected);
        selected.setText("Selected:("+selecteddiseaseimage.size()+")");
    }
    public static ArrayList getselecteddiseasename(){
        return selecteddisease;
    }
    public static ArrayList getselecteddiseaseimage(){
        return selecteddiseaseimage;
    }
    public static ArrayList getdiseasename(){
        return disease;
    }
    public static ArrayList getdiseaseimage(){
        return diseaseimage;
    }

    public static void updateadapter(){
        Log.i("diseaseitems",selecteddiseaseimage.toString());
        adapter.notifyDataSetChanged();
    }
}