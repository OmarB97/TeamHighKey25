package com.example.user.thirsty;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.submitReq) {
            EditText userPrep = (EditText) findViewById(R.id.userName);
            String user = userPrep.getText().toString();
            if (WelcomeScreen.users.getUser(user)) {
                if (!WelcomeScreen.users.getAccountStatus(user)) {
                    Log.writeLogEvent("Password Recovery Event", user);
                    Intent i = new Intent(ForgotPassword.this, PasswordRecovery.class);
                    i.putExtra("Username", user);
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.water_drop);
                    mp.start();
                    startActivity(i);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                } else {
                    Toast accountBan = Toast.makeText(ForgotPassword.this,
                            "This account has been banned, please contact an Administrator", Toast.LENGTH_SHORT);
                    accountBan.show();
                }
            } else {
                Toast accountDNE = Toast.makeText(ForgotPassword.this,
                        "This account is currently not registered", Toast.LENGTH_SHORT);
                accountDNE.show();
            }
        }
    }
}
