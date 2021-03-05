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
    FirebaseAuth fAuth;
    ProgressBar prgbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg=(Button)findViewById(R.id.button3);
        name=(EditText)findViewById(R.id.e_name);
        aadhar=(EditText)findViewById(R.id.e_aadhar);
        e_pass=(EditText)findViewById(R.id.e_pass);
        prgbar=(ProgressBar)findViewById(R.id.prgbar1);



        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),ReportActivity.class));
            finish();
        }


        reg.setOnClickListener(new View.OnClickListener(){
            @Override
               public void onClick(View v) {
                String username=name.getText().toString().trim();
                String password=e_pass.getText().toString().trim();



                prgbar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"user created",Toast.LENGTH_SHORT).show();


                            startActivity(new Intent(getApplicationContext(),ReportActivity.class));
                        }else
                        {
                        Toast.makeText(MainActivity.this,"error!!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            prgbar.setVisibility(View.GONE);
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
