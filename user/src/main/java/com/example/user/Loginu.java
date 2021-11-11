package com.example.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

@SuppressWarnings("ALL")
public class Loginu extends AppCompatActivity {

    EditText log;
    EditText pass;
    Button login;
    ProgressBar prg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginu);

        log=(EditText) findViewById(R.id.lognum);
        pass=(EditText) findViewById(R.id.logpassword);
        login=(Button) findViewById(R.id.logbuttonu);
        prg=(ProgressBar) findViewById(R.id.prgbarlogin);
        FirebaseFirestore dbroot = FirebaseFirestore.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!log.getText().toString().trim().isEmpty()&& !pass.getText().toString().trim().isEmpty()){
                    if((log.getText().toString().trim()).length()==10&&(pass.getText().toString().trim()).length()==5) {
                    prg.setVisibility(View.VISIBLE);
                    login.setVisibility(View.INVISIBLE);

                        //code for DB
                        dbroot.collection("U log in")
                                .whereEqualTo("password", pass.getText().toString())
                                .whereEqualTo("phone", log.getText().toString())
                                .get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                // Log.d(TAG, document.getId() + " => " + document.getData());
                                                // Toast.makeText(, "", Toast.LENGTH_SHORT).show();
                                                // String pp =    document.getId();
                                                prg.setVisibility(View.VISIBLE);
                                                login.setVisibility(View.INVISIBLE);
                                                Toast.makeText(Loginu.this, "Successful", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), Msearch.class);
                                                intent.putExtra("phh",log.getText().toString());
                                                startActivity(intent);
                                            }



                                        }else{
                                            Toast.makeText(Loginu.this, "invalid", Toast.LENGTH_SHORT).show();
                                        }




                                    }
                                });



                        //Intent intent=new Intent(getApplicationContext(),Msearch.class);
                   //  startActivity(intent);
                    }else {
                        Toast.makeText(Loginu.this, "PASSWORD or PHONE NUMBER is ont correct", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(Loginu.this, "Please enter required details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}