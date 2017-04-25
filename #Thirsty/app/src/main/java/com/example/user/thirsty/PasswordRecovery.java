package com.example.user.thirsty;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PasswordRecovery extends AppCompatActivity {

    String recoveryString = generateRecoveryCode();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_password_recovery);
        String user = getIntent().getStringExtra("Username");

        SendEmail.send("theofficialthirstyapp@gmail.com","emailpassword2340", WelcomeScreen.users.getEmail(user) ,
                "Password Recovery Request", "Hello, you have requested a password change. " +
                        "Please enter the following code in order to change your password: " + recoveryString);

    }

    public void onButtonClick(View view) {
        EditText recoverPrep = (EditText) findViewById(R.id.code);
        String recover = recoverPrep.getText().toString();
        if (recoveryString.equals(recover)) {
            Intent i = new Intent(PasswordRecovery.this, Update_password.class);
            i.putExtra("Username", " " + getIntent().getStringExtra("Username"));
            startActivity(i);

        } else {
            Toast codeWrong = Toast.makeText(PasswordRecovery.this,
                    "This is not the correct recovery code, please try again", Toast.LENGTH_SHORT);
            codeWrong.show();
        }

    }

    public String generateRecoveryCode() {
        String RECOVERY_POTENTIAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder recovery = new StringBuilder();
        Random rand = new Random();
        while (recovery.length() < 7) { // length of the random string.
            int index = (int) (rand.nextFloat() * RECOVERY_POTENTIAL.length());
            recovery.append(RECOVERY_POTENTIAL.charAt(index));
        }
        String recoveryStr = recovery.toString();
        return recoveryStr;
    }

}
