package com.example.provider;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
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
    Spinner cato;
    EditText sname;
    EditText owname;
    EditText phnum;
    EditText add;
    Spinner pin;
    Button subu;
    ProgressBar prg;
    String pi,co;
    String sel="---Select---";
    FirebaseFirestore dbroot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        sname = (EditText) findViewById(R.id.shopname);
        owname = (EditText) findViewById(R.id.ownname);
        phnum = (EditText) findViewById(R.id.mobnum);
        add = (EditText) findViewById(R.id.address);
        subu = (Button) findViewById(R.id.smit);
        prg = (ProgressBar) findViewById(R.id.prgbarinfo);

        cato = (Spinner) findViewById(R.id.spincat);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cat, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cato.setAdapter(adapter);
        cato.setOnItemSelectedListener(this);

        pin = (Spinner) findViewById(R.id.spinpin);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.pincode, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pin.setAdapter(adapter1);
        pin.setOnItemSelectedListener(this);
        dbroot = FirebaseFirestore.getInstance();

    // String phone=  getIntent().getStringExtra("mobile");


        subu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sname.getText().toString().trim().isEmpty() && !owname.getText().toString().trim().isEmpty() && !add.getText().toString().trim().isEmpty()) {
                    if ((phnum.getText().toString().trim()).length() == 10 || (phnum.getText().toString().trim()).length() == 0) {
                        check(pi,co);

                        //---------------------------------------------------------------

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
        pi=pin.getSelectedItem().toString();
        co=cato.getSelectedItem().toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void check(String p,String c){
        if(c.equals(sel)){
            Toast.makeText(Info.this, "please select Catagoey", Toast.LENGTH_SHORT).show();
        }else if(p.equals(sel)){
            Toast.makeText(Info.this, "please select Pincode", Toast.LENGTH_SHORT).show();
        }else{

            prg.setVisibility(View.VISIBLE);
            subu.setVisibility(View.INVISIBLE);

           // String phone=  getIntent().getStringExtra("mobile");
           // Bundle b2= getIntent().getExtras();
          //  String phone = b2.getString(("mobile"));

            Map<String, Object> data = new HashMap<>();
            data.put("name", owname.getText().toString());
            data.put("service", co);
            data.put("alternative", phnum.getText().toString());
            data.put("phone", getIntent().getStringExtra("mobile"));
            data.put("shop", sname.getText().toString());
            data.put("Address", add.getText().toString());
            data.put("pincode", pi);

            //Intent intent = new Intent(getApplicationContext(), Dashboard.class);
           // startActivity(intent);

            dbroot.collection("Service provider").document(getIntent().getStringExtra("mobile"))
                    .set(data)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Info.this, "data added", Toast.LENGTH_SHORT).show();
                            Intent i=  new Intent(getApplicationContext(),Dashboard.class);
                            i.putExtra("ph",getIntent().getStringExtra("mobile"));
                            i.putExtra("pincode",pi);
                            i.putExtra("service",co);
                            startActivity(i);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Info.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}



