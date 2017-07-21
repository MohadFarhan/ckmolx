package Network;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.example.mohammedfarhan.start.MainActivity;

/**
 * Created by Mohammed Farhan on 21-07-2017.
 */

public class GPS {
    Context context;


    public GPS(Context context){
        this.context=context;
    }

    public boolean CheckLocationGPS() {

        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(context, "Enable GPS", Toast.LENGTH_SHORT).show();

        } else {

            LocationListener locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    double speed = location.getSpeed(); //spedd in meter/minute
                    speed = (speed * 3600) / 1000;
                    Toast.makeText(context,
                            "" + latitude + "," + longitude, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            };
        }
return true;
    }
}

