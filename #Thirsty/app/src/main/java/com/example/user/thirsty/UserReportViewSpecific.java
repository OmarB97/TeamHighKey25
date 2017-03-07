package com.example.user.thirsty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Dennis Eddington on 2/27/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */

public class UserReportViewSpecific extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_report_view_specific);
        int reportNum = getIntent().getIntExtra("RepNumber", 0);
        WaterSourceReport currentReport = WelcomeScreen.activeSourceReportList.getReport(reportNum);

        TextView displayTitle = (TextView) findViewById(R.id.generated_title);
        displayTitle.setText((reportNum + 1) + " created by " + currentReport.getReporter());

        TextView displayLocation = (TextView) findViewById(R.id.longitude_field);
        String longitude = Float.toString(currentReport.getLongitude());
        displayLocation.setText(longitude);

        TextView displayLatitude = (TextView) findViewById(R.id.latitude_field);
        String latitude = Float.toString(currentReport.getLatitude());
        displayLatitude.setText(latitude);

        TextView displayWaterType = (TextView) findViewById(R.id.water_type);
        displayWaterType.setText(currentReport.getWaterType());

        TextView displayWaterCondition = (TextView) findViewById(R.id.water_condition);
        displayWaterCondition.setText(currentReport.getWaterCondition());


    }


}
