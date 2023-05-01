package com.example.appe_java.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appe_java.R;
import com.example.appe_java.databinding.ActivitySplashBinding;

public class SplashPage extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();


        binding.btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this,LoginPage.class);
            startActivity(intent);
        });



    }

}