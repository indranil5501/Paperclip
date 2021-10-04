package com.example.serviceprovider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


@SuppressWarnings("ALL")
public class Edit extends AppCompatActivity{

    EditText snam,ownam,ph2,sadd;
    Button bot;
    ProgressBar prg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        snam=(EditText) findViewById(R.id.shopnam);
        ownam=(EditText) findViewById(R.id.ownnam);
        ph2=(EditText) findViewById(R.id.mobalt);
        sadd=(EditText) findViewById(R.id.addres);
        bot=(Button) findViewById(R.id.smitt);
        prg=(ProgressBar) findViewById(R.id.prgbaredit);

        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((ph2.getText().toString()).length() == 10) {

                    prg.setVisibility(View.VISIBLE);
                    bot.setVisibility(View.INVISIBLE);

                    //code for DB
                }else{
                    Toast.makeText(Edit.this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}