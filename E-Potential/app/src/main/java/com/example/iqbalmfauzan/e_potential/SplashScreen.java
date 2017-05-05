package com.example.iqbalmfauzan.e_potential;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    PlayUser playUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Intent mulaisplash = new Intent(SplashScreen.this, PlayUser.class);
        startActivity(mulaisplash);
        finish();
    }


}
