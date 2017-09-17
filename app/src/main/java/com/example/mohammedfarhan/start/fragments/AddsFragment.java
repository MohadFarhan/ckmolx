package com.example.mohammedfarhan.start.fragments;


import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammedfarhan.start.Activities.CarsListActivity;
import com.example.mohammedfarhan.start.Activities.CyclesListActivity;
import com.example.mohammedfarhan.start.Activities.FridgesListActivity;
import com.example.mohammedfarhan.start.Activities.FurnitureListActivity;
import com.example.mohammedfarhan.start.Activities.TelevisionListActivity;
import com.example.mohammedfarhan.start.Activities.TwoWheelsListActivity;
import com.example.mohammedfarhan.start.Activities.WashingMachineListActivity;
import com.example.mohammedfarhan.start.Adapters.CarsAdapter;
import com.example.mohammedfarhan.start.Adapters.CyclesAdapter;
import com.example.mohammedfarhan.start.Adapters.FridgesAdapter;
import com.example.mohammedfarhan.start.Adapters.FurnituresAdapter;
import com.example.mohammedfarhan.start.Adapters.MobileAdapter;
import com.example.mohammedfarhan.start.Adapters.TelevisionAdapter;
import com.example.mohammedfarhan.start.Adapters.TwoWheelsAdapter;
import com.example.mohammedfarhan.start.Adapters.WashingMachineAdapter;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.FridgesDAO;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.FurnituresDAO;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.TelevisionDAO;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.WashingMachineDAO;
import com.example.mohammedfarhan.start.DAO.mobiles_dao.MobileDAO;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.CarsDAO;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.CyclesDAO;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.TwoWheelDAO;
import com.example.mohammedfarhan.start.Domains.home_appliances.Fridges;
import com.example.mohammedfarhan.start.Domains.home_appliances.Furnitures;
import com.example.mohammedfarhan.start.Domains.home_appliances.Television;
import com.example.mohammedfarhan.start.Domains.home_appliances.WashingMachine;
import com.example.mohammedfarhan.start.Domains.mobiles_domain.Mobile;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cars;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cycles;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.TwoWheel;
import com.example.mohammedfarhan.start.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddsFragment extends Fragment {


    public AddsFragment() {
        // Required empty public constructor
    }

    public TextView locationTV;
    public ImageView gpsIconIMV;
    ArrayList<Mobile> mdata;
    ArrayList<Cars> carsArrayList;
    ArrayList<TwoWheel> mtwowheeler;
    ArrayList<Cycles> mcyles;
    ArrayList<Television> televisions;
    ArrayList<Fridges> fridges;
    ArrayList<Furnitures> furnitures;
    ArrayList<WashingMachine> washingMachines;
    Mobile mobile;

    CarsAdapter carsAdapter;
    CyclesAdapter cyclesAdapter;
    TelevisionAdapter televisionAdapter;
    FurnituresAdapter furnituresAdapter;
    FridgesAdapter fridgesAdapter;
    WashingMachineAdapter washingMachineAdapter;
    public LocationManager locationManager;
    String server_response;
    public Animation animation;

    public Double latitude, longitude;
    RecyclerView mobileRecyclerView, carRecylerView, twoWheelRecyclerView, cyclesRecyclerView, televisionRecyclerView, furnituresRecyclerView,
            fridgesRecyclerView, washingMachineRecyclerView;

    String road;
    LinearLayoutManager mLayoutManager;

    MaterialSpinner materialSpinner;
    public final int MY_PERMISSIONS_REQUEST_LOCATION_GPS = 1;
    public TextView moreCarsTV, moreTwoWheelersTV, moreCyclesTV, moreTelevisionTV, moreFridgesTV, moreWashingMachineTV, moreFurnitureTV;

    String selectedCategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for getActivity() fragment
        View view = inflater.inflate(R.layout.fragment_adds, container, false);

        moreCarsTV = (TextView) view.findViewById(R.id.moreCarsTV);
        moreTwoWheelersTV = (TextView) view.findViewById(R.id.moreTwoWheelersCategory);
        moreCyclesTV = (TextView) view.findViewById(R.id.moreCyclesTV);
        moreTelevisionTV = (TextView) view.findViewById(R.id.moreTelevesionCategory);
        moreFridgesTV = (TextView) view.findViewById(R.id.moreFridgesTV);
        moreWashingMachineTV = (TextView) view.findViewById(R.id.morewashingMachineTV);
        moreFurnitureTV = (TextView) view.findViewById(R.id.moreFurnituresTV);


        moreCarsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), CarsListActivity.class));
            }
        });
        moreTwoWheelersTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), TwoWheelsListActivity.class));
            }
        });

        moreCyclesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), CyclesListActivity.class));
            }
        });

        moreTelevisionTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), TelevisionListActivity.class));
            }
        });

        moreFridgesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), FridgesListActivity.class));
            }
        });

        moreWashingMachineTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), WashingMachineListActivity.class));
            }
        });

        moreFurnitureTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), FurnitureListActivity.class));
            }
        });

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        mdata = new MobileDAO(getActivity()).getAllMobile();
        MobileAdapter mobileAdapter = new MobileAdapter(getActivity(), mdata);

        mobileRecyclerView = (RecyclerView) view.findViewById(R.id.mobilesrv);
        mobileRecyclerView.setHasFixedSize(true);
        mobileRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mobileRecyclerView.smoothScrollToPosition(1);
        mobileRecyclerView.setAdapter(mobileAdapter);


        carsArrayList = new CarsDAO(getActivity()).getAllCars();
        carsAdapter = new CarsAdapter(getActivity(), carsArrayList);
        carRecylerView = (RecyclerView) view.findViewById(R.id.carsRV);
        carRecylerView.setHasFixedSize(true);
        carRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        carRecylerView.setAdapter(carsAdapter);


        mtwowheeler = new TwoWheelDAO(getActivity()).getAllTwoWheeler();

        twoWheelRecyclerView = (RecyclerView) view.findViewById(R.id.twoWheelRV);
        twoWheelRecyclerView.setHasFixedSize(true);
        twoWheelRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        twoWheelRecyclerView.smoothScrollToPosition(1);
        TwoWheelsAdapter twoWheelsAdapter = new TwoWheelsAdapter(getActivity(), mtwowheeler);
        twoWheelRecyclerView.setAdapter(twoWheelsAdapter);


        mcyles = new CyclesDAO(getActivity()).getAllCycles();
        cyclesRecyclerView = (RecyclerView) view.findViewById(R.id.cyclesRV);
        cyclesRecyclerView.setHasFixedSize(true);
        cyclesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        twoWheelRecyclerView.smoothScrollToPosition(1);
        cyclesAdapter = new CyclesAdapter(getActivity(), mcyles);
        cyclesRecyclerView.setAdapter(cyclesAdapter);

        televisions = new TelevisionDAO(getActivity()).getAllTelevision();
        televisionRecyclerView = (RecyclerView) view.findViewById(R.id.tvRV);
        televisionRecyclerView.setHasFixedSize(true);
        televisionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        televisionRecyclerView.smoothScrollToPosition(1);
        televisionAdapter = new TelevisionAdapter(getActivity(), televisions);
        televisionRecyclerView.setAdapter(televisionAdapter);


        fridges = new FridgesDAO(getActivity()).getAllFridges();
        fridgesRecyclerView = (RecyclerView) view.findViewById(R.id.fridgesRV);
        fridgesRecyclerView.setHasFixedSize(true);
        fridgesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        fridgesRecyclerView.smoothScrollToPosition(1);
        fridgesAdapter = new FridgesAdapter(getActivity(), fridges);
        fridgesRecyclerView.setAdapter(fridgesAdapter);

        washingMachines = new WashingMachineDAO(getActivity()).getAllWashingMachine();
        washingMachineRecyclerView = (RecyclerView) view.findViewById(R.id.washingMachineRV);
        washingMachineRecyclerView.setHasFixedSize(true);
        washingMachineRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        washingMachineRecyclerView.smoothScrollToPosition(1);
        washingMachineAdapter = new WashingMachineAdapter(getActivity(), washingMachines);
        washingMachineRecyclerView.setAdapter(washingMachineAdapter);


        furnitures = new FurnituresDAO(getActivity()).getAllFurnitures();
        furnituresRecyclerView = (RecyclerView) view.findViewById(R.id.furnituresRV);
        furnituresRecyclerView.setHasFixedSize(true);
        furnituresRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        furnituresRecyclerView.smoothScrollToPosition(1);
        furnituresAdapter = new FurnituresAdapter(getActivity(), furnitures);
        furnituresRecyclerView.setAdapter(furnituresAdapter);


        return view;
    }

}
