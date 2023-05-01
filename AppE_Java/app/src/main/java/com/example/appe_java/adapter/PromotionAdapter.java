package com.example.appe_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appe_java.R;
import com.example.appe_java.domain.PromotionDomain;

import java.util.ArrayList;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {
    ArrayList<PromotionDomain> notificationDomains;

    public PromotionAdapter(ArrayList<PromotionDomain> notificationDomains) {
        this.notificationDomains = notificationDomains;
    }

    @NonNull
    @Override
    public PromotionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification,parent,false);
        return new PromotionAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionAdapter.ViewHolder holder, int position) {
//        holder.Topic.setText(notificationDomains.get(position).getTopic());
//        holder.Content.setText(notificationDomains.get(position).getContent());
//        holder.Time.setText(notificationDomains.get(position).getTime());
//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(notificationDomains.get(position).getImg(),"drawable",holder.itemView.getContext().getPackageName());
//        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imgNotification);
    }


    @Override
    public int getItemCount() {
        return notificationDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Topic;
        TextView Content;
        TextView Time;
        ImageView imgNotification;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Topic = itemView.findViewById(R.id.txtTopic);
            Content = itemView.findViewById(R.id.txtContent);
            Time = itemView.findViewById(R.id.txtTime);
            imgNotification = itemView.findViewById(R.id.imgNotification);

        }
    }
}
