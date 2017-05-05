package com.example.iqbalmfauzan.e_potential;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditSoal extends AppCompatActivity implements View.OnClickListener{

    Button btCari,btedit;
    EditText nSoal, A,b,c,d;
    EditText cari;

    SqlDBHelper sqlDBHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_nomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_soal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        cari = (EditText) findViewById(R.id.cari);
        nSoal = (EditText) findViewById(R.id.newsoal);
        A = (EditText) findViewById(R.id.newA);
        b = (EditText) findViewById(R.id.newB);
        c = (EditText) findViewById(R.id.newC);
        d = (EditText) findViewById(R.id.newD);
        btedit = (Button) findViewById(R.id.btEdit);

        nSoal.setVisibility(View.GONE);
        A.setVisibility(View.GONE);
        b.setVisibility(View.GONE);
        c.setVisibility(View.GONE);
        d.setVisibility(View.GONE);
        btedit.setVisibility(View.GONE);

        btCari = (Button)findViewById(R.id.btcari);
        btCari.setOnClickListener(this);
        btedit = (Button)findViewById(R.id.btEdit);
        btedit.setOnClickListener(this);
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

                if (cursor.moveToFirst())
                {
                    String Soal = cursor.getString(0);
                    String JawabanA = cursor.getString(1);
                    String JawabanB = cursor.getString(2);
                    String JawabanC = cursor.getString(3);
                    String JawabanD = cursor.getString(4);

                    nSoal.setText(Soal);
                    A.setText(JawabanA);
                    b.setText(JawabanB);
                    c.setText(JawabanC);
                    d.setText(JawabanD);

                    nSoal.setVisibility(View.VISIBLE);
                    A.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);
                    c.setVisibility(View.VISIBLE);
                    d.setVisibility(View.VISIBLE);

                    btedit.setVisibility(View.VISIBLE);



                }

                break;
            case R.id.btEdit:
                sqlDBHelper = new SqlDBHelper(getApplicationContext());
                sqLiteDatabase = sqlDBHelper.getWritableDatabase();
                String Soal,a,nb,nc,nd;

                Soal = nSoal.getText().toString();
                a = A.getText().toString();
                nb = b.getText().toString();
                nc = c.getText().toString();
                nd = d.getText().toString();
                int count = sqlDBHelper.updateInformation(search_nomer,Soal,a,nb,nc,nd,sqLiteDatabase);
                Toast.makeText(getApplicationContext(),count+" Data Telah di Edit", Toast.LENGTH_SHORT).show();
                finish();

                break;
        }
    }
}
