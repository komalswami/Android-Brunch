package com.example.policeapp;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    Button reg;
    EditText name,aadhar,e_pass;
    FirebaseAuth auth;
    ProgressBar prgbar;
    String adhar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        reg=(Button)findViewById(R.id.button3);
        name=(EditText)findViewById(R.id.e_email);
        aadhar=(EditText)findViewById(R.id.e_aadhar);
        e_pass=(EditText)findViewById(R.id.e_pass);
        prgbar=(ProgressBar)findViewById(R.id.prgbar1);

        auth=FirebaseAuth.getInstance();


        if(auth.getCurrentUser()!= null)
        {
            startActivity(new Intent(getApplicationContext(),complain.class));
            finish();
        }

        reg.setOnClickListener(new View.OnClickListener(){
            @Override
               public void onClick(View v) {
                String username=name.getText().toString().trim();
                String password=e_pass.getText().toString().trim();
                adhar=aadhar.getText().toString();


                prgbar.setVisibility(View.VISIBLE);



                auth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful())
                   {
                       Toast.makeText(MainActivity.this,"User Created!!",Toast.LENGTH_LONG).show();
                       startActivity(new Intent(getApplicationContext(),cam.class));
                   }
                   else
                   {
                       Toast.makeText(MainActivity.this,"Error!!"+task.getException().getMessage(),Toast.LENGTH_LONG).show();

                   }
                    }
                });


            }
        });
    }

    public void gotologin(View view) {
        Intent intent=new Intent(this,login.class);
        startActivity(intent);
    }
}
