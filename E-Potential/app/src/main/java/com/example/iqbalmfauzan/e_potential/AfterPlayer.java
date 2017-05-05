package com.example.iqbalmfauzan.e_potential;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AfterPlayer extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_player);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        String uname = getIntent().getStringExtra("Username");
        TextView tvs = (TextView) findViewById(R.id.tvNamePlayer);
        tvs.setText(uname);

        textView = (TextView) findViewById(R.id.tvLanjutkan);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tvLanjutkan:
                Intent soal1 = new Intent(getApplicationContext(), soal1.class);
                startActivity(soal1);
                finish();
                break;
        }
    }
}
