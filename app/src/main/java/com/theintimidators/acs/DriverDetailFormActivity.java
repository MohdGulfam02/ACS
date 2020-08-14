package com.theintimidators.acs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class DriverDetailFormActivity extends AppCompatActivity {

    private static final String TAG = "DriverDetailFormActivity";

    protected static final String KEY_NAME = "name";
    protected static final String KEY_AGE = "age";
    protected static final String KEY_MOBILE ="mobile";
    private static final String KEY_REGISTRATION_NUMBER = "registration_number";
    private static final String KEY_VEHICLE_NUMBER = "vehicle_number";
    private static final String KEY_CAR_COLOR = "car_color";
    private static final String KEY_CAR_MODEL = "car_model";


    Button mConfirmButton;
    EditText mName,mAge,mMobile,mRegister,mVehicleNo,mCarModel,mCarColor;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_detail_form);

        mConfirmButton = (Button)findViewById(R.id.confirmBtn);
        mName = (EditText)findViewById(R.id.driverName);
        mAge = (EditText)findViewById(R.id.age);
        mMobile =(EditText) findViewById(R.id.mobileNumber);
        mRegister = (EditText)findViewById(R.id.registrationNumber) ;
        mVehicleNo =(EditText) findViewById(R.id.vehicleNumber);
        mCarColor = (EditText)findViewById(R.id.carColor);
        mCarModel = (EditText)findViewById(R.id.carModel);


    mConfirmButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        String name = mName.getText().toString();
        String age = mAge.getText().toString();
        String mobile = mMobile.getText().toString();
        String registration = mRegister.getText().toString();
        String vehicle_number = mVehicleNo.getText().toString();
        String car_color = mCarColor.getText().toString();
        String car_model = mCarModel.getText().toString();

        Map<String, Object> data = new HashMap<>();

        data.put(KEY_NAME, name);
        data.put(KEY_AGE, age);
        data.put(KEY_MOBILE, mobile);
        data.put(KEY_REGISTRATION_NUMBER, registration);
        data.put(KEY_VEHICLE_NUMBER, vehicle_number);
        data.put(KEY_CAR_COLOR, car_color);
        data.put(KEY_CAR_MODEL, car_model);

        db.collection("UserDetails").document("first user details").set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(DriverDetailFormActivity.this, "details saved successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DriverDetailFormActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        Log.d("ACS", "error is : " + e.toString());
                    }
                });
             }
        });
    }
}