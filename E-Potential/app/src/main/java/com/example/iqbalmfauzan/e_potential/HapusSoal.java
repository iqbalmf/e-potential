package com.example.iqbalmfauzan.e_potential;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HapusSoal extends AppCompatActivity implements View.OnClickListener{

    TextView displaySoal, displayJawabanA, displayJawabanB, displayJawabanC,displayJawabanD;
    EditText cari;
    Button btCari,btHapus;

    SqlDBHelper sqlDBHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_nomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_soal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        cari = (EditText) findViewById(R.id.cari);
        displaySoal = (TextView) findViewById(R.id.displaysoal);
        displayJawabanA = (TextView) findViewById(R.id.displayA);
        displayJawabanB = (TextView) findViewById(R.id.displayB);
        displayJawabanC = (TextView) findViewById(R.id.displayC);
        displayJawabanD = (TextView) findViewById(R.id.displayD);
        btHapus = (Button) findViewById(R.id.bthapus);

        displaySoal.setVisibility(View.GONE);
        displayJawabanA.setVisibility(View.GONE);
        displayJawabanB.setVisibility(View.GONE);
        displayJawabanC.setVisibility(View.GONE);
        displayJawabanD.setVisibility(View.GONE);
        btHapus.setVisibility(View.GONE);


        btCari = (Button)findViewById(R.id.btcari);
        btCari.setOnClickListener(this);
        btHapus = (Button) findViewById(R.id.bthapus);
        btHapus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btcari:
                search_nomer = cari.getText().toString();
                sqlDBHelper = new SqlDBHelper(getApplicationContext());
                sqLiteDatabase = sqlDBHelper.getReadableDatabase();
                Cursor cursor = sqlDBHelper.getContact(search_nomer,sqLiteDatabase);

                if (cursor.moveToNext())
                {
                    String Soal = cursor.getString(0);
                    String JawabanA = cursor.getString(1);
                    String JawabanB = cursor.getString(2);
                    String JawabanC = cursor.getString(3);
                    String JawabanD = cursor.getString(4);

                    displaySoal.setText(Soal);
                    displayJawabanA.setText(JawabanA);
                    displayJawabanB.setText(JawabanB);
                    displayJawabanC.setText(JawabanC);
                    displayJawabanD.setText(JawabanD);

                    displaySoal.setVisibility(View.VISIBLE);
                    displayJawabanA.setVisibility(View.VISIBLE);
                    displayJawabanB.setVisibility(View.VISIBLE);
                    displayJawabanC.setVisibility(View.VISIBLE);
                    displayJawabanD.setVisibility(View.VISIBLE);

                    btHapus.setVisibility(View.VISIBLE);

                }

                if (cari.getText().toString().equals(""))
                {
                    Toast cari = Toast.makeText(HapusSoal.this, "Masukan Nomer Soal", Toast.LENGTH_SHORT);
                    cari.show();
                }



                break;

            case R.id.bthapus:
                sqlDBHelper = new SqlDBHelper(getApplicationContext());
                sqLiteDatabase = sqlDBHelper.getReadableDatabase();
                sqlDBHelper.deleteInformation(search_nomer,sqLiteDatabase);
                Toast delete = Toast.makeText(HapusSoal.this, "Delete Soal", Toast.LENGTH_SHORT);
                delete.show();
                Intent mulaisplash = new Intent(getApplicationContext(), AfterAdmin.class);
                startActivity(mulaisplash);
                finish();


                break;
        }
    }
}
