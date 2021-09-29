package com.example.serviceprovider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Display extends AppCompatActivity {
    TextView snam,onam,con1,con2,cato,sadd,pin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        snam=(TextView) findViewById(R.id.shopnam);
        onam=(TextView) findViewById(R.id.ownnam);
        con1=(TextView) findViewById(R.id.mobn);
        con2=(TextView) findViewById(R.id.amobn);
        cato=(TextView)findViewById(R.id.cat);
        sadd=(TextView) findViewById(R.id.address);
        pin=(TextView) findViewById(R.id.pincode);


        BottomNavigationView BottomNavigationView=findViewById(R.id.botnap);

        BottomNavigationView.setSelectedItemId(R.id.edit);

        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.edit:
                        startActivity(new Intent(getApplicationContext(),Info.class));
                        break;
                    case R.id.comment:
                        startActivity(new Intent(getApplicationContext(),Comment.class));
                        break;
                    case R.id.dash:
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        break;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        break;
                    case R.id.logout:
                        startActivity(new Intent(getApplicationContext(),Login.class));
                        finish();
                        Toast.makeText(Display.this, "Successfully Log Out", Toast.LENGTH_SHORT).show();
                        break;

                }

                return false;
            }
        });



    }
}