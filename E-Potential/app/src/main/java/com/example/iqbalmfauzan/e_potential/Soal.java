package com.example.iqbalmfauzan.e_potential;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Soal extends AppCompatActivity implements View.OnClickListener{
    EditText etSoal, etJawaban1, etJawaban2, etJawaban3,etJawabanBenar,nomer;
    Button btSubmit;
    Context context = this;
    SqlDBHelper sqlDBHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        nomer = (EditText) findViewById(R.id.etnomer);
        etSoal = (EditText) findViewById(R.id.etSoal);
        etJawaban1 = (EditText) findViewById(R.id.etJawaban1);
        etJawaban2 = (EditText) findViewById(R.id.etJawaban2);
        etJawaban3 = (EditText) findViewById(R.id.etJawaban3);
        etJawabanBenar = (EditText) findViewById(R.id.etJawabanBenar);
        btSubmit = (Button) findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btSubmit:
                String Nomer = nomer.getText().toString();
                String Soal = etSoal.getText().toString();
                String Jawaban_1 = etJawaban1.getText().toString();
                String Jawaban_2 = etJawaban2.getText().toString();
                String Jawaban_3 = etJawaban3.getText().toString();
                String Jawaban_Benar = etJawabanBenar.getText().toString();

                EditText nomer = (EditText) findViewById(R.id.etnomer);
                EditText etsoal = (EditText) findViewById(R.id.etSoal);
                EditText etJawaban1 = (EditText) findViewById(R.id.etJawaban1);
                EditText etJawaban2 = (EditText) findViewById(R.id.etJawaban2);
                EditText etJawaban3 = (EditText) findViewById(R.id.etJawaban3);
                EditText etJawabanBenar = (EditText) findViewById(R.id.etJawabanBenar);

                if (etsoal.getText().toString().equals("")) {
                    Toast toa = Toast.makeText(Soal.this, "Data tidak boleh Kosong", Toast.LENGTH_SHORT);
                    toa.show();
                }
                    else if (etJawaban1.getText().toString().equals("")) {
                        Toast toa1 = Toast.makeText(Soal.this, "Data tidak boleh Kosong", Toast.LENGTH_SHORT);
                        toa1.show();
                    }
                       else if (etJawaban2.getText().toString().equals("")) {
                            Toast toa2 = Toast.makeText(Soal.this, "Data tidak boleh Kosong", Toast.LENGTH_SHORT);
                            toa2.show();
                        }
                            else if (etJawaban3.getText().toString().equals("")) {
                                Toast toa3 = Toast.makeText(Soal.this, "Data tidak boleh Kosong", Toast.LENGTH_SHORT);
                                toa3.show();
                            }
                               else if (etJawabanBenar.getText().toString().equals(""))
                                {
                                    Toast toabenar = Toast.makeText(Soal.this, "Data tidak boleh Kosong" , Toast.LENGTH_SHORT);
                                    toabenar.show();
                                }
                                    else if (nomer.getText().toString().equals("")) {
                                        Toast toa3 = Toast.makeText(Soal.this, "Data tidak boleh Kosong", Toast.LENGTH_SHORT);
                                        toa3.show();
                                    }
                else
                {
                    sqlDBHelper = new SqlDBHelper(context);
                    sqLiteDatabase = sqlDBHelper.getWritableDatabase();
                    sqlDBHelper.addInformation(Nomer,Soal,Jawaban_1,Jawaban_2,Jawaban_3,Jawaban_Benar,sqLiteDatabase);
                    Toast.makeText(getBaseContext(),"Data Submited", Toast.LENGTH_SHORT).show();
                    sqlDBHelper.close();
                    v.setVisibility(View.INVISIBLE);
                    finish();
                    Intent mulaisplash = new Intent(getApplicationContext(), AfterAdmin.class);
                    startActivity(mulaisplash);
                    finish();
                }
                break;
        }
    }
}
