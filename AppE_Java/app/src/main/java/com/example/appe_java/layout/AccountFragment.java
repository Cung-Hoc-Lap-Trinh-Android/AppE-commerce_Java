package com.example.appe_java.layout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appe_java.R;
import com.example.appe_java.databinding.FragmentAccountBinding;
import com.example.appe_java.databinding.FragmentHomeBinding;

public class AccountFragment extends Fragment {

    FragmentAccountBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAccountBinding.inflate(inflater, container, false);
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
        View view = binding.getRoot();

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().hide();
        return view;
    }
}