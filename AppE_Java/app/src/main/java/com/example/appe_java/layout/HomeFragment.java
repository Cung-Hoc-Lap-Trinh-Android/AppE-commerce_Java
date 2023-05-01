package com.example.appe_java.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.appe_java.R;
import com.example.appe_java.adapter.CategoryAdapter;
import com.example.appe_java.adapter.PopularAdapter;
import com.example.appe_java.databinding.FragmentHomeBinding;
import com.example.appe_java.domain.CategoryDomain;
import com.example.appe_java.domain.FoodDomain;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView.Adapter adapterCategory, adapterPopular;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopular;
    private RecyclerView recyclerViewCategoryList3;

//    private ImageSlider imageSlider;

    FragmentHomeBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
        View view = binding.getRoot();
        recyclerViewCategory(view);
        recyclerViewPopular(view);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().hide();

        binding.btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(),SearchPage.class);
            startActivity(intent);
        });

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.slider1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider3, ScaleTypes.FIT));

        binding.imageSlider.setImageList(slideModels, ScaleTypes.FIT);


        // Inflate the layout for this fragment
        return view;
    }


    private void recyclerViewCategory(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);

        recyclerViewCategoryList = view.findViewById(R.id.listCategory);

        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Shirt","shirt"));
        category.add(new CategoryDomain("Dress","dress"));
        category.add(new CategoryDomain("Skirt","skirt"));
        category.add(new CategoryDomain("Handbag","handbag"));
        category.add(new CategoryDomain("Shoes","shoes"));

        adapterCategory = new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapterCategory);

    }

    private void recyclerViewPopular(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopular = view.findViewById(R.id.listSpecial);

        recyclerViewPopular.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodDomains = new ArrayList<>();
        foodDomains.add(new FoodDomain("Shirt","ao1","sjhxshdkxhaskdhksahdkhash",9.76));
        foodDomains.add(new FoodDomain("Shirt","ao1","sjhxshdkxhaskdhksahdkhash",9.76));
        foodDomains.add(new FoodDomain("Shirt","ao1","sjhxshdkxhaskdhksahdkhash",9.76));
        foodDomains.add(new FoodDomain("Shirt","ao1","sjhxshdkxhaskdhksahdkhash",9.76));
        foodDomains.add(new FoodDomain("Shirt","ao1","sjhxshdkxhaskdhksahdkhash",9.76));
        foodDomains.add(new FoodDomain("Shirt","ao1","sjhxshdkxhaskdhksahdkhash",9.76));
        foodDomains.add(new FoodDomain("Shirt","ao1","sjhxshdkxhaskdhksahdkhash",9.76));
        foodDomains.add(new FoodDomain("Shirt","ao1","sjhxshdkxhaskdhksahdkhash",9.76));

        adapterPopular = new PopularAdapter(foodDomains);
        recyclerViewPopular.setAdapter(adapterPopular);

        GridLayoutManager linearLayoutManager3 = new GridLayoutManager(getContext(), 2);
        recyclerViewCategoryList3 = view.findViewById(R.id.listPopular);
        recyclerViewCategoryList3.setLayoutManager(linearLayoutManager3);
        recyclerViewCategoryList3.setAdapter(adapterPopular);
    }
}