package com.example.serviceprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

public class Info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner cato;
    EditText sname;
    EditText owname;
    EditText phnum;
    EditText add;
    EditText pin;
    Button subu;
    ProgressBar prg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        sname=(EditText) findViewById(R.id.shopname);
        owname=(EditText) findViewById(R.id.ownname);
        phnum=(EditText) findViewById(R.id.mobnum);
        add=(EditText) findViewById(R.id.address);
        pin=(EditText) findViewById(R.id.pincode);
        subu=(Button) findViewById(R.id.smit);
        prg=(ProgressBar) findViewById(R.id.prgbarinfo);

        cato =(Spinner) findViewById(R.id.spincat);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.cat, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cato.setAdapter(adapter);
        cato.setOnItemSelectedListener(this);


        subu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sname. getText (). toString().trim(). isEmpty()&&!owname. getText (). toString().trim(). isEmpty()&&!add. getText (). toString().trim(). isEmpty()){
                    if((pin.getText().toString().trim()).length()==6){
                        if((phnum.getText().toString().trim()).length()==10 ||(phnum.getText().toString().trim()).length()==0){


                            prg.setVisibility(View.VISIBLE);
                            subu.setVisibility(View.INVISIBLE);

                            //write your code here

                            Intent intent = new Intent(getApplicationContext(), Display.class);
                            startActivity(intent);


                        }else {
                            Toast.makeText(Info.this, "Please enter correct Phone number", Toast.LENGTH_SHORT).show();
                        }
                        }else {
                        Toast.makeText(Info.this, "Please enter correct Pin code", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Info.this, "Please enter required details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }

}



