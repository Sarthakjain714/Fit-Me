package com.example.fitme;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class all_postures extends Fragment {

    View view ;
    CardView vajraasana,shavasana,gomukhasana,vrikshaasana,paschimottaasana,pranayama,charkasana,hastuttanasana,vibhadrasana,tadasana,bhujangasana,trikonsana;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_all_postures, container, false);
        trikonsana=(CardView) view.findViewById(R.id.trikonasanacardview);
        bhujangasana= (CardView) view.findViewById(R.id.bhujangasanacardview);
        tadasana= (CardView) view.findViewById(R.id.tadasanacardview);
        vibhadrasana =(CardView) view.findViewById(R.id.virabhadraasanacardview);
        charkasana =(CardView) view.findViewById(R.id.hastuttanasanacardview);
        hastuttanasana=(CardView) view.findViewById(R.id.chakraasanacardview);
        pranayama =(CardView) view.findViewById(R.id.pranayamcardview);
        paschimottaasana= (CardView) view.findViewById(R.id.paschimottanasanacardview);
        vrikshaasana=(CardView) view.findViewById(R.id.vrikshaasanacardview);
        vajraasana=(CardView) view.findViewById(R.id.vajrasanacardview);
        shavasana=(CardView) view.findViewById(R.id.shavasanacardview);
        gomukhasana =(CardView) view.findViewById(R.id.gomukhasanacardview);
        vajraasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),vajraasana.class);
                startActivity(intent);
            }
        });
        shavasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),shavasana.class);
                startActivity(intent);
            }
        });
        gomukhasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),gomukhasana.class);
                startActivity(intent);
            }
        });
        vrikshaasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),vrikshaasana.class);
                startActivity(intent);
            }
        });
        paschimottaasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),paschimottanasana.class);
                startActivity(intent);
            }
        });
        pranayama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Pranayaam.class);
                startActivity(intent);
            }
        });
        hastuttanasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),chakraasana.class);
                startActivity(intent);
            }
        });
        charkasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), hastuttanasana.class);
                startActivity(intent);
            }
        });
        vibhadrasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), virabhadraasana.class);
                startActivity(intent);
            }
        });
        tadasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), tadasana.class);
                startActivity(intent);
            }
        });
        bhujangasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), bhujangasana.class);
                startActivity(intent);
            }
        });
        trikonsana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), trikonasana.class);
                startActivity(intent);
            }
        });
        return view;
    }
}