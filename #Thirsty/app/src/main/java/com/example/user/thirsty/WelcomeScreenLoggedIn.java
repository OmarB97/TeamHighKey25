package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Dennis Eddington on 2/27/2017.
 * @author Dennis Eddington
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

        if (view.getId() == R.id.view_report) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, UserReportView.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        }
    }
}
