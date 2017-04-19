package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 */

public class Update_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
    }

    /**
     * On button click, will check to see if there was an password entered and if matches
     * the confirmed password field. Upon confirmation of those two things will successfully
     * change the email of the correct object.
     *
     * @param view update_password view
     */
    public void onButtonClick(View view) {
        if (view.getId() == R.id.update_password) {

            EditText passPrep = (EditText) findViewById(R.id.new_pass);
            String pass = passPrep.getText().toString();

            EditText confirmPassPrep = (EditText) findViewById(R.id.confirm_pass);
            String confirmPass = confirmPassPrep.getText().toString();

            String username = getIntent().getStringExtra("Username");
            username = username.substring(1);


            if (pass.length() < 1) {
                Toast passwordPopUp = Toast.makeText(Update_password.this,
                        "Please enter a password", Toast.LENGTH_SHORT);
                passwordPopUp.show();
            } else {

                if (!pass.equals(confirmPass)) {
                    // This is Pop-Up Action Code
                    Toast passPopUp = Toast.makeText(Update_password.this,
                            "Passwords do not match", Toast.LENGTH_SHORT);
                    passPopUp.show();
                }

                if (pass.equals(confirmPass)) {
                    String uniqueSalt = WelcomeScreen.users.getSalt(username);
                    WelcomeScreen.users.setPassword(username, UserDataBase.MD5(pass + uniqueSalt));
                    Intent i = new Intent(Update_password.this,Successful_login.class);
                    i.putExtra("Username", getIntent().getStringExtra("Username"));
                    Toast passPopUp = Toast.makeText(Update_password.this,
                            "Password successfully changed!", Toast.LENGTH_SHORT);
                    passPopUp.show();
                    WelcomeScreen.userDB.setValue(WelcomeScreen.users.getUserDataBase());
                    startActivity(i);
                }
            }
        }
    }
}
