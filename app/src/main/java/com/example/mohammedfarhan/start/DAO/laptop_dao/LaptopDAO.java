package com.example.mohammedfarhan.start.DAO.laptop_dao;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import android.content.Context;
import android.util.Log;

import com.example.mohammedfarhan.start.Domains.laptop_domain.Laptop;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAO {

    public static final String COL_ID = "Id";
    public static final String COL_Data = "Laptop";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "Datas";

    DataBaseHelper dbHelper;
    Context context;

    public LaptopDAO(Context context) {
        this.context = context;
    }


    public ArrayList<Laptop> getAllLaptop() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Laptop, Long> DataDAO = dbHelper.getLaptopDao();
            List<Laptop> Laptop = DataDAO.queryForAll();
            ArrayList<Laptop> mobileList = new ArrayList<>();
            mobileList.addAll(Laptop);
            return mobileList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public Laptop getLaptopById(long userId) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Laptop, Long> mobileDAO = dbHelper.getLaptopDao();
            Laptop mobile = mobileDAO.queryForId(userId);
            OpenHelperManager.releaseHelper();
            return mobile;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }

    public Laptop addUser(Laptop userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Laptop, Long> DataDAO = dbHelper.getLaptopDao();
            DataDAO.createOrUpdate(userObj);
            Laptop addDatas = DataDAO.queryForId(Long.valueOf(userObj.getId()));
            OpenHelperManager.releaseHelper();
            return addDatas;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }

    public long getDataCount() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Laptop, Long> DataDAO = (Dao<Laptop, Long>) dbHelper.getLaptopDao();
            long number = DataDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

