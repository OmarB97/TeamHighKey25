package com.example.user.thirsty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Dennis Eddington on 3/12/2017.
 * @author Dennis Eddington
 */

public class PurityReportViewSpecific extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_report_view_specific);
        int reportNum = getIntent().getIntExtra("RepNumber", 0);
        WaterPurityReport currentReport = WelcomeScreen.activePurityReportList.getReport(reportNum);

        TextView displayTitle = (TextView) findViewById(R.id.report_number);
        displayTitle.setText((reportNum + 1) + " created by " + currentReport.getReporter());

        TextView displayLocation = (TextView) findViewById(R.id.longitude);
        String longitude = Float.toString(currentReport.getLongitude());
        displayLocation.setText(longitude);

        TextView displayLatitude = (TextView) findViewById(R.id.latitude);
        String latitude = Float.toString(currentReport.getLatitude());
        displayLatitude.setText(latitude);

        TextView displayVirus = (TextView) findViewById(R.id.virus_ppm);
        String virus = Float.toString(currentReport.getLatitude());
        displayVirus.setText(virus);

        TextView displayContaminant = (TextView) findViewById(R.id.contamination_ppm);
        String contaminant = Float.toString(currentReport.getLatitude());
        displayContaminant.setText(contaminant);


        TextView displayWaterCondition = (TextView) findViewById(R.id.condition);
        displayWaterCondition.setText(currentReport.getOverallCondition());
    }
}
