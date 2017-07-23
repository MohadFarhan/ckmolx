package com.example.mohammedfarhan.start.DAO;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import android.content.Context;
import android.util.Log;

import com.example.mohammedfarhan.start.Domains.TwoWheeler;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TwoWheelerDAO {

    public static final String COL_ID = "Id";
    public static final String COL_TwoWheeler = "TwoWheeler";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "TwoWheelers";

    DataBaseHelper dbHelper;
    Context context;

    public TwoWheelerDAO(Context context) {
        this.context = context;
    }


    public ArrayList<TwoWheeler> getAllTwoWheeler() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<TwoWheeler, Long> TwoWheelerDAO = dbHelper.getTwoWheelerDAO();
            List<TwoWheeler> TwoWheeler = TwoWheelerDAO.queryForAll();
            ArrayList<TwoWheeler> TwoWheelerList = new ArrayList<>();
            TwoWheelerList.addAll(TwoWheeler);
            return TwoWheelerList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public TwoWheeler addUser(TwoWheeler userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<TwoWheeler, Long> TwoWheelerDAO = dbHelper.getTwoWheelerDAO();
            TwoWheelerDAO.createOrUpdate(userObj);
            TwoWheeler addTwoWheelers = TwoWheelerDAO.queryForId(Long.valueOf(userObj.getId()));
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
            Dao<TwoWheeler, Long> TwoWheelerDAO = (Dao<TwoWheeler, Long>) dbHelper.getTwoWheelerDAO();
            long number = TwoWheelerDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

