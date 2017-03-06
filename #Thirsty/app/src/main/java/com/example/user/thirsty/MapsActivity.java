package com.example.user.thirsty;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Heather Song on 3/3/2017.
 * @author Heather Song
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final CameraPosition ATLANTA = new CameraPosition.Builder().target(new LatLng(33.4, -84.2))
            .zoom(5.5f)
            .bearing(0)
            .tilt(50)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * Creates markers according the sourceReportList
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng atlanta = new LatLng(33, -84);
        mMap.addMarker(new MarkerOptions().position(atlanta).title("Marker in Atlanta"));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(ATLANTA));
        Object[] list = WelcomeScreen.activeSourceReportList.printList();
        for (int i = 0; i < list.length; i++) {
            WaterSourceReport report = (WaterSourceReport) list[i];
            String entry;
            entry = "Location:(" + report.getLatitude() + ", " + report.getLongitude() + "). Water:"
                    + report.getWaterType() +  ",  " +report.getWaterCondition();
            LatLng location = new LatLng(report.getLatitude(), report.getLongitude());
            mMap.addMarker(new MarkerOptions().position(location).title(entry));
        }
    }
}
