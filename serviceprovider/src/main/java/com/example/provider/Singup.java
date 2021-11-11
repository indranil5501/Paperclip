package com.example.provider;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
public class Singup extends AppCompatActivity {
    EditText enter_num;
    Button otp_bot;
    ProgressBar prgbar;
    private FirebaseAuth auth;
   // public static String phone;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        auth = FirebaseAuth.getInstance();


        enter_num =(EditText) findViewById(R.id.input_num);
        otp_bot =(Button) findViewById (R.id.otp_bot);
        prgbar=(ProgressBar) findViewById(R.id.prgbar_singin);



        otp_bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = enter_num.getText().toString();
                String phoneNumber = "+91"  + phone;
                if(!enter_num. getText (). toString().trim(). isEmpty()){
                    if((enter_num.getText().toString().trim()).length()==10){

                        prgbar.setVisibility(View.VISIBLE);
                        otp_bot.setVisibility(View.INVISIBLE);



                        //code for DB
                        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                                .setPhoneNumber(phoneNumber)
                                .setTimeout(60L , TimeUnit.SECONDS)
                                .setActivity(Singup.this)
                                .setCallbacks(mCallBacks)
                                .build();
                        PhoneAuthProvider.verifyPhoneNumber(options);



                     // Intent intent=new Intent(getApplicationContext(),Otpverifi.class);
                      //intent.putExtra("mobile",enter_num.getText().toString());
                      //startActivity(intent);

                    }else {
                        Toast.makeText(Singup.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(Singup.this, "Enter the number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCallBacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signIn(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(Singup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                //sometime the code is not detected automatically
                //so user has to manually enter the code
                Toast.makeText(Singup.this, "otp sent", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        {
                            Intent otpIntent = new Intent(Singup.this, Otpverifi.class);
                            otpIntent.putExtra("auth", s);
                            otpIntent.putExtra("mobile",enter_num.getText().toString());
                            startActivity(otpIntent);
                        }
                    }
                }, 10000);

            }
        };
    }




    private void signIn(PhoneAuthCredential credential){
        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                }else{
                    Toast.makeText(Singup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}