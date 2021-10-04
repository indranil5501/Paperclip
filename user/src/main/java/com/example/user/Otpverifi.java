package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


@SuppressWarnings("ALL")
public class Otpverifi extends AppCompatActivity {
    EditText otp;
    Button verifi;
    TextView num;
    ProgressBar prgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverifi);

        otp=(EditText) findViewById(R.id.otpwrt);
        verifi=(Button) findViewById(R.id.otpverifi);
        num=(TextView) findViewById(R.id.shownumb);
        prgbar=(ProgressBar) findViewById(R.id.prgbarotp);

        num.setText(String.format("+91-%s",getIntent().getStringExtra("mob")));

        verifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!otp.getText().toString().trim().isEmpty()){
                    if((otp.getText().toString().trim()).length()==6){

                        prgbar.setVisibility(View.VISIBLE);
                        verifi.setVisibility(View.INVISIBLE);

                        //code for DB

                        Intent intent=new Intent(getApplicationContext(),Createpassword.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Otpverifi.this, "NOT MATCHED", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Otpverifi.this, "PLEASE ENTER OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}