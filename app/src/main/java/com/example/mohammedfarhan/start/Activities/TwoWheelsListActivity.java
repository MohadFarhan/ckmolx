package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mohammedfarhan.start.Adapters.TwoWheelsListAdapter;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.TwoWheelDAO;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.TwoWheel;
import com.example.mohammedfarhan.start.R;

import java.util.ArrayList;

public class TwoWheelsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<TwoWheel> twoWheelArrayList;
    private TwoWheelsListAdapter twoWheelsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_wheels_list);


        recyclerView=(RecyclerView)findViewById(R.id.twoWheelListListRv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        twoWheelArrayList =new TwoWheelDAO(this).getAllTwoWheeler();
        twoWheelsListAdapter =new TwoWheelsListAdapter(this, twoWheelArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(twoWheelsListAdapter);
    }
}
