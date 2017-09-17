package com.example.mohammedfarhan.start.Activities;

import android.content.Context;
import android.location.LocationManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.mohammedfarhan.start.Adapters.CyclesAdapter;
import com.example.mohammedfarhan.start.Adapters.FridgesAdapter;
import com.example.mohammedfarhan.start.Adapters.FurnituresAdapter;
import com.example.mohammedfarhan.start.Adapters.MobileAdapter;
import com.example.mohammedfarhan.start.Adapters.CarsAdapter;
import com.example.mohammedfarhan.start.Adapters.TelevisionAdapter;
import com.example.mohammedfarhan.start.Adapters.TwoWheelsAdapter;
import com.example.mohammedfarhan.start.Adapters.WashingMachineAdapter;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.FridgesDAO;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.FurnituresDAO;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.TelevisionDAO;
import com.example.mohammedfarhan.start.DAO.home_appliances_dao.WashingMachineDAO;
import com.example.mohammedfarhan.start.DAO.mobiles_dao.MobileDAO;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.CarsDAO;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.CyclesDAO;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.TwoWheelDAO;
import com.example.mohammedfarhan.start.Domains.home_appliances.Fridges;
import com.example.mohammedfarhan.start.Domains.home_appliances.Furnitures;
import com.example.mohammedfarhan.start.Domains.home_appliances.Television;
import com.example.mohammedfarhan.start.Domains.home_appliances.WashingMachine;
import com.example.mohammedfarhan.start.Domains.mobiles_domain.Mobile;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cars;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cycles;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.TwoWheel;
import com.example.mohammedfarhan.start.R;
import com.example.mohammedfarhan.start.fragments.AddsFragment;
import com.example.mohammedfarhan.start.fragments.MyAddsFragment;
import com.example.mohammedfarhan.start.fragments.MyChatsFragment;
import com.example.mohammedfarhan.start.fragments.MyProfileFragment;
import com.example.mohammedfarhan.start.fragments.SellFragment;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setIcon(R.drawable.adddds);
        tabLayout.getTabAt(1).setIcon(R.drawable.selladd);
        tabLayout.getTabAt(2).setIcon(R.drawable.myaddddds);
        tabLayout.getTabAt(3).setIcon(R.drawable.chat);
        tabLayout.getTabAt(4).setIcon(R.drawable.profileuser);


//        materialSpinner=(MaterialSpinner)findViewById(R.id.materialSpinner);
//        materialSpinner.setItems("Categories","All Categories","Mobiles","Cars","Two Wheelers","Four Wheelers");


    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AddsFragment(), "Adds");
        adapter.addFragment(new SellFragment(), "Sell");
        adapter.addFragment(new MyAddsFragment(), "My Adds");
        adapter.addFragment(new MyChatsFragment(), "Chats");
        adapter.addFragment(new MyProfileFragment(), "Profile");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
//        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
//        {
//            GpsAlertDialog();
//        }
//        else {
//            CheckGps();
//        }
//
//
//    }
//
//    private void GpsAlertDialog(){
//
//            AlertDialog.Builder locationAlert = new AlertDialog.Builder(this);
//            View view = getLayoutInflater().inflate(R.layout.location_alert, null);
//            locationAlert.setView(view);
//            locationAlert.setTitle("GPS is disabled");
//            locationAlert.setPositiveButton("Enable", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                    Intent gpsOptionsIntent = new Intent(
//                            Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                    startActivity(gpsOptionsIntent);
//                }
//            });
//            locationAlert.show();
//        }
//    public void CheckGps() {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                        != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
//                    MY_PERMISSIONS_REQUEST_LOCATION_GPS);
//        } else {
//            LocationListener locationListener = new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//                    latitude = location.getLatitude();
//                    longitude = location.getLongitude();
//                    double speed = location.getSpeed(); //spedd in meter/minute
//                    speed = (speed * 3600) / 1000;
//                    Log.d("location", String.valueOf(latitude) + "," + String.valueOf(longitude));
//                    String latlang = String.valueOf(latitude) + "," + String.valueOf(longitude);
//                    new geTadressFromLatLang().execute(latlang);
//                }
//
//                @Override
//                public void onStatusChanged(String s, int i, Bundle bundle) {
//
//                }
//
//                @Override
//                public void onProviderEnabled(String s) {
//
//                }
//
//                @Override
//                public void onProviderDisabled(String s) {
//
//                }
//            };
//
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30, 100000, locationListener);
//        }
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_LOCATION_GPS:
//
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // permission was granted, yay! Do the
//                    // contacts-related task you need to do.
//                    CheckGps();
//
//                } else {
//
//                }
//                break;
//
//        }
//    }
//
//    private class geTadressFromLatLang extends AsyncTask<String, String, String> {
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            String latlang = params[0];
//            URL url;
//            HttpURLConnection urlConnection = null;
//            try {
//                url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + latlang + "&sensor=true");
//                urlConnection = (HttpURLConnection) url.openConnection();
//
//                int responseCode = urlConnection.getResponseCode();
//
//                if (responseCode == HttpURLConnection.HTTP_OK) {
//                    server_response = readStream(urlConnection.getInputStream());
//
//                    if (server_response != null) {
//
//                        try {
//                            JSONObject respone = new JSONObject(server_response);
//                            JSONArray jsonarray = respone.getJSONArray("results");
//                            JSONObject jsonObject = jsonarray.getJSONObject(1);
//                            road = jsonObject.getString("formatted_address");
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    Log.v("locationresponse", server_response);
//                }
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            locationTV.setText(road);
//        }
//    }
//
//    private String readStream(InputStream in) {
//        BufferedReader reader = null;
//        StringBuffer response = new StringBuffer();
//        try {
//            reader = new BufferedReader(new InputStreamReader(in));
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return response.toString();
//    }
//
//}