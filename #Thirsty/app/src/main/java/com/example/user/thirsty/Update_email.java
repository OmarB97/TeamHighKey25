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

public class Update_email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_email);
    }

    /**
     * On button click, will check to see if there was an email entered and if it was valid. Upon
     * confirmation of those two things will successfully change the email of the correct object.
     *
     * @param view update_email view
     */

    public void onButtonClick(View view) {
        if (view.getId() == R.id.update_email) {
            EditText emailPrep = (EditText) findViewById(R.id.new_email);
            String email = emailPrep.getText().toString();
            String username = getIntent().getStringExtra("Username");
            username = username.substring(1);

            if (!email.contains("@")) {
                Toast emailPopUp = Toast.makeText(Update_email.this,
                        "Please use a valid email", Toast.LENGTH_SHORT);
                emailPopUp.show();
            } else if (email.length() < 1) {
                Toast emailPopUp = Toast.makeText(Update_email.this,
                        "Please use a valid email", Toast.LENGTH_SHORT);
                emailPopUp.show();
            } else {
                WelcomeScreen.users.setEmail(username, email);
                Intent i = new Intent(Update_email.this, Successful_login.class);
                i.putExtra("Username", getIntent().getStringExtra("Username"));
                Toast emailPopUp = Toast.makeText(Update_email.this,
                        "Email successfully changed!", Toast.LENGTH_SHORT);
                emailPopUp.show();
                WelcomeScreen.userDB.setValue(WelcomeScreen.users.getUserDataBase());
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }

        }
    }
}
