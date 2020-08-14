package com.theintimidators.acs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ContactActivity extends AppCompatActivity {

    ImageButton mCallBtn, mCall112Btnl;
    Button mBackButton2;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mCall112Btnl = findViewById(R.id.call112Button);
        mCallBtn = findViewById(R.id.callButton);
        mBackButton2 =  findViewById(R.id.backButton2);

        mCallBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                String phone = "7982495600";
                String s = "tel:" + phone;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(s));
                startActivity(intent);
            }
        });

        mCall112Btnl.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                String phone1 = "8383004274";
                String s1 = "tel:" + phone1;
                Intent intent1 = new Intent(Intent.ACTION_CALL);
                intent1.setData(Uri.parse(s1));
                startActivity(intent1);
            }
        });

        mBackButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}