package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mohammedfarhan.start.Adapters.MobileListAdapter;
import com.example.mohammedfarhan.start.Adapters.WashingMachineAdapter;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.WashingMachineDAO;
import com.example.mohammedfarhan.start.Domains.home_appliances.WashingMachine;
import com.example.mohammedfarhan.start.R;

import java.util.ArrayList;

public class WashingMachineListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<WashingMachine> washingMachineArrayList;
    private WashingMachineAdapter mobileListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washing_machine_list);


        recyclerView=(RecyclerView)findViewById(R.id.washingMachinListeRv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        washingMachineArrayList =new WashingMachineDAO(this).getAllWashingMachine();
        mobileListAdapter =new WashingMachineAdapter(this, washingMachineArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mobileListAdapter);
    }
}
