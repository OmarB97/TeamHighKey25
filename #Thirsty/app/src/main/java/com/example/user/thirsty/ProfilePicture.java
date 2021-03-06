package com.example.user.thirsty;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Erika Trejo
 */

public class ProfilePicture extends AppCompatActivity {
    Button buttonLoadPicture;
    ImageView imgView;
    private int REQUEST_CODE = 1;
    String encodedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_picture);

        buttonLoadPicture = (Button) findViewById(R.id.buttonLoadPicture);
        imgView = (ImageView) findViewById(R.id.imgView);

        buttonLoadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
            }
        });
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.buttonSelect) {
            WelcomeScreen.users.setPicCode(getIntent().getStringExtra("Username").substring(1), encodedImage);
            Toast picturePopUp = Toast.makeText(ProfilePicture.this,
                    "Picture Uploaded!", Toast.LENGTH_SHORT);
            picturePopUp.show();
            WelcomeScreen.userDB.setValue(WelcomeScreen.users.getUserDataBase());
            Intent i = new Intent(ProfilePicture.this, Successful_login.class);
            i.putExtra("Username", getIntent().getStringExtra("Username"));
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imgView.setImageBitmap(bitmap);
                ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
                //bitmap.recycle();
                byte[] byteArray = bYtE.toByteArray();
                encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }
}
