package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class registration_screen1 extends AppCompatActivity {
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

    public void onButtonClick(View view) {
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
                Toast usernamePopUp = Toast.makeText(registration_screen1.this,
                        "Please enter a username", Toast.LENGTH_SHORT);
                usernamePopUp.show();
            } else if (pass.length() < 1) {
                Toast passwordPopUp = Toast.makeText(registration_screen1.this,
                        "Please enter a password", Toast.LENGTH_SHORT);
                passwordPopUp.show();
            } else {

                if (!pass.equals(confirmPass)) {
                    // This is Pop-Up Action Code
                    Toast passPopUp = Toast.makeText(registration_screen1.this,
                            "Passwords do not match", Toast.LENGTH_SHORT);
                    passPopUp.show();
                }

                if (pass.equals(confirmPass)) {
                    if (WelcomeScreen.users.getUser(user)) {
                        Toast existsPopUp = Toast.makeText(registration_screen1.this,
                                "This user already exists", Toast.LENGTH_SHORT);
                        existsPopUp.show();
                    } else {
                        WelcomeScreen.users.createUser(user, pass, email, userType);
                        Toast accountCreated = Toast.makeText(registration_screen1.this,
                                "Account successfully created!", Toast.LENGTH_SHORT);
                        accountCreated.show();
                        Intent i = new Intent(registration_screen1.this, WelcomeScreen.class);
                        startActivity(i);
                    }
                }
            }


        }
    }
}
