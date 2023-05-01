package com.example.appe_java.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appe_java.layout.MyNoticeFragment;
import com.example.appe_java.layout.PromotionFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PromotionFragment();
            case 1:
                return new MyNoticeFragment();
            default:
                return new PromotionFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
