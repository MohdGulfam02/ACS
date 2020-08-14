package com.theintimidators.acs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class DriverDetailsActivity extends AppCompatActivity {

    private Button mBackButton1;
    private TextView mDriverName;
    private static TextView mAge,mStatus;
    private static TextView mMobileNumber;
    private static TextView mDriverStatus;
    private  FirebaseFirestore db = FirebaseFirestore.getInstance();
    private  DocumentReference firstUser = db.document("UserDetails/first user details");

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_details);

        mStatus = (TextView)findViewById(R.id.driverStatus);
        Random random = new Random();
        int number = random.nextInt(20);
        if(number % 2 == 0){
            mStatus.setText("Yes");
        }
        else {
             mStatus.setText("No");
        }
        mAge = (TextView) findViewById(R.id.age);
        mDriverName = (TextView) findViewById(R.id.driver_name);
        mMobileNumber = (TextView) findViewById(R.id.mobile_number);
        mDriverStatus = (TextView) findViewById(R.id.driverStatus);

        mBackButton1 = findViewById(R.id.backButton1);

                loadData();
        mBackButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }


    public void loadData(){
        super.onStart();

        firstUser.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        if(documentSnapshot.exists()){
                                String driver = documentSnapshot.getString(DriverDetailFormActivity.KEY_NAME);
                                String age = documentSnapshot.getString(DriverDetailFormActivity.KEY_AGE);
                                String mobile = documentSnapshot.getString(DriverDetailFormActivity.KEY_MOBILE);


                                mDriverName.setText(driver);
                                mAge.setText(age);
                                mMobileNumber.setText(mobile);
                                mDriverStatus.setText("No");
                        }
                        else{
                            Toast.makeText(DriverDetailsActivity.this, "data does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DriverDetailsActivity.this, "Error! in loading data", Toast.LENGTH_SHORT).show();
                        Log.d("ACS",""+e.toString());
                    }
                });

    }

}


