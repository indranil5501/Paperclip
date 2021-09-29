package com.example.serviceprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText input_number;
    EditText input_password;
    Button login;
    ProgressBar prgbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_number=(EditText) findViewById(R.id.login_num);
        input_password=(EditText) findViewById(R.id.login_password);
        login=(Button) findViewById(R.id.login_button);
        prgbar=(ProgressBar) findViewById(R.id.prgbar_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input_number. getText (). toString().trim(). isEmpty()&&!input_password. getText (). toString().trim(). isEmpty()){

                    prgbar.setVisibility(View.VISIBLE);
                    login.setVisibility(View.INVISIBLE);

                    //write your code here for fire base

                    Intent intent=new Intent(getApplicationContext(),Dashboard.class);
                    startActivity(intent);

                    }else {
                        Toast.makeText(Login.this, "Please enter the PASSWORD", Toast.LENGTH_SHORT).show();
                    }

            }
        });




    }
}