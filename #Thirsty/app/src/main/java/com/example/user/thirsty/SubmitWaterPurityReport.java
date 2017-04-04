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

public class SubmitWaterPurityReport extends AppCompatActivity {


    public List<String> legalConditions = Arrays.asList("Safe", "Treatable", "Unsafe");

    private Spinner conditionSpinner;
    float lat;
    float longi;
    float vir;
    float cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_water_purity_report);


        conditionSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalConditions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conditionSpinner.setAdapter(adapter);
    }

    /**
     * Upon successful input of information will create a WaterPurityReport object containing that
     * information to be stored into the WaterPurityReportList object.
     *
     * @param view submit_water_source_report view
     *
     */

    public void onButtonClick(View view) {
        if (view.getId() == R.id.submit_report) {
            EditText latitudePrep = (EditText) findViewById(R.id.latitude_field);
            EditText longitudePrep = (EditText) findViewById(R.id.longitude_field);
            EditText virusPrep = (EditText) findViewById(R.id.virus_field);
            EditText contaminantPrep = (EditText) findViewById(R.id.contaminant_field);
            String latitude = latitudePrep.getText().toString();
            String longitude = longitudePrep.getText().toString();
            String virus = virusPrep.getText().toString();
            String contaminant = contaminantPrep.getText().toString();


            if (latitude.length() > 0 && longitude.length() > 0 && virus.length() > 0 && contaminant.length() > 0) {
                lat = Float.parseFloat(latitude);
                longi = Float.parseFloat(longitude);
                vir = Float.parseFloat(virus);
                cont = Float.parseFloat(contaminant);
                String user = getIntent().getStringExtra("Username");
                String waterCondition = (String) conditionSpinner.getSelectedItem();

                if (latitude.length() > 0 && longitude.length() > 0 && virus.length() > 0 && contaminant.length() > 0) {
                    WelcomeScreen.activePurityReportList.addReport(new WaterPurityReport(vir, cont, lat, longi, waterCondition, user.substring(1)));
                    Toast reportCreated = Toast.makeText(SubmitWaterPurityReport.this,
                            "Report successfully created!", Toast.LENGTH_SHORT);
                    reportCreated.show();
                    WelcomeScreen.purityDB.setValue(WelcomeScreen.activePurityReportList.getReportList());
                    Intent i = new Intent(SubmitWaterPurityReport.this, WelcomeScreenLoggedIn.class);
                    i.putExtra("Username", user);
                    startActivity(i);
                } else {
                    Toast.makeText(this, "Please insert a location or virus/contaminant PPM", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please insert a location or virus/contaminant PPM", Toast.LENGTH_SHORT).show();
            }




        }
    }
}
