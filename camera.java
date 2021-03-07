package com.example.policeapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class cam extends AppCompatActivity {
    ImageView imageView;
    Button btOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);

        btOpen=(Button)findViewById(R.id.cam_open);
        imageView=(ImageView)findViewById(R.id.img1);

        if(ContextCompat.checkSelfPermission(cam.this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(cam.this,new String[]{Manifest.permission.CAMERA},100);
        }
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);
            }
        });
    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       super.onActivityResult(requestCode,resultCode,data);
       if(requestCode==100){
           Bitmap captureImage=(Bitmap)data.getExtras().get("data");
           imageView.setImageBitmap(captureImage);

       }

   }
}
