package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


@SuppressWarnings("ALL")
public class Edit extends AppCompatActivity {
    EditText nam,mod2,add,defpin;
    Button bottt;
    ProgressBar prg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        nam=(EditText) findViewById(R.id.uname);
        mod2=(EditText) findViewById(R.id.mobualt);
        add=(EditText) findViewById(R.id.addu);
       defpin=(EditText) findViewById(R.id.defpin);
       bottt=(Button) findViewById(R.id.smittu);
       prg=(ProgressBar) findViewById(R.id.prgbareditu);


       bottt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if((defpin.getText().toString().trim()).length() == 6||(defpin.getText().toString().trim()).length() == 0) {
                   if((mod2.getText().toString().trim()).length() == 10||(mod2.getText().toString().trim()).length() == 0) {


                       prg.setVisibility(View.VISIBLE);
                       bottt.setVisibility(View.INVISIBLE);

                       //code for DB


                       Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                       startActivity(intent);
                   }else {
                       Toast.makeText(Edit.this, "Please enter valid number", Toast.LENGTH_SHORT).show();
                   }

               }else {
                   Toast.makeText(Edit.this, "Please enter valid Pin code", Toast.LENGTH_SHORT).show();
               }

           }
       });




    }
}