package com.example.androidstudy;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

public class ReadLocationActivity extends Activity {
    LocationManager mLocMan;
    TextView mStatus;
    TextView mResult;
    String mProvider;
    int mCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readlocation);

        mLocMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        mStatus = findViewById(R.id.status);
        mResult = findViewById(R.id.result);
        mProvider = mLocMan.getBestProvider(new Criteria(), true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCount = 0;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocMan.requestLocationUpdates(mProvider, 3000, 10, mListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocMan.removeUpdates(mListener);
        mStatus.setText("?????? ?????? : ????????? ??????");
    }
    LocationListener mListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            mCount++;
            String sloc = String.format("???????????? : %d \n ?????? :%f\n ?????? : %f\n ??????:%f",mCount,location.getLatitude(),location.getAltitude());
            mResult.setText(sloc);
        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {
            mStatus.setText("?????? ?????? : ????????? ?????? ??????");
        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {
            mStatus.setText("?????? ?????? : ????????? ?????? ??????");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
//            String sStatus = "";
//            switch (status) {
//                case Location
//            }
        }

    };
}
