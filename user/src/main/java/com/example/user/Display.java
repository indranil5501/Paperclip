package com.example.user;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Display extends AppCompatActivity {

    TextView nam,con1,con2,add,pinset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        nam=(TextView) findViewById(R.id.namu);
        con1=(TextView) findViewById(R.id.mmobu);
        con2=(TextView) findViewById(R.id.amobu);
        add=(TextView) findViewById(R.id.addressu);
        pinset=(TextView) findViewById(R.id.pincodeu);


        //code for DB


    }
}