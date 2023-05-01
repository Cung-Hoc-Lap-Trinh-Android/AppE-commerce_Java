package com.example.appe_java.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appe_java.R;
import com.example.appe_java.databinding.ActivitySignupBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignupPage extends AppCompatActivity {
    ActivitySignupBinding binding;
    String otp;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        binding.btnRegister.setOnClickListener(v -> {
            if (!binding.edtUsername.getText().toString().trim().isEmpty() || !binding.edtPhoneNumber.getText().toString().trim().isEmpty()
                    || !binding.edtPass.getText().toString().trim().isEmpty() || !binding.edtConfirmPass.getText().toString().trim().isEmpty()) {
                if (binding.edtPhoneNumber.getText().toString().trim().length() == 10) {
                    binding.probar.setVisibility(View.VISIBLE);
                    PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
                            .setPhoneNumber(binding.txtPhoneCode.getText().toString().trim() + binding.edtPhoneNumber.getText().toString().trim())
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(this).setCallbacks(mCallBack).build();
                    PhoneAuthProvider.verifyPhoneNumber(options);
                } else {
                    Toast.makeText(SignupPage.this, "Please enter correct Number", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(SignupPage.this, "Enter Mobile number", Toast.LENGTH_SHORT).show();
            }
        });

        }
        protected PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                binding.probar.setVisibility(View.GONE);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                binding.probar.setVisibility(View.GONE);
                Toast.makeText(SignupPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                binding.probar.setVisibility(View.GONE);
                Intent intent = new Intent(getApplicationContext(), OTP_SignupPage.class);
                intent.putExtra("Username", binding.edtUsername.getText().toString().trim());
                intent.putExtra("PhoneNumber", binding.edtPhoneNumber.getText().toString().trim());
                intent.putExtra("OTP", s);
                intent.putExtra("Password", binding.edtPass.getText().toString().trim());
                startActivity(intent);
            }
        };
    }