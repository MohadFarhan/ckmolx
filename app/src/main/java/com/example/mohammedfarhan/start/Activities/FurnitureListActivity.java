package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mohammedfarhan.start.Adapters.FurnituresListAdapter;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.FurnituresDAO;
import com.example.mohammedfarhan.start.Domains.home_appliances.Furnitures;
import com.example.mohammedfarhan.start.R;

import java.util.ArrayList;

public class FurnitureListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Furnitures> furnituresArrayList;
    private FurnituresListAdapter furnituresListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_list);

        recyclerView=(RecyclerView)findViewById(R.id.furnitureListRv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        furnituresArrayList =new FurnituresDAO(this).getAllFurnitures();
        furnituresListAdapter =new FurnituresListAdapter(this, furnituresArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(furnituresListAdapter);
    }
}
