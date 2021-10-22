package com.example.fitme;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.sql.Array;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class user_profile extends Fragment implements View.OnClickListener{
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    View view;
    CircleImageView editmedicaldetails;
    String emialaddress;
    String username1;
    EditText username;
    TextView emialaddresstextview,usernametextview,medicaldetailsinfo;
    Button editdetails,savedetails;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_user_profile, container, false);
        fAuth = FirebaseAuth.getInstance();
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_user_profile, null);
        username=(EditText) view.findViewById(R.id.username1);
        emialaddresstextview= (TextView)view.findViewById(R.id.emailaddresstextview);
        usernametextview=(TextView)view.findViewById(R.id.usernametextview);
        username.setVisibility(View.GONE);
        editdetails=(Button) view.findViewById(R.id.editdetials);
        savedetails=(Button) view.findViewById(R.id.Save);
        editmedicaldetails = view.findViewById(R.id.editmedicaldetails);
        medicaldetailsinfo= view.findViewById(R.id.medicaldetialsinfo);
        medicaldetailsinfo.setText("");



        editdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usernametextview.setVisibility(View.GONE);
                username.setVisibility(View.VISIBLE);
                editdetails.setVisibility(View.GONE);
                savedetails.setVisibility(View.VISIBLE);
                savedetails.setText("Save");
                username.setText(usernametextview.getText().toString());
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
                        Log.i("LOGGER","string "+ username1);
                        usernametextview.setText(username1);
                        List<String> group = (List<String>) document.get("medicaldetails");
                        int arraylength=group.size();
                        for(int i=0;i<arraylength;i++){
                            String text= (String) medicaldetailsinfo.getText();
                            medicaldetailsinfo.setText(text+" "+(String) group.get(i)+", ");
                        }

                    } else {
                        Log.d("LOGGER", "No such document");
                    }
                } else {
                    Log.d("LOGGER", "get failed with ", task.getException());
                }
            }
        });
        emialaddresstextview.setText(emialaddress);
        savedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamedetails=username.getText().toString();
                DocumentReference docref=fStore.collection("users").document(emialaddress);
                docref.update("username",usernamedetails);
                savedetails.setVisibility(View.GONE);
                editdetails.setVisibility(View.VISIBLE);
                usernametextview.setText(username.getText().toString());
                username.setVisibility(View.GONE);
                emialaddresstextview.setVisibility(View.VISIBLE);
                usernametextview.setVisibility(View.VISIBLE);
            }
        });

        editmedicaldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),medicaldetails.class);
                startActivity(intent);
//                Toast.makeText(getContext(), "Edited successfully", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}