package com.example.user.thirsty;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Dennis Eddington on 2/21/2017.
 * @author Dennis Eddington
 * @author Heather Song
 * @author Erika Trejo
 */

public class Successful_login extends AppCompatActivity {

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

        String aString;


        WelcomeScreen.rootReference.child("Picture Database").child(username).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                byte[] decodedString = Base64.decode((String) dataSnapshot.getValue(), Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                ImageView picture = (ImageView) findViewById(R.id.profile_picture);
                picture.setImageBitmap(decodedByte);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    /**
     * On button click, will check to see whether the use has requested to updating email, update password
     * or log out. Will swap the view to the appropriate view based on user selection.
     *
     * @param view successful_login view
     */
    public void onButtonClick(View view) {
        if (view.getId() == R.id.picture_button) {
            EditText userPrep = (EditText) findViewById(R.id.username_TF);
            String user = userPrep.getText().toString();

            Intent i = new Intent(Successful_login.this, ProfilePicture.class);
            i.putExtra("Username", user);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        if (view.getId() == R.id.logout) {
            Intent i = new Intent(Successful_login.this, WelcomeScreen.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        if (view.getId() == R.id.edit_email) {
            Intent i = new Intent(Successful_login.this, Update_email.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        if (view.getId() == R.id.edit_password) {
            Intent i = new Intent(Successful_login.this, Update_password.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        if (view.getId() == R.id.return_home) {
            if (WelcomeScreen.users.getUserType(getIntent().getStringExtra("Username").substring(1)).equals("Admin")) {
                Intent i = new Intent(Successful_login.this, WelcomeScreenLoggedInADMIN.class);
                i.putExtra("Username", getIntent().getStringExtra("Username"));
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            } else {
                Intent i = new Intent(Successful_login.this, WelcomeScreenLoggedIn.class);
                i.putExtra("Username", getIntent().getStringExtra("Username"));
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }
    }
}
