package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Dennis Eddington on 2/27/2017.
 * @author Dennis Eddington
 * @author Heather Song
 * @author Erika Trejo
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
        Log.d("Username", user);
        String permissionLevel = WelcomeScreen.users.getUserType(user.substring(1));

        if (view.getId() == R.id.user_button) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, UserSubmissions.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.history) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, HistoryInput.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.view_profile) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, Successful_login.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.submit_report) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, SubmitWaterSourceReport.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.submit_purity_report && (permissionLevel.equals("Worker") || permissionLevel.equals("Manager"))) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, SubmitWaterPurityReport.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        } else if (view.getId() == R.id.submit_purity_report) {
            Toast accessDenied = Toast.makeText(WelcomeScreenLoggedIn.this, "Your user account type does not allow you to submit a Purity Report", Toast.LENGTH_SHORT);
            accessDenied.show();
        }

        if (view.getId() == R.id.view_purity_report && (permissionLevel.equals("Manager"))) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, PurityReportView.class);
            //user = " " + user;
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        } else if (view.getId() == R.id.view_purity_report) {
            Toast accessDenied2 = Toast.makeText(WelcomeScreenLoggedIn.this, "Your user account type does not allow you to view Purity Reports", Toast.LENGTH_SHORT);
            accessDenied2.show();
        }

        if (view.getId() == R.id.view_report) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, UserReportView.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }

        if (view.getId() == R.id.view_map) {
            Intent i = new Intent(WelcomeScreenLoggedIn.this, MapsActivity.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }
    }
}
