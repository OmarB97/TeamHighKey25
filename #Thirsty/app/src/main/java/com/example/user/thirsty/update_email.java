package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update_email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_email);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.update_email) {
            EditText emailPrep = (EditText) findViewById(R.id.new_email);
            String email = emailPrep.getText().toString();

            String username = getIntent().getStringExtra("Username");
            username = username.substring(1);

            if (!email.contains("@")) {
                Toast emailPopUp = Toast.makeText(update_email.this,
                        "Please use a valid email", Toast.LENGTH_SHORT);
                emailPopUp.show();
            } else if (email.length() < 1) {
                Toast emailPopUp = Toast.makeText(update_email.this,
                        "Please use a valid email", Toast.LENGTH_SHORT);
                emailPopUp.show();
            } else {
                WelcomeScreen.users.setEmail(username, email);
                Intent i = new Intent(update_email.this, successful_login.class);
                i.putExtra("Username", getIntent().getStringExtra("Username"));
                Toast emailPopUp = Toast.makeText(update_email.this,
                        "Email successfully changed!", Toast.LENGTH_SHORT);
                emailPopUp.show();
                startActivity(i);
            }

        }
    }
}
