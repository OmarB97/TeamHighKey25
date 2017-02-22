package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 */

public class WelcomeScreen extends AppCompatActivity {

    public static userDataBase users = new userDataBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    /**
     * On button click, will check to see which button was clicked and then pull up the appropriate
     * view based on the button pressed.
     *
     * @param view  welcomescreen view
     */
    public void onButtonClick(View view) {
        if (view.getId() == R.id.login_button) {
            Intent i = new Intent(WelcomeScreen.this, Login.class);
            startActivity(i);
        }
        if (view.getId() == R.id.button) {
            Intent i = new Intent(WelcomeScreen.this, registration_screen1.class);
            startActivity(i);
        }
    }

    @Override
    public void onBackPressed() {
        //Do Nothing, stop peeping at private data you baka.
    }
}
