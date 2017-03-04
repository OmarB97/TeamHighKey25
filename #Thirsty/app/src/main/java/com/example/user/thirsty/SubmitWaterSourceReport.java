package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dennis Eddington on 2/27/2017.
 * @author Dennis Eddington
 */

public class SubmitWaterSourceReport extends AppCompatActivity {
    public List<String> legalTypes = Arrays.asList("Bottled", "Well", "Stream", "Lake", "Spring", "Other");
    public List<String> legalConditions = Arrays.asList("Waste", "Treatable-Clear", "Treatable-Muddy", "Potable");
    private Spinner typeSpinner;
    private Spinner conditionSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_water_source_report);

        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        conditionSpinner = (Spinner) findViewById(R.id.conditionSpinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalConditions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conditionSpinner.setAdapter(adapter2);
    }

    /**
     * Upon successful input of information will create a WaterSourceReport object containing that
     * information to be stored into the WaterSourceReportList object.
     *
     * @param view submit_water_source_report view
     */
    public void onButtonClick(View view) {
        if (view.getId() == R.id.submit) {
            EditText latitudePrep = (EditText) findViewById(R.id.latitude_field);
            EditText longitudePrep = (EditText) findViewById(R.id.longitude_field);
            String latitude = latitudePrep.getText().toString();
            String longitude = longitudePrep.getText().toString();
            float lat = Float.parseFloat(latitude);
            float longi = Float.parseFloat(longitude);

            String user = getIntent().getStringExtra("Username");

            String waterType = (String) typeSpinner.getSelectedItem();
            String waterCondition = (String) conditionSpinner.getSelectedItem();

            if (latitude.length() > 0 ) {
                WelcomeScreen.activeSourceReportList.addReport(new WaterSourceReport(lat, longi, waterType, waterCondition, user.substring(1)));
                Toast reportCreated = Toast.makeText(SubmitWaterSourceReport.this,
                        "Report successfully created!", Toast.LENGTH_SHORT);
                reportCreated.show();
                Intent i = new Intent(SubmitWaterSourceReport.this, WelcomeScreenLoggedIn.class);
                i.putExtra("Username", user);
                startActivity(i);
            } else {
                Toast.makeText(this, "Please insert a location", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
