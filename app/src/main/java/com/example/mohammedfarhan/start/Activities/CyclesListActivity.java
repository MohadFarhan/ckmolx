package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mohammedfarhan.start.Adapters.CyclesListAdapter;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.CyclesDAO;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cycles;
import com.example.mohammedfarhan.start.R;

import java.util.ArrayList;

public class CyclesListActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    CyclesListAdapter cyclesListAdapter;
    ArrayList<Cycles> carsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycles_list);

        recyclerView=(RecyclerView)findViewById(R.id.cyclesListRv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        carsArrayList =new CyclesDAO(this).getAllCycles();
        cyclesListAdapter =new CyclesListAdapter(this, carsArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(cyclesListAdapter);

    }
}
