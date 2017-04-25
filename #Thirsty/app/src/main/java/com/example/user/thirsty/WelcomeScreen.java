package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */

public class WelcomeScreen extends AppCompatActivity {
    //Database testing



    public static UserDataBase users = new UserDataBase();
    public static WaterSourceReportList activeSourceReportList = new WaterSourceReportList();
    public static WaterPurityReportList activePurityReportList = new WaterPurityReportList();

    public static DatabaseReference rootReference = FirebaseDatabase.getInstance().getReference();
    public static DatabaseReference userDB = rootReference.child("User Accounts");
    public static DatabaseReference purityDB = rootReference.child("Water Purity");
    public static DatabaseReference sourceDB = rootReference.child("Water Source");



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        userDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                users.verifyDB();
                for (DataSnapshot userSnapShot : dataSnapshot.getChildren()) {
                    String userName = (String) userSnapShot.getKey();
                    String userType = (String) userSnapShot.child("userType").getValue();
                    String salt = (String) userSnapShot.child("salt").getValue();
                    String pass = (String) userSnapShot.child("password").getValue();
                    String email = (String) userSnapShot.child("email").getValue();
                    boolean accStatus = (boolean) userSnapShot.child("accountStatus").getValue();
                    users.createUser(userName, pass, email, userType, salt, accStatus);
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

        purityDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                activePurityReportList.clearList();
                for (DataSnapshot puritySnapShot : dataSnapshot.getChildren()) {
                    //int reportNumber = Integer.parseInt(puritySnapShot.getKey());
                    float contaminant = Float.parseFloat(puritySnapShot.child("contaminantPPM").getValue().toString());
                    float virus = Float.parseFloat(puritySnapShot.child("virusPPM").getValue().toString());
                    float lat = Float.parseFloat(puritySnapShot.child("latitude").getValue().toString());
                    float longi = Float.parseFloat(puritySnapShot.child("longitude").getValue().toString());
                    String overall = (String) puritySnapShot.child("overallCondition").getValue();
                    String reporter = (String) puritySnapShot.child("reporter").getValue();
                    activePurityReportList.addReport(new WaterPurityReport(virus, contaminant, lat, longi, overall, reporter));
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

        sourceDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                activeSourceReportList.clearList();
                for (DataSnapshot puritySnapShot : dataSnapshot.getChildren()) {
                    //int reportNumber = Integer.parseInt(puritySnapShot.getKey());
                    float lat = Float.parseFloat(puritySnapShot.child("latitude").getValue().toString());
                    float longi = Float.parseFloat(puritySnapShot.child("longitude").getValue().toString());
                    String waterType = (String) puritySnapShot.child("waterType").getValue();
                    String waterCondition = (String) puritySnapShot.child("waterCondition").getValue();
                    String reporter = (String) puritySnapShot.child("reporter").getValue();
                    activeSourceReportList.addReport(new WaterSourceReport(lat, longi, waterType, waterCondition, reporter));
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
    }


    /**
     * On button click, will check to see which button was clicked and then pull up the appropriate
     * view based on the button pressed.
     *
     * @param view  welcomescreen view
     */
    public void onButtonClick(View view) {
        if (view.getId() == R.id.login_button) {
            Intent i = new Intent(WelcomeScreen.this, Login.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }
        if (view.getId() == R.id.button) {
            Intent i = new Intent(WelcomeScreen.this, Registration_screen1.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }
    }

    @Override
    public void onBackPressed() {
        //Do Nothing, stop peeping at private data you baka.
    }
}
