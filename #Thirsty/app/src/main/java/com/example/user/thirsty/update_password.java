package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.update_password) {

            EditText passPrep = (EditText) findViewById(R.id.new_pass);
            String pass = passPrep.getText().toString();

            EditText confirmPassPrep = (EditText) findViewById(R.id.confirm_pass);
            String confirmPass = confirmPassPrep.getText().toString();

            String username = getIntent().getStringExtra("Username");
            username = username.substring(1);


            if (pass.length() < 1) {
                Toast passwordPopUp = Toast.makeText(update_password.this,
                        "Please enter a password", Toast.LENGTH_SHORT);
                passwordPopUp.show();
            } else {

                if (!pass.equals(confirmPass)) {
                    // This is Pop-Up Action Code
                    Toast passPopUp = Toast.makeText(update_password.this,
                            "Passwords do not match", Toast.LENGTH_SHORT);
                    passPopUp.show();
                }

                if (pass.equals(confirmPass)) {
                    WelcomeScreen.users.setPassword(username, pass);
                    Intent i = new Intent(update_password.this, successful_login.class);
                    i.putExtra("Username", getIntent().getStringExtra("Username"));
                    Toast passPopUp = Toast.makeText(update_password.this,
                            "Password successfully changed!", Toast.LENGTH_SHORT);
                    passPopUp.show();
                    startActivity(i);
                }
            }
        }
    }
}
