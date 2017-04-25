package com.example.user.thirsty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Dennis Eddington on 4/19/2017.
 * @author Dennis Eddington
 */

public class WelcomeScreenLoggedInADMIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_logged_in_admin);
    }

    /**
     * An alternate version of welcome screen displayed once the user has logged in. Will track
     * what the user selects and then display the appropriate screen based on the button clicked.
     *
     * @param view welcome_screen_logged_in view
     */

    public void onButtonClick(View view) {

        String user = getIntent().getStringExtra("Username");
        Log.d("Username", user);
        String permissionLevel = WelcomeScreen.users.getUserType(user.substring(1));

        if (view.getId() == R.id.history) {
            Intent i = new Intent(WelcomeScreenLoggedInADMIN.this, HistoryInput.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.view_profile) {
            Intent i = new Intent(WelcomeScreenLoggedInADMIN.this, Successful_login.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.submit_report) {
            Intent i = new Intent(WelcomeScreenLoggedInADMIN.this, SubmitWaterSourceReport.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.submit_purity_report && (permissionLevel.equals("Worker") || permissionLevel.equals("Manager"))) {
            Intent i = new Intent(WelcomeScreenLoggedInADMIN.this, SubmitWaterPurityReport.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        } else if (view.getId() == R.id.submit_purity_report) {
            Toast accessDenied = Toast.makeText(WelcomeScreenLoggedInADMIN.this, "Your user account type does not allow you to submit a Purity Report", Toast.LENGTH_SHORT);
            accessDenied.show();
        }

        if (view.getId() == R.id.view_purity_report && (permissionLevel.equals("Manager"))) {
            Intent i = new Intent(WelcomeScreenLoggedInADMIN.this, PurityReportView.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        } else if (view.getId() == R.id.view_purity_report) {
            Toast accessDenied2 = Toast.makeText(WelcomeScreenLoggedInADMIN.this, "Your user account type does not allow you to view Purity Reports", Toast.LENGTH_SHORT);
            accessDenied2.show();
        }

        if (view.getId() == R.id.view_report) {
            Intent i = new Intent(WelcomeScreenLoggedInADMIN.this, UserReportView.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.view_map) {
            Intent i = new Intent(WelcomeScreenLoggedInADMIN.this, MapsActivity.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.adminConsole) {
            Intent i = new Intent(WelcomeScreenLoggedInADMIN.this, Admin_Console.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }
    }
}
