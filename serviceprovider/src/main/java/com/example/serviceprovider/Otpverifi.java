package com.example.serviceprovider;

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
    EditText input_otp;
    Button verifi_button;
    ProgressBar prgbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverifi);


        input_otp=(EditText) findViewById(R.id.write_otp);
        verifi_button=(Button) findViewById(R.id.otp_verification);
        prgbar=(ProgressBar) findViewById(R.id.prgbar_otpsingin);


        TextView tew=findViewById(R.id.show_num);
        tew.setText(String.format("+91-%s",getIntent().getStringExtra("mobile")));



        verifi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input_otp. getText (). toString().trim(). isEmpty()){
                    if((input_otp.getText().toString().trim()).length()==6){

                        prgbar.setVisibility(View.VISIBLE);
                        verifi_button.setVisibility(View.INVISIBLE);

                        //code for DB


                       Intent intent=new Intent(getApplicationContext(), Createpassword.class);
                       startActivity(intent);

                    }else {
                        Toast.makeText(Otpverifi.this, "NOT MATCHING CHECK AGAIN", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(Otpverifi.this, "PLEASE ENTER OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}