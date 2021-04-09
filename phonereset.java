  fgt_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            _completePhoneNo="+91"+_email.getText().toString();
                 Query checkUser= FirebaseDatabase.getInstance().getReference("Users").orderByChild("PhoneNo").equalTo(_completePhoneNo);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    _email.setError(null);
                    Toast.makeText(forgotPassword_Activity.this,"user exists",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),VerificationActivity.class);
                    intent.putExtra("phnNo",_completePhoneNo);
                    intent.putExtra("whattodo","forget_pass");
                    startActivity(intent);
                    finish();
                }
                else {
                    _email.setError("No such user exist!");
                    _email.requestFocus();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
            }
        });
