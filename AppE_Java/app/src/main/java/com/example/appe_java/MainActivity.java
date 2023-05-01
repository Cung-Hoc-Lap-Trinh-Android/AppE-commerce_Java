package com.example.appe_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.appe_java.databinding.ActivityMainBinding;
import com.example.appe_java.layout.AccountFragment;
import com.example.appe_java.layout.CartFragment;
import com.example.appe_java.layout.HomeFragment;
import com.example.appe_java.layout.MessagePage;
import com.example.appe_java.layout.NotificationFragment;
import com.example.appe_java.layout.ScanFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
//    Toolbar mytoolbarsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.white)));



        replaceFragment(new HomeFragment());

        binding.bottomNav.setBackground(null);

        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.action_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.action_notification:
                    replaceFragment(new NotificationFragment());
                    break;
                case R.id.action_scan:
                    replaceFragment(new ScanFragment());
                    break;
                case R.id.action_cart:
                    replaceFragment(new CartFragment());
                    break;
                case R.id.action_acc:
                    replaceFragment(new AccountFragment());
                    break;
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}