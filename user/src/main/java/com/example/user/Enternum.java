package com.example.user;

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

@SuppressWarnings("ALL")
public class Enternum extends AppCompatActivity {

    EditText numb;
    Button bot;
    ProgressBar prgb;

    private FirebaseAuth auth;
    // public static String phone;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enternum);

        auth = FirebaseAuth.getInstance();

        numb=(EditText) findViewById(R.id.ipnum);
        bot=(Button) findViewById(R.id.otpb);
        prgb=(ProgressBar) findViewById(R.id.prgbarnum);

        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = numb.getText().toString();
                String phoneNumber = "+91"  + phone;
                if(!numb. getText (). toString().trim(). isEmpty()){
                    if((numb.getText().toString().trim()).length()==10){

                        prgb.setVisibility(View.VISIBLE);
                        bot.setVisibility(View.INVISIBLE);



                        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                                        .setPhoneNumber(phoneNumber)
                                        .setTimeout(60L , TimeUnit.SECONDS)
                                        .setActivity(Enternum.this)
                                        .setCallbacks(mCallBacks)
                                        .build();
                                PhoneAuthProvider.verifyPhoneNumber(options);


                                //code for DB

                        //Intent intent=new Intent(getApplicationContext(),Otpverifi.class);
                       // intent.putExtra("mob",numb.getText().toString());
                      //  startActivity(intent);


                    }else{
                        Toast.makeText(Enternum.this, "Please enter connect number", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Enternum.this, "Enter the number", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Enternum.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);

                //sometime the code is not detected automatically
                //so user has to manually enter the code
                Toast.makeText(Enternum.this, "otp sent", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        {
                            Intent otpIntent = new Intent(Enternum.this, Otpverifi.class);
                            otpIntent.putExtra("auth", s);
                            otpIntent.putExtra("mobile",numb.getText().toString());
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
                    Toast.makeText(Enternum.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}