package com.example.mohammedfarhan.start.Activities;

import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.mohammedfarhan.start.Adapters.MobileAdapter;
import com.example.mohammedfarhan.start.Adapters.CarsAdapter;
import com.example.mohammedfarhan.start.Adapters.TwoWheelsAdapter;
import com.example.mohammedfarhan.start.DAO.mobiles_dao.MobileDAO;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.CarsDAO;
import com.example.mohammedfarhan.start.DAO.vehicles_dao.TwoWheelDAO;
import com.example.mohammedfarhan.start.Domains.mobiles_domain.Mobile;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.Cars;
import com.example.mohammedfarhan.start.Domains.vehicles_domain.TwoWheel;
import com.example.mohammedfarhan.start.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class MainActivity extends AppCompatActivity {


    public TextView locationTV;
    public ImageView gpsIconIMV;
    ArrayList<Mobile> mdata;
    ArrayList<Cars> carsArrayList;
    ArrayList<TwoWheel> mtwowheeler;
    Mobile mobile;

    CarsAdapter carsAdapter;
    public LocationManager locationManager;
    String server_response;
    public Animation animation;

    public Double latitude, longitude;
    RecyclerView mobileRecyclerView, carRecylerView,twoWheelRecyclerView;

    String road;
    LinearLayoutManager mLayoutManager;

    MaterialSpinner materialSpinner;
    public final int MY_PERMISSIONS_REQUEST_LOCATION_GPS = 1;

    String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        mdata=new MobileDAO(MainActivity.this).getAllMobile();
        MobileAdapter mobileAdapter =new MobileAdapter(this,mdata);

        mobileRecyclerView = (RecyclerView) findViewById(R.id.mobilesrv);
        mobileRecyclerView.setHasFixedSize(true);
        mobileRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mobileRecyclerView.smoothScrollToPosition(1);
        mobileRecyclerView.setAdapter(mobileAdapter);


        carsArrayList =new CarsDAO(MainActivity.this).getAllTwoWheeler();
        carsAdapter =new CarsAdapter(MainActivity.this, carsArrayList);
        carRecylerView =(RecyclerView)findViewById(R.id.carsRV);
        carRecylerView.setHasFixedSize(true);
        carRecylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        carRecylerView.setAdapter(carsAdapter);


        mtwowheeler=new TwoWheelDAO(this).getAllTwoWheeler();

        twoWheelRecyclerView = (RecyclerView) findViewById(R.id.twoWheelRV);
        twoWheelRecyclerView.setHasFixedSize(true);
        twoWheelRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        twoWheelRecyclerView.smoothScrollToPosition(1);
        TwoWheelsAdapter twoWheelsAdapter=new TwoWheelsAdapter(this,mtwowheeler);
        twoWheelRecyclerView.setAdapter(twoWheelsAdapter);

//        materialSpinner=(MaterialSpinner)findViewById(R.id.materialSpinner);
//        materialSpinner.setItems("Categories","All Categories","Mobiles","Cars","Two Wheelers","Four Wheelers");


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