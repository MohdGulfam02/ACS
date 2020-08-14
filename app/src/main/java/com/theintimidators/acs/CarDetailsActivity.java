package com.theintimidators.acs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CarDetailsActivity extends AppCompatActivity {


     private Button mGetLocationBtn,mBackButton;
     private TextView mSpeed,mTemp,mAlcoholPercentage;
     public final int speed_array[] = new int[] {65,68,45,59,70,57,43,42,25,36};
     public final int temp_array[] = new int[] {22,23,25,30,33,19,18,18,17,32};
     public final double alcohol_array[] = new double[] {0.4,0.2,0.25,0.30,0.33,0.19,0.18,0.1,0.17,0.32};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        Random random = new Random();
        int number = random.nextInt(11);


        mAlcoholPercentage = (TextView)findViewById(R.id.alocohol);
        mTemp = (TextView)findViewById(R.id.temperature);
        mSpeed = (TextView)findViewById(R.id.speed);

        mSpeed.setText(speed_array[number]+" km/h");
        mAlcoholPercentage.setText(alcohol_array[number]+" %");
        mTemp.setText(temp_array[number]+"° C");

        mGetLocationBtn = findViewById(R.id.vehicleLocationButton);
        mBackButton = findViewById(R.id.backButton);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        mGetLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            }
        });
    }
}