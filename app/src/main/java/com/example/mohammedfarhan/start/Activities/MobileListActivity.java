package com.example.mohammedfarhan.start.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mohammedfarhan.start.Adapters.MobileListAdapter;
import com.example.mohammedfarhan.start.DAO.mobiles_dao.MobileDAO;
import com.example.mohammedfarhan.start.Domains.mobiles_domain.Mobile;
import com.example.mohammedfarhan.start.R;

import java.util.ArrayList;

public class MobileListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Mobile> mobileArrayList;
    private MobileListAdapter mobileListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_list);

        recyclerView=(RecyclerView)findViewById(R.id.mobileListRv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        mobileArrayList =new MobileDAO(this).getAllMobile();
        mobileListAdapter =new MobileListAdapter(this, mobileArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mobileListAdapter);
    }
}
