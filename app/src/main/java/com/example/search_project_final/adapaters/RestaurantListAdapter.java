package com.example.search_project_final.adapaters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.search_project_final.R;
import com.example.search_project_final.model.RestaurantModel;

import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.MyViewHolder> {
    private List<RestaurantModel> restaurantModelList;
    private RestaurantClickListener ClickListener;

    public RestaurantListAdapter(List<RestaurantModel> restaurantModelList,RestaurantClickListener clickListener)
    {
         this.restaurantModelList=restaurantModelList;
         this.ClickListener=clickListener;
    }
    public void updateData(List<RestaurantModel> restaurantModelList)
    {
        this.restaurantModelList=restaurantModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RestaurantListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantListAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.restaurantTitle.setText(restaurantModelList.get(position).getAddress());
        holder.restaurantadd.setText("Address is :" +restaurantModelList.get(position).getName());
        holder.restauranthours.setText("Today's Hours are:" +restaurantModelList.get(position).getHours().getTodayHours());
       //holder.image.setImageBitmap(bi);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickListener.onItemClick(restaurantModelList.get(position));
            }
        });
        Glide.with(holder.image)
                .load(restaurantModelList.get(position).getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return restaurantModelList.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView restaurantTitle;
        TextView restaurantadd;
        TextView restauranthours;
        ImageView image;


        public MyViewHolder(View view)
        {
            super(view);
            restaurantTitle=view.findViewById(R.id.restaurantTitle);
            restaurantadd=view.findViewById(R.id.restaurantAdd);
            restauranthours=view.findViewById(R.id.restauranthours);
            image=view.findViewById(R.id.image);
        }
    }
    public interface RestaurantClickListener
    {
        public void onItemClick(RestaurantModel restaurantModel);

    }
}
