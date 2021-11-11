package com.example.provider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Logout extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //p5.setVisibility(View.VISIBLE);
                //out.setVisibility(View.VISIBLE);
                 mAuth = FirebaseAuth.getInstance();

                FirebaseUser user = mAuth.getCurrentUser();
                if(user != null )
                {
                    user.delete();
                    Toast.makeText(Logout.this, "Successfully Log Out", Toast.LENGTH_SHORT).show();
                }




               // startActivity(new Intent(getApplicationContext(), Choice.class));
               // finish();
                //Toast.makeText(Logout.this, "Successfully Log Out", Toast.LENGTH_SHORT).show();
            }

            });


    }
        @Override
        protected void onStart() {
            super.onStart();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser == null) {
                startActivity(new Intent(Logout.this, Singup.class));
                finish();
            }
        }
}