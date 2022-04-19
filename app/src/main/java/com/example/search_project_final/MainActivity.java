package com.example.search_project_final;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.search_project_final.adapaters.RestaurantListAdapter;
import com.example.search_project_final.model.RestaurantModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Restaurnt List");
        List<RestaurantModel> restaurantModelList=getRestaurantData();
        initRecyclerView(restaurantModelList);

    }
    private void initRecyclerView(List<RestaurantModel> restaurantModelList)
    {
        RecyclerView recyclerview=findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        RestaurantListAdapter adapter=new RestaurantListAdapter(restaurantModelList);;

        recyclerview.setAdapter(adapter);
    }
    private List<RestaurantModel> getRestaurantData(){
        InputStream is=getResources().openRawResource(R.raw.res);
        Writer writer=new StringWriter();
        char[] buffer=new char[1024];
        try
            {
                Reader reader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                int n;
                while((n=reader.read(buffer))!=-1)
                {
                    writer.write(buffer,0,n);
                }
            }
        catch (Exception e)
        {

        }
        String jsonStr=writer.toString();
        Gson gson=new Gson();
        RestaurantModel[] restaurantModels=gson.fromJson(jsonStr,RestaurantModel[].class);
        List<RestaurantModel> restList= Arrays.asList(restaurantModels);

        return restList;
    }
}

