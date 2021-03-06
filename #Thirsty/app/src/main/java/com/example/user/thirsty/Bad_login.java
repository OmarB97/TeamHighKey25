package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */


public class Bad_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_login);
    }

/**
 * On button click, will check to see which button was clicked. If the try again button was clicked
 * the program will redirect the user to the login screen. If the register button was clicked, the
 * program will redirect the user to the registration screen.
 *
 * @param view bad_login view
 */

    public void onButtonClick(View view) {
        if (view.getId() == R.id.try_again) {
            Intent i = new Intent(Bad_login.this, Login.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        if (view.getId() == R.id.register_button) {
            Intent i = new Intent(Bad_login.this, Registration_screen1.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
