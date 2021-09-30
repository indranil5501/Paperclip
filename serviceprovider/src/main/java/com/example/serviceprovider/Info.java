package com.example.serviceprovider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class Info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner cato;
    EditText sname;
    EditText owname;
    EditText phnum;
    EditText add;
    Spinner pin;
    Button subu;
    ProgressBar prg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        sname = (EditText) findViewById(R.id.shopname);
        owname = (EditText) findViewById(R.id.ownname);
        phnum = (EditText) findViewById(R.id.mobnum);
        add = (EditText) findViewById(R.id.address);
        subu = (Button) findViewById(R.id.smit);
        prg = (ProgressBar) findViewById(R.id.prgbarinfo);

        cato = (Spinner) findViewById(R.id.spincat);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cat, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cato.setAdapter(adapter);
        cato.setOnItemSelectedListener(this);

        pin = (Spinner) findViewById(R.id.spinpin);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.pincode, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pin.setAdapter(adapter1);
        pin.setOnItemSelectedListener(this);


        subu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sname.getText().toString().trim().isEmpty() && !owname.getText().toString().trim().isEmpty() && !add.getText().toString().trim().isEmpty()) {
                    if ((phnum.getText().toString().trim()).length() == 10 || (phnum.getText().toString().trim()).length() == 0) {


                        prg.setVisibility(View.VISIBLE);
                        subu.setVisibility(View.INVISIBLE);

                        //code for DB

                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(intent);


                    } else {
                        Toast.makeText(Info.this, "Please enter correct Phone number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Info.this, "Please enter required details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    //................X................
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text=adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



