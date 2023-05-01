package com.example.appe_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appe_java.R;
import com.example.appe_java.domain.CategoryDomain;
import com.example.appe_java.domain.FoodDomain;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<FoodDomain> foodDomains;

    public PopularAdapter(ArrayList<FoodDomain> foodDomains) {
        this.foodDomains = foodDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(foodDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(foodDomains.get(position).getFee()));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getImg(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, fee, sold;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            fee = itemView.findViewById(R.id.txtFee);
            sold = itemView.findViewById(R.id.txtSold);
            img = itemView.findViewById(R.id.imgProduct);


        }
    }
}

