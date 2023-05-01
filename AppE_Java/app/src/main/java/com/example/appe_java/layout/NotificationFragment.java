package com.example.appe_java.layout;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appe_java.R;
import com.example.appe_java.adapter.MyViewPagerAdapter;
import com.example.appe_java.databinding.FragmentAccountBinding;
import com.example.appe_java.databinding.FragmentNotificationBinding;
import com.google.android.material.tabs.TabLayout;

public class NotificationFragment extends Fragment {

    FragmentNotificationBinding binding;
    MyViewPagerAdapter myViewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNotificationBinding.inflate(inflater, container, false);
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
        View view = binding.getRoot();

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().show();
        activity.getSupportActionBar().setTitle("Notification");

        myViewPagerAdapter = new MyViewPagerAdapter(this);
        binding.viewPager.setAdapter(myViewPagerAdapter);
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.tabLayout.getTabAt(position).select();
            }
        });





        // Inflate the layout for this fragment
        return view;
    }
}