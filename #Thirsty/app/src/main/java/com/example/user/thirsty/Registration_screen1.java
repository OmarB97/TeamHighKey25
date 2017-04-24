package com.example.user.thirsty;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */

public class Registration_screen1 extends AppCompatActivity {
    public List<String> legalRoles = Arrays.asList("User", "Worker", "Manager", "Admin");
    private Spinner roleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen1);
        roleSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalRoles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

    }

    /**
     * On button click, will check all fields of the registration. Will look for common errors such
     * as invalid email, empty username, empty password, and non matching passwords. Upon
     * confirmation of all fields will record the new user in the userDataBase before sending the user
     * back to the welcome_screen.
     *
     * @param view registration_screen1 view
     */
    public void onButtonClick(View view) {
        if (view.getId() == R.id.picture_button) {
            Intent i = new Intent(Registration_screen1.this, ProfilePicture.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        }

        if (view.getId() == R.id.register_button1) {
            EditText userPrep = (EditText) findViewById(R.id.username_TF);
            String user = userPrep.getText().toString();

            EditText emailPrep = (EditText) findViewById(R.id.email_TF);
            String email = emailPrep.getText().toString();

            EditText passPrep = (EditText) findViewById(R.id.password_TF);
            String pass = passPrep.getText().toString();

            EditText confirmPassPrep = (EditText) findViewById(R.id.confirmpass_TF);
            String confirmPass = confirmPassPrep.getText().toString();

            String userType = (String) roleSpinner.getSelectedItem();

            if (user.length() < 1) {
                Toast usernamePopUp = Toast.makeText(Registration_screen1.this,
                        "Please enter a username", Toast.LENGTH_SHORT);
                usernamePopUp.show();
            } else if (!email.contains("@")) {
                Toast emailPopUp = Toast.makeText(Registration_screen1.this,
                        "Please use a valid email", Toast.LENGTH_SHORT);
                emailPopUp.show();
            } else if (email.length() < 1) {
                Toast emailPopUp = Toast.makeText(Registration_screen1.this,
                        "Please use a valid email", Toast.LENGTH_SHORT);
                emailPopUp.show();
            } else if (pass.length() < 1) {
                Toast passwordPopUp = Toast.makeText(Registration_screen1.this,
                        "Please enter a password", Toast.LENGTH_SHORT);
                passwordPopUp.show();
            } else {

                if (!pass.equals(confirmPass)) {
                    // This is Pop-Up Action Code
                    Toast passPopUp = Toast.makeText(Registration_screen1.this,
                            "Passwords do not match", Toast.LENGTH_SHORT);
                    passPopUp.show();
                }

                if (pass.equals(confirmPass)) {
                    if (WelcomeScreen.users.getUser(user)) {
                        Toast existsPopUp = Toast.makeText(Registration_screen1.this,
                                "This user already exists", Toast.LENGTH_SHORT);
                        existsPopUp.show();
                    } else {
                        String uniqueSalt = UserDataBase.SaltShaker();
                        pass = pass + uniqueSalt;
                        WelcomeScreen.users.createUser(user, UserDataBase.MD5(pass), email, userType, uniqueSalt, false);
                        Toast accountCreated = Toast.makeText(Registration_screen1.this,
                                "Account successfully created!", Toast.LENGTH_SHORT);
                        accountCreated.show();

                        Intent i = new Intent(Registration_screen1.this, WelcomeScreen.class);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.water_drop);
                        mp.start();
                        Log.writeLogEvent("Registration Event", user);

                        startActivity(i);
                    }
                }
            }


        }
    }
}
