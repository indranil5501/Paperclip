package com.example.user;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

@SuppressWarnings("ALL")
public class Display extends AppCompatActivity {

    TextView nam,con1,con2,add,pinset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        nam=(TextView) findViewById(R.id.namu);
        con1=(TextView) findViewById(R.id.mmobu);
        con2=(TextView) findViewById(R.id.amobu);
        add=(TextView) findViewById(R.id.addressu);
        pinset=(TextView) findViewById(R.id.pincodeu);

        FirebaseFirestore dbroot = FirebaseFirestore.getInstance();
        //code for DB

        DocumentReference documet =  dbroot
                .collection("person").document(getIntent().getStringExtra("phone") );
        documet.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                nam.setText(documentSnapshot.getString("name"));
                con1.setText(documentSnapshot.getString("phone"));
               // snam.setText(documentSnapshot.getString("shop"));
               // cato.setText(documentSnapshot.getString("service"));
                con2.setText(documentSnapshot.getString("alternative no"));
                pinset.setText(documentSnapshot.getString("pincode"));
                add.setText(documentSnapshot.getString("Address"));



            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


    }
}