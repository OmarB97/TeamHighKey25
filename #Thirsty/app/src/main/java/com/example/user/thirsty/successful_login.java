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

        String userInfo = WelcomeScreen.users.getInfo(username.substring(1));
        TextView displayInfo = (TextView) findViewById(R.id.user_info);
        displayInfo.setText(userInfo);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.logout) {
            Intent i = new Intent(successful_login.this, WelcomeScreen.class);
            startActivity(i);
        }

        if (view.getId() == R.id.edit_email) {
            Intent i = new Intent(successful_login.this, update_email.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        }

        if (view.getId() == R.id.edit_password) {
            Intent i = new Intent(successful_login.this, update_password.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
        }
    }
}
