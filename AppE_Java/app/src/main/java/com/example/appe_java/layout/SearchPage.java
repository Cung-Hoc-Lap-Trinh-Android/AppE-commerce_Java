package com.example.appe_java.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.appe_java.R;
import com.example.appe_java.databinding.ActivitySearchBinding;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage extends AppCompatActivity {
    ActivitySearchBinding binding;
    SearchView searchView;
    ArrayList<String> arrayList = new ArrayList<>();
    List name = Arrays.asList(new String[]{"cho", "meo", "ca", "abc", "nha", "cay"});

    Toolbar mytoolbarsearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        getSupportActionBar().hide();
        mytoolbarsearch = findViewById(R.id.mytoolbarsearch);
        setSupportActionBar(mytoolbarsearch);

        Window window = getWindow();
// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,(android.R.color.transparent)));










//        binding.listSearch.setAdapter((ListAdapter) name);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
    }
}