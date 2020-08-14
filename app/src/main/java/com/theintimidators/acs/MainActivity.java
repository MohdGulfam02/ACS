package com.theintimidators.acs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton mDriverdetailsBtn,mCardetailsBtn,mContactDetailsBtn;
    Button mLogoutBtn,mCompletProfileBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDriverdetailsBtn = findViewById(R.id.driverImageButton);
        mCardetailsBtn = findViewById(R.id.carImageButton);
        mContactDetailsBtn = findViewById(R.id.contactImageButton);
        mLogoutBtn = findViewById(R.id.logoutButton);
        mCompletProfileBtn = findViewById(R.id.completProfile);

        mCardetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CarDetailsActivity.class));
            }
        });

        mContactDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ContactActivity.class));
            }
        });

        mDriverdetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DriverDetailsActivity.class));
            }
        });

        mCompletProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DriverDetailFormActivity.class));
            }
        });
        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               startActivity(new Intent(getApplicationContext(),LoginActivity.class));

                finish();
            }
        });
    }
}