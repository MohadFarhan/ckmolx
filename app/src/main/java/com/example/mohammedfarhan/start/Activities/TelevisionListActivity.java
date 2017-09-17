package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mohammedfarhan.start.Adapters.TelevisionListAdapter;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.TelevisionDAO;
import com.example.mohammedfarhan.start.Domains.home_appliances.Television;
import com.example.mohammedfarhan.start.R;

import java.util.ArrayList;

public class TelevisionListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Television> televisionArrayList;
    private TelevisionListAdapter televisionListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_television_list);

        recyclerView=(RecyclerView)findViewById(R.id.televisionListRv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        televisionArrayList =new TelevisionDAO(this).getAllTelevision();
        televisionListAdapter =new TelevisionListAdapter(this, televisionArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(televisionListAdapter);
    }
}
