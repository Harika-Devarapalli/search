package com.example.search_project_final.adapaters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.search_project_final.R;
import com.example.search_project_final.model.Menu;
import com.example.search_project_final.model.RestaurantModel;

import java.util.List;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MyViewHolder> {
    private List<Menu> menuList;
    private MenuListClickListener ClickListener;
    public MenuListAdapter(List<Menu> menuList, MenuListClickListener clickListener)
    {
         this.menuList=menuList;
         this.ClickListener=clickListener;
    }
    public void updateData(List<Menu> menuList)
    {
        this.menuList=menuList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuListAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.menuName.setText(menuList.get(position).getItem_name());
        holder.menuprice.setText("Price is:" +menuList.get(position).getItem_price());
        holder.addtocartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu menu=menuList.get(position);
                menu.setTotalcart(1);
                ClickListener.onAddToCartButton(menu);
                holder.layout.setVisibility(View.VISIBLE);
                holder.addtocartbutton.setVisibility(View.GONE);
                holder.count.setText(menu.getTotalcart()+"");
            }
        });
       //holder.image.setImageBitmap(bi);
        //holder.itemView.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v)
            //{
            //    ClickListener.onAddToCartButton(menuList.get(position));
            //}
       //});
        Glide.with(holder.image)
                .load(menuList.get(position).getUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView menuName;
        TextView menuprice;
        TextView addtocartbutton;
        ImageView image;
        ImageView buttonminus;
        ImageView buttonplus;
        TextView count;
        LinearLayout layout;



        public MyViewHolder(View view)
        {
            super(view);
            menuName=view.findViewById(R.id.menuName);
            menuprice=view.findViewById(R.id.menuprice);
            addtocartbutton=view.findViewById(R.id.addtocartbutton);
            image=view.findViewById(R.id.image);
            buttonminus=view.findViewById(R.id.buttonminus);
            buttonplus=view.findViewById(R.id.buttonplus);
            count=view.findViewById(R.id.count);
            layout=view.findViewById(R.id.layout);
        }
    }
    public interface MenuListClickListener
    {
        public void onAddToCartButton(Menu menu);

    }
}
