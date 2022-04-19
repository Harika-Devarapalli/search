package com.example.search_project_final.adapaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.search_project_final.R;
import com.example.search_project_final.model.RestaurantModel;

import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.MyViewHolder> {
    private List<RestaurantModel> restaurantModelList;
    public RestaurantListAdapter(List<RestaurantModel> restaurantModelList)
    {
         this.restaurantModelList=restaurantModelList;
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
    public void onBindViewHolder(@NonNull RestaurantListAdapter.MyViewHolder holder, int position) {
        holder.restaurantTitle.setText(restaurantModelList.get(position).getAddress());
        holder.restaurantadd.setText("Address is :" +restaurantModelList.get(position).getAddress());
        holder.restauranthours.setText("Today's Hours are:" +restaurantModelList.get(position).getName());
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
}
