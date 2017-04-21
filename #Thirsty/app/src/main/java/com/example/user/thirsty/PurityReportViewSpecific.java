package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        String virus = Float.toString(currentReport.getVirusPPM());
        displayVirus.setText(virus);

        TextView displayContaminant = (TextView) findViewById(R.id.contamination_ppm);
        String contaminant = Float.toString(currentReport.getContaminantPPM());
        displayContaminant.setText(contaminant);


        TextView displayWaterCondition = (TextView) findViewById(R.id.condition);
        displayWaterCondition.setText(currentReport.getOverallCondition());
    }

    public void onButtonClick(View view) {

        if (view.getId() == R.id.delete) {
            if (WelcomeScreen.users.getUserType(getIntent().getStringExtra("Username").substring(1)).equals("Manager")) {

                Intent i = new Intent(PurityReportViewSpecific.this, PurityReportView.class);
                //user = " " + user;
                i.putExtra("Username", getIntent().getStringExtra("Username"));
                startActivity(i);
                WelcomeScreen.activePurityReportList.removeReport(getIntent().getIntExtra("RepNumber", 0));
                WelcomeScreen.purityDB.setValue(WelcomeScreen.activePurityReportList.getReportList());
                Toast reportDeleted = Toast.makeText(PurityReportViewSpecific.this, "The report has been successfully deleted", Toast.LENGTH_SHORT);
                reportDeleted.show();
            } else {
                Toast accessDenied = Toast.makeText(PurityReportViewSpecific.this, "Your user account type does not allow you to delete a Purity Report", Toast.LENGTH_SHORT);
                accessDenied.show();
            }
        }
    }
}
