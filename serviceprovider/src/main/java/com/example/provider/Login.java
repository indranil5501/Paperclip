package com.example.provider;

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
public class Login extends AppCompatActivity {

    EditText input_number;
    EditText input_password;
    Button login;
    ProgressBar prgbar;
    String pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_number=(EditText) findViewById(R.id.login_num);
        input_password=(EditText) findViewById(R.id.login_password);
        login=(Button) findViewById(R.id.login_button);
        prgbar=(ProgressBar) findViewById(R.id.prgbar_login);
        FirebaseFirestore dbroot = FirebaseFirestore.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input_number. getText (). toString().trim(). isEmpty()&&!input_password. getText (). toString().trim(). isEmpty()){
                    if((input_number.getText().toString().trim()).length()==10&&(input_password.getText().toString().trim()).length()==5) {

                       // prgbar.setVisibility(View.VISIBLE);
                       // login.setVisibility(View.INVISIBLE);

                        //code for DB

                        dbroot.collection("s log in")
                                .whereEqualTo("password", input_password.getText().toString())
                                .whereEqualTo("phone", input_number.getText().toString())
                                .get()
                                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                        if (task.isSuccessful()) {
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                               // Log.d(TAG, document.getId() + " => " + document.getData());
                                               // Toast.makeText(, "", Toast.LENGTH_SHORT).show();
                                           // String pp =    document.getId();
                                                prgbar.setVisibility(View.VISIBLE);
                                                login.setVisibility(View.INVISIBLE);
                                                Toast.makeText(Login.this, "Successful", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                                startActivity(intent);
                                            }



                                        }else{
                                            Toast.makeText(Login.this, "invalid", Toast.LENGTH_SHORT).show();
                                        }




                                    }
                                });



                    }else {
                        Toast.makeText(Login.this, "PASSWORD or PHONE NUMBER is ont correct", Toast.LENGTH_SHORT).show();
                    }

                    }else {
                        Toast.makeText(Login.this, "Please enter the PASSWORD", Toast.LENGTH_SHORT).show();
                    }

            }
        });




    }
}