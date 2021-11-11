package com.example.user;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
public class Info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText sname;
    EditText phnum;
    EditText add;
    EditText pin;
    Button subu;
    ProgressBar prg;
    FirebaseFirestore dbroot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        dbroot = FirebaseFirestore.getInstance();

        sname = (EditText) findViewById(R.id.name);
        phnum = (EditText) findViewById(R.id.mobnum);
        add = (EditText) findViewById(R.id.address);
        subu = (Button) findViewById(R.id.smit);
        prg = (ProgressBar) findViewById(R.id.prgbarinfo);
        pin = (EditText) findViewById(R.id.pinn);


        subu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sname.getText().toString().trim().isEmpty() && !add.getText().toString().trim().isEmpty()) {
                    if ((pin.getText().toString().trim()).length() == 6 && ((phnum.getText().toString().trim()).length() == 10 || (phnum.getText().toString().trim()).length() == 0)) {


                        prg.setVisibility(View.VISIBLE);
                        subu.setVisibility(View.INVISIBLE);

                        //code for DB

                        Map<String, Object> data = new HashMap<>();
                        data.put("name", sname.getText().toString());
                       // data.put("service", co);
                        data.put("alternative no", phnum.getText().toString());
                         data.put("phone", getIntent().getStringExtra("mobile"));
                       // data.put("shop", sname.getText().toString());
                        data.put("Address", add.getText().toString());
                        data.put("pincode", pin.getText().toString());


                      //  Intent intent = new Intent(getApplicationContext(), Msearch.class);
                       // startActivity(intent);


                              dbroot  .collection("person").document(getIntent().getStringExtra("mobile"))
                                .set(data)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(Info.this, "data added", Toast.LENGTH_SHORT).show();
                                        Intent i=  new Intent(getApplicationContext(),Thanks.class);
                                        i.putExtra("ph",getIntent().getStringExtra("mobile"));
                                        //i.putExtra("pincode",pin.getText().toString());
                                       // i.putExtra("service",co);
                                        startActivity(i);
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Info.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });


                    } else {
                        Toast.makeText(Info.this, "Please enter correct Phone number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Info.this, "Please enter required details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    //................X................
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text=adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



