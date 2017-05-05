package com.example.iqbalmfauzan.e_potential;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AfterAdmin extends AppCompatActivity implements View.OnClickListener{

    Button bBuatSoal;
    Button bLihatSoal;
    Button bHapusSoal;
    Button bEditSoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_admin);
        String username = getIntent().getStringExtra("Username");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        

        bBuatSoal = (Button) findViewById(R.id.bBuatsoal);
        bLihatSoal= (Button) findViewById(R.id.bLihatsoal);
        bHapusSoal = (Button) findViewById(R.id.bHapussoal);
        bEditSoal = (Button) findViewById(R.id.bEditsoal);

        bBuatSoal.setOnClickListener(this);
        bLihatSoal.setOnClickListener(this);
        bHapusSoal.setOnClickListener(this);
        bEditSoal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bBuatsoal:
                Intent buatsoal = new Intent(getApplicationContext(), Soal.class);
                startActivity(buatsoal);
                break;
            case R.id.bHapussoal:
                Intent hapussoal = new Intent(getApplicationContext(), HapusSoal.class);
                startActivity(hapussoal);
                break;
            case R.id.bLihatsoal:
                Intent lihatsoal = new Intent(getApplicationContext(), ListAcc.class);
                startActivity(lihatsoal);
                break;
            case R.id.bEditsoal:
                Intent editsoal = new Intent(getApplicationContext(), EditSoal.class);
                startActivity(editsoal);
                break;
        }


    }
    public void logout(View view){
        Intent logout = new Intent(getApplicationContext(),LoginAdmin.class);
        startActivity(logout);
        Toast.makeText(AfterAdmin.this,"Anda Telah Logout", Toast.LENGTH_LONG).show();
    }
}
