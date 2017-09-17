package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mohammedfarhan.start.Adapters.CarsAdapter;
import com.example.mohammedfarhan.start.Adapters.CarsListAdapter;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.CarsDAO;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cars;
import com.example.mohammedfarhan.start.R;

import java.util.ArrayList;

public class CarsListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CarsListAdapter carsAdapter;
    GridLayoutManager gridLayoutManager;
    private ArrayList<Cars> carsArrayList;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);

        int count=2;
        recyclerView=(RecyclerView)findViewById(R.id.carListRv);
       recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        carsArrayList =new CarsDAO(this).getAllCars();
        carsAdapter =new CarsListAdapter(this, carsArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(carsAdapter);

    }
}
