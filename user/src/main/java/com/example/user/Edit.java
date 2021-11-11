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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("ALL")
public class Edit extends AppCompatActivity {
    EditText nam,mod2,add,defpin;
    Button bottt;
    ProgressBar prg;
    FirebaseFirestore dbroot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        nam=(EditText) findViewById(R.id.uname);
        mod2=(EditText) findViewById(R.id.mobualt);
        add=(EditText) findViewById(R.id.addu);
       defpin=(EditText) findViewById(R.id.defpin);
       bottt=(Button) findViewById(R.id.smittu);
       prg=(ProgressBar) findViewById(R.id.prgbareditu);
       FirebaseFirestore dbroot = FirebaseFirestore.getInstance();


       bottt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if((defpin.getText().toString().trim()).length() == 6||(defpin.getText().toString().trim()).length() == 0) {
                   if((mod2.getText().toString().trim()).length() == 10||(mod2.getText().toString().trim()).length() == 0) {


                       prg.setVisibility(View.VISIBLE);
                       bottt.setVisibility(View.INVISIBLE);

                       //code for DB
                       DocumentReference doc=dbroot
                               .collection("person").document(getIntent().getStringExtra("phonee")  );
                       Map<String, Object> data = new HashMap<>();
                       data.put("name", nam.getText().toString());
                       // data.put("service", tv.getText().toString());
                       data.put("alternative no",mod2 .getText().toString());
                       // data.put("phone", t3.getText().toString());
                      // data.put("shop", snam.getText().toString());
                       data.put("Address", add.getText().toString());
                        data.put("pincode", defpin.getText().toString());

                       doc.update(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void unused) {
                               Toast.makeText(Edit.this, "updated successfully", Toast.LENGTH_SHORT).show();
                           }
                       })
                               .addOnFailureListener(new OnFailureListener() {
                                   @Override
                                   public void onFailure(@NonNull Exception e) {
                                       Toast.makeText(Edit.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                   }
                               });


                       Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                       startActivity(intent);
                   }else {
                       Toast.makeText(Edit.this, "Please enter valid number", Toast.LENGTH_SHORT).show();
                   }

               }else {
                   Toast.makeText(Edit.this, "Please enter valid Pin code", Toast.LENGTH_SHORT).show();
               }

           }
       });




    }
}