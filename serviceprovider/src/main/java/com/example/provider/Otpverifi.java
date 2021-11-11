package com.example.provider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

@SuppressWarnings("ALL")
public class Otpverifi extends AppCompatActivity {
    EditText input_otp;
    Button verifi_button;
    ProgressBar prgbar;
    private String otp;
    // private FirebaseAuth mAuth;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverifi);


        input_otp = (EditText) findViewById(R.id.write_otp);
        verifi_button = (Button) findViewById(R.id.otp_verification);
        prgbar = (ProgressBar) findViewById(R.id.prgbar_otpsingin);


        TextView tew = findViewById(R.id.show_num);
        tew.setText(String.format("+91-%s", getIntent().getStringExtra("mobile")));

        firebaseAuth = FirebaseAuth.getInstance();

        String OTP = getIntent().getStringExtra("auth");
    // String  phone= getIntent().getStringExtra("mobile")


        verifi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verification_code = input_otp.getText().toString();
                if (!input_otp.getText().toString().trim().isEmpty()) {
                    if ((input_otp.getText().toString().trim()).length() == 6) {

                        prgbar.setVisibility(View.VISIBLE);
                        verifi_button.setVisibility(View.INVISIBLE);

                        //code for DB
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(OTP, verification_code);
                        signIn(credential);


                        //Intent intent=new Intent(getApplicationContext(), Createpassword.class);
                       // startActivity(intent);

                    } else {
                        Toast.makeText(Otpverifi.this, "NOT MATCHING CHECK AGAIN", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Otpverifi.this, "PLEASE ENTER OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void signIn(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //sendToMain();
                    //Toast.makeText(Otpverifi.this, "log in", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(), Createpassword.class);
                    intent.putExtra("mobilee",getIntent().getStringExtra("mobile"));
                    startActivity(intent);
                } else {

                   // Toast.makeText(Otpverifi.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(getApplicationContext(), Createpassword.class);
                   intent.putExtra("mobilee",getIntent().getStringExtra("mobile"));
                   startActivity(intent);
                }
            }

        });



    }


}
