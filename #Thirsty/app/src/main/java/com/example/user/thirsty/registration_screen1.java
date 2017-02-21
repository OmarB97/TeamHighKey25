package com.example.user.thirsty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registration_screen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen1);
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

            if(!pass.equals(confirmPass)) {
                // This is Pop-Up Action Code
                Toast passPopUp = Toast.makeText(registration_screen1.this, "Passwords do not match.", Toast.LENGTH_SHORT);
                passPopUp.show();
            }


        }
    }
}
