package com.example.mohammedfarhan.start.DAO.home_appliances_dao;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import android.content.Context;
import android.util.Log;

import com.example.mohammedfarhan.start.Domains.home_appliances.Fridges;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FridgesDAO {

    public static final String COL_ID = "Id";
    public static final String COL_TwoWheeler = "Fridges";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "TwoWheelers";

    DataBaseHelper dbHelper;
    Context context;

    public FridgesDAO(Context context) {
        this.context = context;
    }


    public ArrayList<Fridges> getAllFridges() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Fridges, Long> TwoWheelerDAO = dbHelper.getFridgeDao();
            List<Fridges> Fridges = TwoWheelerDAO.queryForAll();
            ArrayList<Fridges> carsList = new ArrayList<>();
            carsList.addAll(Fridges);
            return carsList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public Fridges addUser(Fridges userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Fridges, Long> TwoWheelerDAO = dbHelper.getFridgeDao();
            TwoWheelerDAO.createOrUpdate(userObj);
            Fridges addTwoWheelers = TwoWheelerDAO.queryForId(Long.valueOf(userObj.getId()));
            OpenHelperManager.releaseHelper();
            return addTwoWheelers;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }

    public long getTwoWheelerCount() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Fridges, Long> TwoWheelerDAO = (Dao<Fridges, Long>) dbHelper.getFridgeDao();
            long number = TwoWheelerDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

