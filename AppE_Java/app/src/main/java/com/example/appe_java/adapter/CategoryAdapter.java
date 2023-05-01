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

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String ImgUrl = "";
        switch(position){
            case 0:{
                ImgUrl= categoryDomains.get(position).getImg();
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.custom_cat_item1));
                break;
            }
            case 1:{
                ImgUrl= categoryDomains.get(position).getImg();
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.custom_cat_item2));
                break;
            }
            case 2:{
                ImgUrl= categoryDomains.get(position).getImg();
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.custom_cat_item3));
                break;
            }
            case 3:{
                ImgUrl=categoryDomains.get(position).getImg();
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.custom_cat_item4));
                break;
            }
            case 4: {
                ImgUrl = categoryDomains.get(position).getImg();
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.custom_cat_item5));
                break;
            }
        }

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(ImgUrl,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryImg);

    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryImg;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.txtCategory);
            categoryImg = itemView.findViewById(R.id.imgCategory);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
