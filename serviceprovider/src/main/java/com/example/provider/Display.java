package com.example.provider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


@SuppressWarnings("ALL")
public class Display extends AppCompatActivity {
    TextView snam,onam,con1,con2,cato,sadd,pin;

     FirebaseFirestore dbroot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        snam=(TextView) findViewById(R.id.shopnam);
        onam=(TextView) findViewById(R.id.ownnam);
        con1=(TextView) findViewById(R.id.mobn);
        con2=(TextView) findViewById(R.id.amobn);
        cato=(TextView)findViewById(R.id.cat);
        sadd=(TextView) findViewById(R.id.address);
        pin=(TextView) findViewById(R.id.pincode);
      FirebaseFirestore  dbroot = FirebaseFirestore.getInstance();
        //String phone = getIntent().getStringExtra("phone");
        String service=getIntent().getStringExtra("servicee");
        String pincode=getIntent().getStringExtra("pin");

        DocumentReference documet =  dbroot.collection("Service provider").document(getIntent().getStringExtra("phone") );
        documet.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                onam.setText(documentSnapshot.getString("name"));
                con1.setText(documentSnapshot.getString("phone"));
                snam.setText(documentSnapshot.getString("shop"));
                cato.setText(documentSnapshot.getString("service"));
                con2.setText(documentSnapshot.getString("alternative"));
                pin.setText(documentSnapshot.getString("pincode"));
                sadd.setText(documentSnapshot.getString("Address"));



            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });







        //code for DB


        BottomNavigationView BottomNavigationView=findViewById(R.id.botnap);

        BottomNavigationView.setSelectedItemId(R.id.edit);

        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.edit:
                        startActivity(new Intent(getApplicationContext(),Edit.class));
                        break;
                    case R.id.comment:
                        startActivity(new Intent(getApplicationContext(),Comment.class));
                        break;
                    case R.id.dash:
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        break;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        break;
                    case R.id.logout:
                        startActivity(new Intent(getApplicationContext(),Login.class));
                        finish();
                        Toast.makeText(Display.this, "Successfully Log Out", Toast.LENGTH_SHORT).show();
                        break;

                }

                return false;
            }
        });



    }
}