package com.example.user;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


@SuppressWarnings("ALL")
public class Info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText sname;
    EditText phnum;
    EditText add;
    EditText pin;
    Button subu;
    ProgressBar prg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        sname = (EditText) findViewById(R.id.name);
        phnum = (EditText) findViewById(R.id.mobnum);
        add = (EditText) findViewById(R.id.address);
        subu = (Button) findViewById(R.id.smit);
        prg = (ProgressBar) findViewById(R.id.prgbarinfo);
        pin = (EditText) findViewById(R.id.pinn);


        subu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sname.getText().toString().trim().isEmpty() && !add.getText().toString().trim().isEmpty()) {
                    if ((pin.getText().toString().trim()).length() == 6 && ((phnum.getText().toString().trim()).length() == 10 || (phnum.getText().toString().trim()).length() == 0)) {


                        prg.setVisibility(View.VISIBLE);
                        subu.setVisibility(View.INVISIBLE);

                        //code for DB

                        Intent intent = new Intent(getApplicationContext(), Msearch.class);
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



