package com.example.policeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class New_credential_Activity extends AppCompatActivity {
    EditText _new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_credential_);

        _new=(EditText)findViewById(R.id.new_pass);

    }
    public void setNewPasswordBtn(View view){

        CheckInternet checkInternet=new CheckInternet();
        if(!checkInternet.isConnected(this)){
            Toast.makeText(New_credential_Activity.this, "Internet Conn.!!!", Toast.LENGTH_SHORT).show();
            return;
        }


        String _newPass=_new.getText().toString();
        String _phoneNo=getIntent().getStringExtra("mobile_no");

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");
        reference.child(_phoneNo).child("password").setValue(_newPass);

        startActivity(new Intent(getApplicationContext(),Success.class));
        finish();
    }
}
