package com.example.mohammedfarhan.start.DAO.vehicles_dao;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import android.content.Context;
import android.util.Log;

import com.example.mohammedfarhan.start.Domains.vehicles_domain.TwoWheel;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TwoWheelDAO {

    public static final String COL_ID = "Id";
    public static final String COL_TwoWheeler = "TwoWheel";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "TwoWheelers";

    DataBaseHelper dbHelper;
    Context context;

    public TwoWheelDAO(Context context) {
        this.context = context;
    }


    public ArrayList<TwoWheel> getAllTwoWheeler() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<TwoWheel, Long> TwoWheelerDAO = dbHelper.getTwoWheelDao();
            List<TwoWheel> TwoWheel = TwoWheelerDAO.queryForAll();
            ArrayList<TwoWheel> carsList = new ArrayList<>();
            carsList.addAll(TwoWheel);
            return carsList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public TwoWheel addUser(TwoWheel userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<TwoWheel, Long> TwoWheelerDAO = dbHelper.getTwoWheelDao();
            TwoWheelerDAO.createOrUpdate(userObj);
            TwoWheel addTwoWheelers = TwoWheelerDAO.queryForId(Long.valueOf(userObj.getId()));
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
            Dao<TwoWheel, Long> TwoWheelerDAO = (Dao<TwoWheel, Long>) dbHelper.getTwoWheelDao();
            long number = TwoWheelerDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

