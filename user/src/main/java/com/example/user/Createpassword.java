package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

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

        submi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!newpas.getText().toString().trim().isEmpty()){
                    if((newpas.getText().toString().trim()).equals((confpas.getText().toString().trim()))){

                        progb.setVisibility(View.VISIBLE);
                        submi.setVisibility(View.INVISIBLE);

                        //write your code here for fire base

                        Intent intent=new Intent(getApplicationContext(),Info.class);
                        startActivity(intent);

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