package com.example.provider;

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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("ALL")
public class Edit extends AppCompatActivity{

    EditText snam,ownam,ph2,sadd;
    Button bot;
    ProgressBar prg;
   FirebaseFirestore dbroot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        snam=(EditText) findViewById(R.id.shopnam);
        ownam=(EditText) findViewById(R.id.ownnam);
        ph2=(EditText) findViewById(R.id.mobalt);
        sadd=(EditText) findViewById(R.id.addres);
        bot=(Button) findViewById(R.id.smitt);
        prg=(ProgressBar) findViewById(R.id.prgbaredit);
        dbroot = FirebaseFirestore.getInstance();
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((ph2.getText().toString()).length() == 10) {

                    prg.setVisibility(View.VISIBLE);
                    bot.setVisibility(View.INVISIBLE);

                   DocumentReference doc=dbroot.collection("Service provider").document(getIntent().getStringExtra("phonee")  );
                    Map<String, Object> data = new HashMap<>();
                    data.put("name", ownam.getText().toString());
                    // data.put("service", tv.getText().toString());
                    data.put("alternative",ph2 .getText().toString());
                    // data.put("phone", t3.getText().toString());
                    data.put("shop", snam.getText().toString());
                    data.put("Address", sadd.getText().toString());
                    // data.put("pincode", t6.getText().toString());

                    doc.update(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Edit.this, "updated successfully", Toast.LENGTH_SHORT).show();
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Edit.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });


                } else {
                    Toast.makeText(Edit.this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}