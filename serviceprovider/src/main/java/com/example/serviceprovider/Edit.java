package com.example.serviceprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class Edit extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner cat,pinc;
    EditText snam,ownam,ph1,ph2,sadd;
    Button bot;
    ProgressBar prg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        cat=(Spinner) findViewById(R.id.spinca);
        pinc=(Spinner) findViewById(R.id.spinpi);
        snam=(EditText) findViewById(R.id.shopnam);
        ownam=(EditText) findViewById(R.id.ownnam);
        ph1=(EditText) findViewById(R.id.mobmain);
        ph2=(EditText) findViewById(R.id.mobalt);
        sadd=(EditText) findViewById(R.id.addres);
        bot=(Button) findViewById(R.id.smitt);
        prg=(ProgressBar) findViewById(R.id.prgbaredit);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cat, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cat.setAdapter(adapter);
        cat.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.pincode, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pinc.setAdapter(adapter1);
        pinc.setOnItemSelectedListener(this);

        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                prg.setVisibility(View.VISIBLE);
                bot.setVisibility(View.INVISIBLE);

                //code for DB
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}