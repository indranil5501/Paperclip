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
public class Enternum extends AppCompatActivity {

    EditText numb;
    Button bot;
    ProgressBar prgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enternum);

        numb=(EditText) findViewById(R.id.ipnum);
        bot=(Button) findViewById(R.id.otpb);
        prgb=(ProgressBar) findViewById(R.id.prgbarnum);

        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!numb. getText (). toString().trim(). isEmpty()){
                    if((numb.getText().toString().trim()).length()==10){

                        prgb.setVisibility(View.VISIBLE);
                        bot.setVisibility(View.INVISIBLE);

                        //code for DB

                        Intent intent=new Intent(getApplicationContext(),Otpverifi.class);
                        intent.putExtra("mob",numb.getText().toString());
                        startActivity(intent);


                    }else{
                        Toast.makeText(Enternum.this, "Please enter connect number", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Enternum.this, "Enter the number", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}