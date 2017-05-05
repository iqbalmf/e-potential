package com.example.iqbalmfauzan.e_potential;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class soal2 extends AppCompatActivity implements View.OnClickListener{
    Button soal1a, soal1b, soal1c, soal1d;

    TextView benar,salah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        soal1a = (Button) findViewById(R.id.soal1a);
        soal1b = (Button) findViewById(R.id.soal1b);
        soal1c = (Button) findViewById(R.id.soal1c);
        soal1d = (Button) findViewById(R.id.soal1d);
        benar = (TextView) findViewById(R.id.tvbenar);
        salah = (TextView) findViewById(R.id.tvsalah);
        benar.setVisibility(View.GONE);
        salah.setVisibility(View.GONE);

        soal1a.setOnClickListener(this);
        soal1b.setOnClickListener(this);
        soal1c.setOnClickListener(this);
        soal1d.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.soal1a:
                benar.setVisibility(View.VISIBLE);
                Intent soal2 = new Intent(getApplicationContext(), soal3.class);
                startActivity(soal2);
                finish();
                break;
            case R.id.soal1b:
                salah.setVisibility(View.VISIBLE);
                Intent soal2a = new Intent(getApplicationContext(), soal3.class);
                startActivity(soal2a);
                finish();
                break;
            case R.id.soal1c:
                salah.setVisibility(View.VISIBLE);
                Intent soal2b = new Intent(getApplicationContext(), soal3.class);
                startActivity(soal2b);
                finish();
                break;
            case R.id.soal1d:
                salah.setVisibility(View.VISIBLE);
                Intent soal2c = new Intent(getApplicationContext(), soal3.class);
                startActivity(soal2c);
                finish();
                break;
        }
    }
}
