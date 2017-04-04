package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Dennis Eddington on 3/12/2017.
 * @author Dennis Eddington
 */

public class PurityReportView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_report_view);
        WelcomeScreen.purityDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                WelcomeScreen.activePurityReportList.clearList();
                for (DataSnapshot puritySnapShot : dataSnapshot.getChildren()) {
                    //int reportNumber = Integer.parseInt(puritySnapShot.getKey());
                    float contaminant = Float.parseFloat(puritySnapShot.child("contaminantPPM").getValue().toString());
                    float virus = Float.parseFloat(puritySnapShot.child("virusPPM").getValue().toString());
                    float lat = Float.parseFloat(puritySnapShot.child("latitude").getValue().toString());
                    float longi = Float.parseFloat(puritySnapShot.child("longitude").getValue().toString());
                    String overall = (String) puritySnapShot.child("overallCondition").getValue();
                    String reporter = (String) puritySnapShot.child("reporter").getValue();
                    WelcomeScreen.activePurityReportList.addReport(new WaterPurityReport(virus, contaminant, lat, longi, overall, reporter));
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
        updateListView();
        registerClick();
    }

    /**
     * Creates a dynamic list view that can be transversed by viewers if needed.
     */
    private void updateListView() {
        Object[] list = WelcomeScreen.activePurityReportList.printList();
        String[] writableList = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            int reportNumber;
            reportNumber = ((WaterPurityReport) list[i]).getReportNumber();
            String entry;
            entry = "Report #" + reportNumber + " submitted by " + ((WaterPurityReport) list[i]).getReporter() + " on " + ((WaterPurityReport) list[i]).getDate();
            writableList[i] = entry;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.items2, writableList);

        ListView listed = (ListView) findViewById(R.id.list_view);
        listed.setAdapter(adapter);
    }

    /**
     * Registers clicks on the list view in order for users to review information submitted by
     * other users.
     */
    private void registerClick() {
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent i = new Intent(PurityReportView.this, PurityReportViewSpecific.class);
                i.putExtra("RepNumber", position);
                startActivity(i);
            }
        });
    }
}
