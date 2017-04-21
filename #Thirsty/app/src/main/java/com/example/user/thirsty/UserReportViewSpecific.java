package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    public void onButtonClick(View view) {

        if (view.getId() == R.id.delete) {
            if (WelcomeScreen.users.getUserType(getIntent().getStringExtra("Username").substring(1)).equals("Manager")) {

                Intent i = new Intent(UserReportViewSpecific.this, UserReportView.class);
                //user = " " + user;
                i.putExtra("Username", getIntent().getStringExtra("Username"));
                startActivity(i);
                WelcomeScreen.activeSourceReportList.removeReport(getIntent().getIntExtra("RepNumber", 0));
                WelcomeScreen.sourceDB.setValue(WelcomeScreen.activeSourceReportList.getReportList());
                Toast reportDeleted = Toast.makeText(UserReportViewSpecific.this, "The report has been successfully deleted", Toast.LENGTH_SHORT);
                reportDeleted.show();
            } else {
                Toast accessDenied = Toast.makeText(UserReportViewSpecific.this, "Your user account type does not allow you to delete a Source Report", Toast.LENGTH_SHORT);
                accessDenied.show();
            }
        }
    }


}
