package com.example.user.thirsty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class PasswordRecovery extends AppCompatActivity {

    String recoveryString = generateRecoveryCode();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery);
        String user = getIntent().getStringExtra("Username");



        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{WelcomeScreen.users.getEmail(user)});
        i.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery");
        i.putExtra(Intent.EXTRA_TEXT   , "Hello, you have requested a password change. " +
                "Please enter the following code in order to change your password: " + recoveryString);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(PasswordRecovery.this, "Email Client does not exist", Toast.LENGTH_SHORT).show();
        }
    }

    public void onButtonClick(View view) {
        EditText recoverPrep = (EditText) findViewById(R.id.code);
        String recover = recoverPrep.getText().toString();
        if (recoveryString.equals(recover)) {
            Intent i = new Intent(PasswordRecovery.this, Update_password.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);

        } else {
            Toast codeWrong = Toast.makeText(PasswordRecovery.this,
                    "This is not the correct recovery code, please try again", Toast.LENGTH_SHORT);
            codeWrong.show();
        }

    }

    public String generateRecoveryCode() {
        String SALT_POTENTIAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder recovery = new StringBuilder();
        Random rand = new Random();
        while (recovery.length() < 7) { // length of the random string.
            int index = (int) (rand.nextFloat() * SALT_POTENTIAL.length());
            recovery.append(SALT_POTENTIAL.charAt(index));
        }
        String recoveryStr = recovery.toString();
        return recoveryStr;
    }
}
