package com.example.mohammedfarhan.start.DAO;

/**
 * Created by Mohammed Farhan on 22-07-2017.
 */


import android.content.Context;
import android.util.Log;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.mohammedfarhan.start.Domains.Data;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;

public class DataDAO {

    public static final String COL_ID = "Id";
    public static final String COL_Data = "Data";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "Datas";

    DataBaseHelper dbHelper;
    Context context;

    public DataDAO(Context context) {
        this.context = context;
    }


    public ArrayList<Data> getAllData() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Data, Long> DataDAO = dbHelper.getDataDAO();
            List<Data> Data = DataDAO.queryForAll();
            ArrayList<Data> DataList = new ArrayList<>();
            DataList.addAll(Data);
            return DataList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public Data addUser(Data userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Data, Long> DataDAO = dbHelper.getDataDAO();
            DataDAO.createOrUpdate(userObj);
            Data addDatas = DataDAO.queryForId(Long.valueOf(userObj.getId()));
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
            Dao<Data, Long> DataDAO = (Dao<Data, Long>) dbHelper.getDataDAO();
            long number = DataDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

