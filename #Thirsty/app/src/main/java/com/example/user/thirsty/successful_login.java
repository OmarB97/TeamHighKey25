package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class successful_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);
        String username = getIntent().getStringExtra("Username");

        TextView displayUser = (TextView) findViewById(R.id.TVusername);
        displayUser.setText(username);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.logout) {
            Intent i = new Intent(successful_login.this, WelcomeScreen.class);
            startActivity(i);
        }
    }
}
