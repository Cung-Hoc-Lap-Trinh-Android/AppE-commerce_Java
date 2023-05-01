package com.example.appe_java.layout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appe_java.R;
import com.example.appe_java.adapter.PromotionAdapter;
import com.example.appe_java.databinding.FragmentPromotionBinding;
import com.example.appe_java.domain.CategoryDomain;
import com.example.appe_java.domain.PromotionDomain;

import java.util.ArrayList;

public class PromotionFragment extends Fragment {
    FragmentPromotionBinding binding;
    PromotionAdapter promotionAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPromotionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        recyclerViewPromotion(view);
        // Inflate the layout for this fragment
        return view;
    }

    private void recyclerViewPromotion(View view) {
        recyclerView = view.findViewById(R.id.listPromotion);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<PromotionDomain> promotion = new ArrayList<>();
        promotion.add(new PromotionDomain("Shirt","shirt xbsn snjn jsjsk sms","ao1","1-1-220"));
        promotion.add(new PromotionDomain("Shirt","shirt xbsn snjn jsjsk sms","ao1","1-1-220"));
        promotion.add(new PromotionDomain("Shirt","shirt xbsn snjn jsjsk sms","ao1","1-1-220"));
        promotion.add(new PromotionDomain("Shirt","shirt xbsn snjn jsjsk sms","ao1","1-1-220"));
        promotion.add(new PromotionDomain("Shirt","shirt xbsn snjn jsjsk sms","ao1","1-1-220"));

        promotionAdapter = new PromotionAdapter(promotion);
        recyclerView.setAdapter(promotionAdapter);
    }
}