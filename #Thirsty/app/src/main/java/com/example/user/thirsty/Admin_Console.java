package com.example.user.thirsty;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Console extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__console);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.unban) {
            EditText userPrep = (EditText) findViewById(R.id.userName);
            String user = userPrep.getText().toString();

            if (WelcomeScreen.users.getUser(user)) {
                if (WelcomeScreen.users.getAccountStatus(user)) {
                    WelcomeScreen.users.setAccountStatus(user, false);
                    Toast accountUnban = Toast.makeText(Admin_Console.this,
                            user + " has been unbanned!", Toast.LENGTH_SHORT);
                    accountUnban.show();
                    Intent i = new Intent(Admin_Console.this,WelcomeScreenLoggedInADMIN.class);
                    i.putExtra("Username", getIntent().getStringExtra("Username"));
                    WelcomeScreen.userDB.setValue(WelcomeScreen.users.getUserDataBase());
                    Log.writeLogEvent("Unban User Event", user);
                    startActivity(i);

                } else {
                    Toast accountNotBanned = Toast.makeText(Admin_Console.this,
                            "This account is currently not banned", Toast.LENGTH_SHORT);
                    accountNotBanned.show();
                }
            } else {
                Toast accountDNE = Toast.makeText(Admin_Console.this,
                        "Account does not exist", Toast.LENGTH_SHORT);
                accountDNE.show();
            }

        }
        if (view.getId() == R.id.ban) {
            EditText userPrep = (EditText) findViewById(R.id.userName);
            String user = userPrep.getText().toString();

            if (WelcomeScreen.users.getUser(user)) {
                if (!WelcomeScreen.users.getAccountStatus(user)) {
                    WelcomeScreen.users.setAccountStatus(user, true);
                    Toast accountBan = Toast.makeText(Admin_Console.this,
                            user + " has been banned!", Toast.LENGTH_SHORT);
                    accountBan.show();
                    Intent i = new Intent(Admin_Console.this,WelcomeScreenLoggedInADMIN.class);
                    i.putExtra("Username", getIntent().getStringExtra("Username"));
                    WelcomeScreen.userDB.setValue(WelcomeScreen.users.getUserDataBase());
                    Log.writeLogEvent("Ban User Event", user);
                    startActivity(i);
                } else {
                    Toast accountNotBanned = Toast.makeText(Admin_Console.this,
                            "This account is currently banned", Toast.LENGTH_SHORT);
                    accountNotBanned.show();
                }
            } else {
                Toast accountDNE = Toast.makeText(Admin_Console.this,
                        "Account does not exist", Toast.LENGTH_SHORT);
                accountDNE.show();
            }
        }
    }
}
