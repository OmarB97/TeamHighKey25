package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

            if (pass.equals("pass") && user.equals("user")) {
                Intent i = new Intent(Login.this, successful_login.class);
                i.putExtra("Username", user);
                startActivity(i);
            } else {
                Intent i = new Intent(Login.this, bad_login.class);
                startActivity(i);
            }

        }
    }
}
