package com.example.mohammedfarhan.start.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mohammedfarhan.start.Domains.laptop_domain.Laptop;
import com.example.mohammedfarhan.start.Domains.mobiles_domain.Mobile;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cars;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cycles;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.TwoWheel;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {
    public static final String DATABASE_PATH = "/data/data/com.example.mohammedfarhan.start/databases/";
    private static final String DATABASE_NAME = "ckm_db.db";
    private static final int DATABASE_VERSION = 1;

	private static Dao<Mobile,Long> mobileDAO =null;
	private static Dao<Cars,Long> carsDao =null;
    private static Dao<TwoWheel,Long> twoWheelDao =null;
    private static Dao<Cycles,Long> cycleDao =null;
    private static Dao<Laptop,Long> laptopDao =null;


    public DataBaseHelper(Context context) {
        super(context, DATABASE_PATH + DATABASE_NAME, null, DATABASE_VERSION);

        boolean dbexist = checkDatabase();
        if (!dbexist) {
            // If database did not exist, try copying existing database from assets folder.
            try {
                File dir = new File(DATABASE_PATH);
                dir.mkdirs();
                InputStream myInput = context.getAssets().open(DATABASE_NAME);
                String outFileName = DATABASE_PATH + DATABASE_NAME;
                Log.i(DataBaseHelper.class.getName(), "DB Path : " + outFileName);
                OutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        // Enable foreign key constraints
        if (!db.isReadOnly()) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            //update database version 1 to 2
            //	changesOfVersion2(connectionSource);
        }

    }

	/*private void changesOfVersion2(ConnectionSource connectionSource)
    {
		Log.d("nk", "Changes of Version 2");
		Dao<Act, Long> dao = getActDao();
		try
		{
			dao.executeRaw("ALTER TABLE 'person_of_interest' ADD COLUMN father_name varchar(50) DEFAULT 'NA';");
			TableUtils.createTableIfNotExists(connectionSource, Arrest.class);
			Log.d("nk", "V2 Changes Done");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}*/


/*	public void export()
	{
		String myPath = DATABASE_PATH + DATABASE_NAME;
		File dbFile = new File(myPath);
		if (dbFile.exists())
		{
			String ext = ".db";
			String fileName = dbFile.getName() + ext;

			File destination = new File(App.getAppDir() + fileName);
			try
			{
				File source = dbFile;
				FileChannel src = new FileInputStream(source).getChannel();
				FileChannel dst = new FileOutputStream(destination).getChannel();
				dst.transferFrom(src, 0, src.size());
				src.close();
				dst.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}*/


    /*
    * Check whether or not database exist
    */
    private boolean checkDatabase() {
        boolean checkDb = false;

        String myPath = DATABASE_PATH + DATABASE_NAME;
        File dbFile = new File(myPath);
        checkDb = dbFile.exists();

        Log.i(DataBaseHelper.class.getName(), "DB Exist : " + checkDb);

        return checkDb;
    }


	public Dao<Mobile, Long> getMobileDAO() throws SQLException{

		try
		{
			if (mobileDAO == null)
			{
                mobileDAO = DaoManager.createDao(connectionSource, Mobile.class);
			}
	}catch (SQLException e)
		{
		e.printStackTrace();		}
	return mobileDAO;
	}


    public Dao<Cars, Long> getCarsDao() throws SQLException{

        try
        {
            if (carsDao == null)
            {
                carsDao = DaoManager.createDao(connectionSource, Cars.class);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();		}
        return carsDao;
    }

    public Dao<TwoWheel, Long> getTwoWheelDao() throws SQLException{

        try
        {
            if (twoWheelDao == null)
            {
                twoWheelDao = DaoManager.createDao(connectionSource, TwoWheel.class);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return twoWheelDao;
    }


    public Dao<Cycles, Long> getCycleDao() throws SQLException{

        try
        {
            if (cycleDao == null)
            {
                cycleDao = DaoManager.createDao(connectionSource, Cycles.class);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return cycleDao;
    }


    public Dao<Laptop, Long> getLaptopDao() throws SQLException{

        try
        {
            if (laptopDao == null)
            {
                laptopDao = DaoManager.createDao(connectionSource, Laptop.class);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return laptopDao;
    }
//	public Dao<PersonOfInterest, Long> getPOIDao() throws SQLException
//	{
//		try
//		{
//			if (poiDao == null)
//			{
//				poiDao = DaoManager.createDao(connectionSource, PersonOfInterest.class);
//			}
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return poiDao;
//	}
//
//	public Dao<State, Long> getStateDao() throws SQLException
//	{
//		try
//		{
//			if (stateDao == null)
//			{
//				stateDao = DaoManager.createDao(connectionSource, State.class);
//			}
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return stateDao;
//	}
//
//	public Dao<District, Long> getDistrictDao() throws SQLException
//	{
//		try
//		{
//			if (districtDao == null)
//			{
//				districtDao = DaoManager.createDao(connectionSource, District.class);
//			}
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return districtDao;
//	}
//
//	public Dao<PoliceStation, Long> getPoliceStationDao() throws SQLException
//	{
//		try
//		{
//			if (policeStationDao == null)
//			{
//				policeStationDao = DaoManager.createDao(connectionSource, PoliceStation.class);
//			}
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return policeStationDao;
//	}
//
//	public Dao<SubDivision, Long> getSubDivisionDao() throws SQLException
//	{
//		if (subDivisionDao == null)
//		{
//			subDivisionDao = DaoManager.createDao(connectionSource, SubDivision.class);
//		}
//		return subDivisionDao;
//	}
//
//	public Dao<Circle, Long> getCircleDao() throws SQLException
//	{
//		if (circleDao == null)
//		{
//			circleDao = DaoManager.createDao(connectionSource, Circle.class);
//		}
//		return circleDao;
//	}
//
//	public Dao<Auth, Long> getAuthDao() throws SQLException
//	{
//		if (authDao == null)
//		{
//			authDao = DaoManager.createDao(connectionSource, Auth.class);
//		}
//		return authDao;
//	}
//
//	public Dao<Role, Long> getRoleDao() throws SQLException
//	{
//		if (roleDao == null)
//		{
//			roleDao = DaoManager.createDao(connectionSource, Role.class);
//		}
//		return roleDao;
//	}
//
//	public Dao<PoliceRank, Long> getPoliceRankDao() throws SQLException
//	{
//		if (policeRankDao == null)
//		{
//			policeRankDao = DaoManager.createDao(connectionSource, PoliceRank.class);
//		}
//		return policeRankDao;
//	}
//
//	public Dao<User, Long> getUserDao() throws SQLException
//	{
//		if (userDao == null)
//		{
//			userDao = DaoManager.createDao(connectionSource, User.class);
//		}
//		return userDao;
//	}

}
