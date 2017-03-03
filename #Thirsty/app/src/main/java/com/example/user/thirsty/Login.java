package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /* When the user clicks on the login button, onButtonClick
    ** checks for correct user & password combination and if
    ** so, the screen changes to the welcome screen.
    **
    ** @param view Login Screen View object*
     */
    public void onButtonClick(View view) {
        if (view.getId() == R.id.button3) {

            EditText userPrep = (EditText) findViewById(R.id.TFUsername);
            String user = userPrep.getText().toString();

            EditText passPrep = (EditText) findViewById(R.id.TFPassword);
            String pass = passPrep.getText().toString();

            pass = UserDataBase.MD5(pass);
            

            if (WelcomeScreen.users.getUser(user) && WelcomeScreen.users.getPassword(user, pass)) {
                Intent i = new Intent(Login.this, WelcomeScreenLoggedIn.class);
                user = " " + user;
                i.putExtra("Username", user);
                startActivity(i);
            } else {
                Intent i = new Intent(Login.this, Bad_login.class);
                startActivity(i);
            }

        }
    }
}
