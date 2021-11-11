package com.example.provider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


@SuppressWarnings("ALL")
public class Dashboard extends AppCompatActivity {

    Button acc,edt,cmnt,us,out;
    ProgressBar p1,p2,p3,p4,p5;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        acc=(Button) findViewById(R.id.account);
        edt=(Button) findViewById(R.id.editt);
        cmnt=(Button) findViewById(R.id.commentbott);
        us=(Button) findViewById(R.id.aboutt);
        out=(Button)findViewById(R.id.logouttt);

        p1=(ProgressBar)findViewById(R.id.prgbar1);
        p2=(ProgressBar)findViewById(R.id.prgbar2);
        p3=(ProgressBar)findViewById(R.id.prgbar3);
        p4=(ProgressBar)findViewById(R.id.prgbar4);
        p5=(ProgressBar)findViewById(R.id.prgbar5);

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1.setVisibility(View.VISIBLE);
                acc.setVisibility(View.VISIBLE);

                Intent intent=new Intent(getApplicationContext(),Display.class);
                intent.putExtra("pin",getIntent().getStringExtra("pincode"));
                intent.putExtra("servicee",getIntent().getStringExtra("service"));
                intent.putExtra("phone",getIntent().getStringExtra("ph"));
                startActivity(intent);

            }
        });

        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p2.setVisibility(View.VISIBLE);
                edt.setVisibility(View.VISIBLE);

                Intent intent=new Intent(getApplicationContext(),Edit.class);
                intent.putExtra("pinn",getIntent().getStringExtra("pincode"));
                intent.putExtra("serviceee",getIntent().getStringExtra("service"));
                intent.putExtra("phonee",getIntent().getStringExtra("ph"));
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
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // p5.setVisibility(View.VISIBLE);
               // out.setVisibility(View.VISIBLE);
                mAuth = FirebaseAuth.getInstance();

                FirebaseUser user = mAuth.getCurrentUser();
                if(user != null )
                {
                    mAuth.signOut();
                    Toast.makeText(Dashboard.this, "Successfully Log Out", Toast.LENGTH_SHORT).show();
                }



                // Intent intent = new Intent(getApplicationContext(),Logout.class);
                //startActivity(new Intent(getApplicationContext(),Logout.class));
                //finish();
                //startActivity(intent);
                //Toast.makeText(Dashboard.this, "Successfully Log Out", Toast.LENGTH_SHORT).show();

            }
        });
    }
}