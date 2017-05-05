package com.example.iqbalmfauzan.e_potential;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PlayUser extends Activity implements View.OnClickListener{

    TextView tRegister;
    EditText etUsername;
    Button bPlay;
    Button bAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.playuser);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tRegister = (TextView) findViewById(R.id.tRegister);
        etUsername = (EditText) findViewById(R.id.etUsername);
        bPlay = (Button) findViewById(R.id.bPlay);
        bAbout = (Button) findViewById(R.id.bAbout);

        tRegister.setOnClickListener(this);
        bPlay.setOnClickListener(this);
        bAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bPlay:
                EditText et = (EditText) findViewById(R.id.etUsername);
                if (et.getText().toString().equals(""))
                {
                    Toast toa = Toast.makeText(PlayUser.this, "Username is blank" , Toast.LENGTH_SHORT);
                    toa.show();
                }
                else
                {
                    String S = et.getText().toString();

                    Intent player = new Intent(getApplicationContext(), AfterPlayer.class);
                    player.putExtra("Username" , S);
                    startActivity(player);
                }
                break;
            case R.id.tRegister:
                Intent admin = new Intent(getApplicationContext(), LoginAdmin.class);
                startActivity(admin);
                break;
            case R.id.bAbout:
                Intent ba = new Intent(getApplicationContext(), About.class);
                startActivity(ba);
                break;
        }
    }
    public void tambah(){

    }
}
