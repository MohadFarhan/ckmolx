package com.example.mohammedfarhan.start.DAO.home_appliances_dao;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import android.content.Context;
import android.util.Log;

import com.example.mohammedfarhan.start.Domains.home_appliances.Television;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelevisionDAO {

    public static final String COL_ID = "Id";
    public static final String COL_TwoWheeler = "Television";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "TwoWheelers";

    DataBaseHelper dbHelper;
    Context context;

    public TelevisionDAO(Context context) {
        this.context = context;
    }


    public ArrayList<Television> getAllTelevision() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Television, Long> TwoWheelerDAO = dbHelper.getTelevisionDao();
            List<Television> Television = TwoWheelerDAO.queryForAll();
            ArrayList<Television> carsList = new ArrayList<>();
            carsList.addAll(Television);
            return carsList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public Television addUser(Television userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Television, Long> TwoWheelerDAO = dbHelper.getTelevisionDao();
            TwoWheelerDAO.createOrUpdate(userObj);
            Television addTwoWheelers = TwoWheelerDAO.queryForId(Long.valueOf(userObj.getId()));
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
            Dao<Television, Long> TwoWheelerDAO = (Dao<Television, Long>) dbHelper.getTelevisionDao();
            long number = TwoWheelerDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

