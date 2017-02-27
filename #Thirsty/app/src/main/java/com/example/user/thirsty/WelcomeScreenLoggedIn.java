package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class WelcomeScreenLoggedIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_logged_in);

    }

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
