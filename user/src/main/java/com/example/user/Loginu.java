package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


public class Loginu extends AppCompatActivity {

    EditText log;
    EditText pass;
    Button login;
    ProgressBar prg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginu);

        log=(EditText) findViewById(R.id.lognum);
        pass=(EditText) findViewById(R.id.logpassword);
        login=(Button) findViewById(R.id.logbutton);
        prg=(ProgressBar) findViewById(R.id.prgbarlogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!log.getText().toString().trim().isEmpty()&& !pass.getText().toString().trim().isEmpty()){
                    prg.setVisibility(View.VISIBLE);
                    login.setVisibility(View.INVISIBLE);

                    //code for firebase

                    Intent intent=new Intent(getApplicationContext(),Msearch.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Loginu.this, "Please enter required details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}