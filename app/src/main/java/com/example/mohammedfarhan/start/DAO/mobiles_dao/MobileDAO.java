package com.example.mohammedfarhan.start.DAO.mobiles_dao;

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

import com.example.mohammedfarhan.start.Domains.mobiles_domain.Mobile;
import com.example.mohammedfarhan.start.Utils.DataBaseHelper;

public class MobileDAO {

    public static final String COL_ID = "Id";
    public static final String COL_Data = "Mobile";
    public static final String COL_DATE = "Date";
    public static final String COL_IMAGE = "Image";
    public static final String COL_VIDEO = "Video";
    public static final String TABLE_NAME = "Datas";

    DataBaseHelper dbHelper;
    Context context;

    public MobileDAO(Context context) {
        this.context = context;
    }


    public ArrayList<Mobile> getAllMobile() {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Mobile, Long> DataDAO = dbHelper.getMobileDAO();
            List<Mobile> Mobile = DataDAO.queryForAll();
            ArrayList<Mobile> mobileList = new ArrayList<>();
            mobileList.addAll(Mobile);
            return mobileList;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }


    public Mobile getMobileById(long userId) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Mobile, Long> mobileDAO = dbHelper.getMobileDAO();
            Mobile mobile = mobileDAO.queryForId(userId);
            OpenHelperManager.releaseHelper();
            return mobile;
        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return null;
        }
    }

    public Mobile addUser(Mobile userObj) {
        try {
            dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            Dao<Mobile, Long> DataDAO = dbHelper.getMobileDAO();
            DataDAO.createOrUpdate(userObj);
            Mobile addDatas = DataDAO.queryForId(Long.valueOf(userObj.getId()));
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
            Dao<Mobile, Long> DataDAO = (Dao<Mobile, Long>) dbHelper.getMobileDAO();
            long number = DataDAO.countOf();
            OpenHelperManager.releaseHelper();
            return number;

        } catch (SQLException e) {
            Log.e("nk", Log.getStackTraceString(e));
            return Long.parseLong(null);
        }
    }


}

