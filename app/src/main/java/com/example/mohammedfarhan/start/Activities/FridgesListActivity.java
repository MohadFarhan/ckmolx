package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mohammedfarhan.start.Adapters.FridgesListAdapter;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.FridgesDAO;
import com.example.mohammedfarhan.start.Domains.home_appliances.Fridges;
import com.example.mohammedfarhan.start.R;

import java.util.ArrayList;

public class FridgesListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Fridges> fridgesArrayList;
    private FridgesListAdapter fridgesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridges_list);


        recyclerView=(RecyclerView)findViewById(R.id.fridgesListRv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        fridgesArrayList =new FridgesDAO(this).getAllFridges();
        fridgesListAdapter =new FridgesListAdapter(this, fridgesArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(fridgesListAdapter);

    }
}
