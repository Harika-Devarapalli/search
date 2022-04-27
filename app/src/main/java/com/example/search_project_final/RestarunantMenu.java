package com.example.search_project_final;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.search_project_final.adapaters.MenuListAdapter;
import com.example.search_project_final.model.Menu;
import com.example.search_project_final.model.RestaurantModel;

import java.util.List;

public class RestarunantMenu extends AppCompatActivity implements MenuListAdapter.MenuListClickListener{
    private List<Menu>menuList=null;
    private MenuListAdapter menuListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restarunant_menu);
        RestaurantModel restaurantModel=getIntent().getParcelableExtra("RestaurantModel");
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(restaurantModel.getName());
        actionBar.setSubtitle(restaurantModel.getAddress());
        actionBar.setDisplayHomeAsUpEnabled(true);
        menuList=restaurantModel.getMenu();
        initReyclerView();

        TextView submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
    private void initReyclerView()
    {
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        menuListAdapter=new MenuListAdapter(menuList,this);

        recyclerView.setAdapter(menuListAdapter);
    }

    @Override
    public void onAddToCart(Menu menu) {

    }
}