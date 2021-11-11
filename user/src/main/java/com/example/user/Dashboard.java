package com.example.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


@SuppressWarnings("ALL")
public class Dashboard extends AppCompatActivity {

    Button acc,edt,us,out;
    ProgressBar p1,p2,p3,p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        acc=(Button) findViewById(R.id.account);
        edt=(Button) findViewById(R.id.editt);
        us=(Button) findViewById(R.id.aboutt);
        out=(Button)findViewById(R.id.logouttt);

        p1=(ProgressBar)findViewById(R.id.prgbar1);
        p2=(ProgressBar)findViewById(R.id.prgbar2);
        p3=(ProgressBar)findViewById(R.id.prgbar3);
        p4=(ProgressBar)findViewById(R.id.prgbar4);

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1.setVisibility(View.VISIBLE);
                acc.setVisibility(View.VISIBLE);

                Intent intent=new Intent(getApplicationContext(),Display.class);
                //intent.putExtra("pin",getIntent().getStringExtra("pincode"));
               // intent.putExtra("servicee",getIntent().getStringExtra("service"));
                intent.putExtra("phone",getIntent().getStringExtra("ph"));
                startActivity(intent);
                startActivity(intent);

            }
        });

        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p2.setVisibility(View.VISIBLE);
                edt.setVisibility(View.VISIBLE);

                Intent intent=new Intent(getApplicationContext(),Edit.class);
                //Intent intent=new Intent(getApplicationContext(),Edit.class);
               // intent.putExtra("pinn",getIntent().getStringExtra("pincode"));
               //
                // intent.putExtra("serviceee",getIntent().getStringExtra("service"));
                intent.putExtra("phonee",getIntent().getStringExtra("ph"));
                startActivity(intent);
                //startActivity(intent);

            }
        });

        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p4.setVisibility(View.VISIBLE);
                us.setVisibility(View.VISIBLE);

                Intent intent=new Intent(getApplicationContext(),About.class);
                startActivity(intent);

            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p4.setVisibility(View.VISIBLE);
                out.setVisibility(View.VISIBLE);

                startActivity(new Intent(getApplicationContext(),Choice.class));
                finish();
                Toast.makeText(Dashboard.this, "Successfully Log Out", Toast.LENGTH_SHORT).show();

            }
        });
    }
}