package com.example.policeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword_Activity extends AppCompatActivity {
    private Button fgt_pass;
    private EditText _email;
    String phn_no,_completePhoneNo,email;
    FirebaseAuth mauth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_);

        fgt_pass=(Button)findViewById(R.id.fgt_pass_btn);
        _email=(EditText)findViewById(R.id.fgt_email);


        fgt_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email=_email.getText().toString();
                Toast.makeText(forgotPassword_Activity.this,email,Toast.LENGTH_LONG).show();
                mauth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(forgotPassword_Activity.this,"Reset mail sent",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(forgotPassword_Activity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                    }
                });
            }
        });
        
    }
}
