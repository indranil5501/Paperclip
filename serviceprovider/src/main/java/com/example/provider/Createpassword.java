package com.example.provider;

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

    EditText newpass;
    EditText confpass;
    Button sub_npas;
    ProgressBar prgbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpassword);

        newpass=(EditText) findViewById(R.id.new_pass);
        confpass =(EditText) findViewById(R.id.confirm_pass);
        sub_npas=(Button) findViewById(R.id.submit_new_pass);
        prgbar=(ProgressBar) findViewById(R.id.prgbar_createpass);

        FirebaseFirestore dbroot =  FirebaseFirestore.getInstance();

        sub_npas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!newpass.getText (). toString().trim(). isEmpty()){
                    if((newpass.getText().toString().trim()).equals((confpass.getText().toString().trim()))){
                    if((newpass.getText().toString().trim()).length()==5) {

                        prgbar.setVisibility(View.VISIBLE);
                        sub_npas.setVisibility(View.INVISIBLE);

                        Map<String, Object> data = new HashMap<>();
                        data.put("password", newpass.getText().toString());
                        data.put("phone",getIntent().getStringExtra("mobilee"));

                        dbroot.collection("s log in").document(getIntent().getStringExtra("mobilee"))
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
                       // startActivity(intent);
                        //intent.putExtra("mobile",phone);
                    }else {
                        Toast.makeText(Createpassword.this, "PASSWORD length is not proper", Toast.LENGTH_SHORT).show();
                    }

                    }else {
                        Toast.makeText(Createpassword.this, "PASSWORD not matched", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(Createpassword.this, "Please enter the PASSWORD", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}