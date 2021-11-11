package com.example.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
public class Createpassword extends AppCompatActivity {

    EditText newpas;
    EditText confpas;
    Button submi;
    ProgressBar progb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpassword);

        newpas=(EditText) findViewById(R.id.newpass);
        confpas=(EditText) findViewById(R.id.confirmpass);
        submi=(Button) findViewById(R.id.submpass);
        progb=(ProgressBar) findViewById(R.id.prgpass);

        FirebaseFirestore dbroot =  FirebaseFirestore.getInstance();

        submi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!newpas.getText().toString().trim().isEmpty()){
                    if((newpas.getText().toString().trim()).equals((confpas.getText().toString().trim()))){
                        if((newpas.getText().toString().trim()).length()==5) {

                            progb.setVisibility(View.VISIBLE);
                            submi.setVisibility(View.INVISIBLE);

                            //write your code here for fire base


                            Map<String, Object> data = new HashMap<>();
                            data.put("password", newpas.getText().toString());
                            data.put("phone",getIntent().getStringExtra("mobilee"));

                           dbroot.collection("U log in").document(getIntent().getStringExtra("mobilee"))
                                    .set(data)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(Createpassword.this, "data added", Toast.LENGTH_SHORT).show();
                                            Intent i=  new Intent(getApplicationContext(),Info.class);

                                            i.putExtra("mobile",getIntent().getStringExtra("mobilee"));

                                            // i.putExtra("service",co);
                                            startActivity(i);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Createpassword.this, "failed", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                          //  Intent intent = new Intent(getApplicationContext(), Info.class);
                          //  startActivity(intent);
                        }else {
                            Toast.makeText(Createpassword.this, "PASSWORD length is not proper", Toast.LENGTH_SHORT).show();
                        }

                        }else {
                        Toast.makeText(Createpassword.this, "PASSWORD not matched", Toast.LENGTH_SHORT).show();
                    }

                    }else {
                    Toast.makeText(Createpassword.this, "Please enter the Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}