package com.example.serviceprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Dashboard extends AppCompatActivity {

    Button acc,edt,cmnt,us;
    ProgressBar p1,p2,p3,p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        acc=(Button) findViewById(R.id.account);
        edt=(Button) findViewById(R.id.editt);
        cmnt=(Button) findViewById(R.id.commentbott);
        us=(Button) findViewById(R.id.aboutt);

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
                startActivity(intent);

            }
        });

        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p2.setVisibility(View.VISIBLE);
                edt.setVisibility(View.VISIBLE);

                Intent intent=new Intent(getApplicationContext(),Info.class);
                startActivity(intent);

            }
        });
        cmnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p3.setVisibility(View.VISIBLE);
                cmnt.setVisibility(View.VISIBLE);

                Intent intent=new Intent(getApplicationContext(),Comment.class);
                startActivity(intent);

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
    }
}