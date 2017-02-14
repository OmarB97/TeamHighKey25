package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class bad_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_login);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.try_again) {
            Intent i = new Intent(bad_login.this, Login.class);
            startActivity(i);
        }
        if (view.getId() == R.id.register_button) {
            //Do nothing : )
        }
    }
}
