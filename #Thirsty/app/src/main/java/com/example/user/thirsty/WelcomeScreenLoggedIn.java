package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Dennis Eddington on 2/27/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */

public class WelcomeScreenLoggedIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_logged_in);

    }

    /**
     * An alternate version of welcome screen displayed once the user has logged in. Will track
     * what the user selects and then display the appropriate screen based on the button clicked.
     *
     * @param view welcome_screen_logged_in view
     */

    public void onButtonClick(View view) {

        String user = getIntent().getStringExtra("Username");
        String permissionLevel = WelcomeScreen.users.getUserType(user.substring(1));

        if (view.getId() == R.id.view_profile) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, Successful_login.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        }

        if (view.getId() == R.id.submit_report) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, SubmitWaterSourceReport.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        }

        if (view.getId() == R.id.submit_purity_report && (permissionLevel.equals("Worker") || permissionLevel.equals("Manager"))) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, SubmitWaterPurityReport.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        } else {
            Toast accessDenied = Toast.makeText(WelcomeScreenLoggedIn.this, "Your user account type does not allow you to submit a Purity Report", Toast.LENGTH_SHORT);
            accessDenied.show();
        }

        if (view.getId() == R.id.view_report) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, UserReportView.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        }

        if (view.getId() == R.id.view_map) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, MapsActivity.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        }
    }
}
