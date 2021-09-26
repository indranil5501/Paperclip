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

public class Otpverifi extends AppCompatActivity {
    EditText input_otp;
    Button verifi_button;
    ProgressBar prgbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverifi);


        input_otp= findViewById(R.id.write_otp);
        verifi_button=findViewById(R.id.otp_verification);
        prgbar=findViewById(R.id.prgbar_otpsingin);

        //to get the number from singin(up) to otp verification number
        TextView textView=findViewById(R.id.show_num);
        textView.setText(String.format("+91-%s",getIntent().getStringExtra("mobile")));



        verifi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input_otp. getText (). toString().trim(). isEmpty()){
                    if((input_otp.getText().toString().trim()).length()==6){

                        prgbar.setVisibility(View.VISIBLE);
                        verifi_button.setVisibility(View.INVISIBLE);

                        //write here your code for fire base.


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