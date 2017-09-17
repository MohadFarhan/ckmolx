package com.example.mohammedfarhan.start.DAO.home_appliances_dao;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import android.content.Context;
import android.util.Log;

import com.example.mohammedfarhan.start.Domains.home_appliances.Furnitures;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FurnituresDAO {

    public static final String COL_ID = "Id";
    public static final String COL_TwoWheeler = "Furnitures";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "TwoWheelers";

    DataBaseHelper dbHelper;
    Context context;

    public FurnituresDAO(Context context) {
        this.context = context;
    }


    public ArrayList<Furnitures> getAllFurnitures() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Furnitures, Long> TwoWheelerDAO = dbHelper.getFurnitureDao();
            List<Furnitures> Furnitures = TwoWheelerDAO.queryForAll();
            ArrayList<Furnitures> carsList = new ArrayList<>();
            carsList.addAll(Furnitures);
            return carsList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public Furnitures addUser(Furnitures userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Furnitures, Long> TwoWheelerDAO = dbHelper.getFurnitureDao();
            TwoWheelerDAO.createOrUpdate(userObj);
            Furnitures addTwoWheelers = TwoWheelerDAO.queryForId(Long.valueOf(userObj.getId()));
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
            Dao<Furnitures, Long> TwoWheelerDAO = (Dao<Furnitures, Long>) dbHelper.getFurnitureDao();
            long number = TwoWheelerDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

