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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

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
        WelcomeScreen.sourceDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                WelcomeScreen.activeSourceReportList.clearList();
                for (DataSnapshot puritySnapShot : dataSnapshot.getChildren()) {
                    //int reportNumber = Integer.parseInt(puritySnapShot.getKey());
                    float lat = Float.parseFloat(puritySnapShot.child("latitude").getValue().toString());
                    float longi = Float.parseFloat(puritySnapShot.child("longitude").getValue().toString());
                    String waterType = (String) puritySnapShot.child("waterType").getValue();
                    String waterCondition = (String) puritySnapShot.child("waterCondition").getValue();
                    String reporter = (String) puritySnapShot.child("reporter").getValue();
                    WelcomeScreen.activeSourceReportList.addReport(new WaterSourceReport(lat, longi, waterType, waterCondition, reporter));
                }
                //Log.d("val", users.ge))
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        mMap = googleMap;
        LatLng atlanta = new LatLng(33, -84);
        //mMap.addMarker(new MarkerOptions().position(atlanta).title("Marker in Atlanta"));
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
