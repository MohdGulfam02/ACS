package com.theintimidators.acs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    EditText mFullName, mPassword, mEmail, mVehicleNumber,mMobileNumber;
    Button mRegisterBtn;
    TextView mLoginBtn;
    ProgressBar mProgressBar;
    FirebaseAuth mAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullName);
        mPassword = findViewById(R.id.password);
        mEmail = findViewById(R.id.email);
        mMobileNumber = findViewById(R.id.mobileNumber);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mLoginBtn = findViewById(R.id.loginBtn);
        mProgressBar = findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String mobile = mMobileNumber.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email should not be empty!");
                    return;
                }
                else if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password should not be empty!");
                    return;
                }

                else if(TextUtils.isEmpty(mobile) ){
                    mVehicleNumber.setError("Vehicle number should not be empty!");
                }
                else if(mobile.length() < 10){
                    mMobileNumber.setError("Mobile Number must contain 10 digits ");
                }

                mProgressBar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"User created successfull!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            mProgressBar.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(RegisterActivity.this,"Error",Toast.LENGTH_SHORT).show();
                            mProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }
}