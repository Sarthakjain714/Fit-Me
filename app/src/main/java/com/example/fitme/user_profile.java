package com.example.fitme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class user_profile extends Fragment {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_user_profile, container, false);
        fAuth = FirebaseAuth.getInstance();
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_user_profile, null);
        EditText email=(EditText) root.findViewById(R.id.emailaddress1);
        EditText username=(EditText) root.findViewById(R.id.username1);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        String emialaddress = fAuth.getCurrentUser().getEmail();
//        String username1=fStore.collection("users").document(email).

        return view;
    }

}