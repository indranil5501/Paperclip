package com.example.user;

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
    EditText otp;
    Button verifi;
    TextView num;
    ProgressBar prgbar;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverifi);

        otp=(EditText) findViewById(R.id.otpwrt);
        verifi=(Button) findViewById(R.id.otpverifi);
        num=(TextView) findViewById(R.id.shownumb);
        prgbar=(ProgressBar) findViewById(R.id.prgbarotp);

        firebaseAuth = FirebaseAuth.getInstance();
        String OTP = getIntent().getStringExtra("auth");

        num.setText(String.format("+91-%s",getIntent().getStringExtra("mob")));

        verifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String verification_code = otp.getText().toString();
                if(!otp.getText().toString().trim().isEmpty()){
                    if((otp.getText().toString().trim()).length()==6){

                        prgbar.setVisibility(View.VISIBLE);
                        verifi.setVisibility(View.INVISIBLE);

                        //code for DB

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(OTP, verification_code);
                        signIn(credential);

                       // Intent intent=new Intent(getApplicationContext(),Createpassword.class);
                       // startActivity(intent);
                    }else{
                        Toast.makeText(Otpverifi.this, "NOT MATCHED", Toast.LENGTH_SHORT).show();
                    }
                }else {
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
                   // intent.putExtra("mobilee",getIntent().getStringExtra("mobile"));
                    startActivity(intent);
                } else {

                    Toast.makeText(Otpverifi.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}