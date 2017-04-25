package com.example.user.thirsty;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            String uniqueSalt = WelcomeScreen.users.getSalt(user);

            pass = WelcomeScreen.users.MD5(pass + uniqueSalt);


            if (WelcomeScreen.users.getUser(user) && WelcomeScreen.users.getPassword(user, pass)) {
                Log.writeLogEvent("Login Event", user);
                if (!WelcomeScreen.users.getAccountStatus(user)) {
                    //resets counter to zero
                    WelcomeScreen.users.zeroCounter(user);
                    if (WelcomeScreen.users.getUserType(user).equals("Admin")) {
                        Intent i = new Intent(Login.this, WelcomeScreenLoggedInADMIN.class);
                        user = " " + user;
                        i.putExtra("Username", user);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.water_drop);
                        mp.start();
                        startActivity(i);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else {
                        Intent i = new Intent(Login.this, WelcomeScreenLoggedIn.class);
                        user = " " + user;
                        i.putExtra("Username", user);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.water_drop);
                        mp.start();
                        startActivity(i);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                } else {
                    Toast accountBan = Toast.makeText(Login.this,
                            "This account has been banned, please contact an Administrator", Toast.LENGTH_SHORT);
                    accountBan.show();
                }
            } else {
                Intent i = new Intent(Login.this, Bad_login.class);
                //banning if 3 times
                if (WelcomeScreen.users.getUser(user)) {
                    if (WelcomeScreen.users.returnCounter(user) == 2) {
                        //is banned
                        Toast accountBan = Toast.makeText(Login.this,
                                "This account has been banned for incorrect password 3 times, please contact an Administrator", Toast.LENGTH_SHORT);
                        accountBan.show();
                    } else {
                        WelcomeScreen.users.addCounter(user);
                    }
                }
                startActivity(i);
            }

        }
    }
}
