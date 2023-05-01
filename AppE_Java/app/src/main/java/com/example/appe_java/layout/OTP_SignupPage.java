package com.example.appe_java.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appe_java.MainActivity;
import com.example.appe_java.R;
import com.example.appe_java.database.User;
import com.example.appe_java.databinding.ActivityOtpSignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OTP_SignupPage extends AppCompatActivity {
    ActivityOtpSignupBinding binding;
    String otp, userName, passWord, phoneNumber;
//    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        otp = getIntent().getStringExtra("OTP");
        phoneNumber = String.format("+84-%S",getIntent().getStringExtra("PhoneNumber"));
        binding.txtMobileNo.setText(phoneNumber);
        userName = getIntent().getStringExtra("Username");
        passWord = getIntent().getStringExtra("Password");
        binding.btnVerfiy.setOnClickListener(v -> {
            if(!binding.edtNumber1.getText().toString().trim().isEmpty()
                    && !binding.edtNumber2.getText().toString().trim().isEmpty()
                    && !binding.edtNumber3.getText().toString().trim().isEmpty()
                    && !binding.edtNumber4.getText().toString().trim().isEmpty()
                    && !binding.edtNumber5.getText().toString().trim().isEmpty()
                    && !binding.edtNumber6.getText().toString().trim().isEmpty() ){

                String getOtp = binding.edtNumber1.getText().toString().trim()
                        +binding.edtNumber2.getText().toString().trim()
                        +binding.edtNumber3.getText().toString().trim()
                        +binding.edtNumber4.getText().toString().trim()
                        +binding.edtNumber5.getText().toString().trim()
                        +binding.edtNumber6.getText().toString().trim();

               if (otp != null){
                   binding.probar.setVisibility(View.VISIBLE);
                   PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(otp, getOtp);
                   FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                           .addOnCompleteListener(task -> {
                               binding.probar.setVisibility(View.GONE);
                               if (task.isSuccessful()) {
                                   FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                           .setValue(
                                                   new User(userName, passWord, phoneNumber, "user")
                                           )
                                           .addOnCompleteListener(new OnCompleteListener<Void>() {
                                               @Override
                                               public void onComplete(@NonNull Task<Void> task) {
                                                   binding.probar.setVisibility(View.GONE);
                                                   if (task.isSuccessful()){
                                                       Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                       Toast.makeText(OTP_SignupPage.this, "Thanh cong", Toast.LENGTH_SHORT).show();
                                                   }else{

                                                   }
                                               }
                                           });


                                   Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                   startActivity(intent);
                               } else {
                                   Toast.makeText(getApplicationContext(), "Enter corrent OTP", Toast.LENGTH_SHORT).show();
                               }
                           });
               }

            }
        });
    }
}