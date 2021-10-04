package com.example.serviceprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

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

        sub_npas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!newpass.getText (). toString().trim(). isEmpty()){
                    if((newpass.getText().toString().trim()).equals((confpass.getText().toString().trim()))){
                    if((newpass.getText().toString().trim()).length()==5) {

                        prgbar.setVisibility(View.VISIBLE);
                        sub_npas.setVisibility(View.INVISIBLE);

                        //code for DB


                        Intent intent = new Intent(getApplicationContext(), Info.class);
                        startActivity(intent);
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