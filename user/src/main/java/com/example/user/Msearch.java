package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Msearch extends AppCompatActivity {
    FloatingActionButton flot;
    EditText searchpin;
    Button gshop,pshop,plumb,carp;
    ProgressBar pg1,pg2,pg3,pg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msearch);

        searchpin=(EditText) findViewById(R.id.spin);
        gshop=(Button) findViewById(R.id.gs);
        pshop=(Button) findViewById(R.id.ps);
        plumb=(Button) findViewById(R.id.plm);
        carp=(Button) findViewById(R.id.car);

        pg1=(ProgressBar) findViewById(R.id.p1);
        pg2=(ProgressBar) findViewById(R.id.p2);
        pg3=(ProgressBar) findViewById(R.id.p3);
        pg4=(ProgressBar) findViewById(R.id.p4);

        gshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gshop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ((searchpin.getText().toString().trim()).length() == 6) {
                            pg1.setVisibility(View.VISIBLE);
                            gshop.setVisibility(View.VISIBLE);

                            Intent intent = new Intent(getApplicationContext(), Demone.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(Msearch.this, "Pincode is not valid", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                pshop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ((searchpin.getText().toString().trim()).length() == 6) {
                            pg2.setVisibility(View.VISIBLE);
                            pshop.setVisibility(View.VISIBLE);

                            Intent intent = new Intent(getApplicationContext(), Demone.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(Msearch.this, "Pincode is not valid", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                plumb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ((searchpin.getText().toString().trim()).length() == 6) {
                            pg3.setVisibility(View.VISIBLE);
                            plumb.setVisibility(View.VISIBLE);

                            Intent intent = new Intent(getApplicationContext(), Demone.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(Msearch.this, "Pincode is not valid", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                carp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ((searchpin.getText().toString().trim()).length() == 6) {
                            pg4.setVisibility(View.VISIBLE);
                            carp.setVisibility(View.VISIBLE);

                            Intent intent = new Intent(getApplicationContext(), Demone.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(Msearch.this, "Pincode is not valid", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



            }
        });


        flot=(FloatingActionButton) findViewById(R.id.floatingActionButton2);

        flot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Dashboard.class);
                startActivity(intent);
            }
        });
    }
}