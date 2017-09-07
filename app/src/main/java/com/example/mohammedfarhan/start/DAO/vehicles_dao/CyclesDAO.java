package com.example.mohammedfarhan.start.DAO.vehicles_dao;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import android.content.Context;
import android.util.Log;

import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cycles;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CyclesDAO {

    public static final String COL_ID = "Id";
    public static final String COL_TwoWheeler = "Cycles";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "TwoWheelers";

    DataBaseHelper dbHelper;
    Context context;

    public CyclesDAO(Context context) {
        this.context = context;
    }


    public ArrayList<Cycles> getAllTwoWheeler() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Cycles, Long> TwoWheelerDAO = dbHelper.getCycleDao();
            List<Cycles> Cycles = TwoWheelerDAO.queryForAll();
            ArrayList<Cycles> carsList = new ArrayList<>();
            carsList.addAll(Cycles);
            return carsList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public Cycles addUser(Cycles userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Cycles, Long> TwoWheelerDAO = dbHelper.getCycleDao();
            TwoWheelerDAO.createOrUpdate(userObj);
            Cycles addTwoWheelers = TwoWheelerDAO.queryForId(Long.valueOf(userObj.getId()));
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
            Dao<Cycles, Long> TwoWheelerDAO = (Dao<Cycles, Long>) dbHelper.getCycleDao();
            long number = TwoWheelerDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

