package com.example.iqbalmfauzan.e_potential;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListAcc extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    SqlDBHelper sqlDBHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_acc);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        listView = (ListView) findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        sqlDBHelper = new SqlDBHelper(getApplicationContext());
        sqLiteDatabase = sqlDBHelper.getReadableDatabase();
        cursor =sqlDBHelper.getInformation(sqLiteDatabase);
        if (cursor.moveToFirst())
        {
            do {
                String nomer, Soal,Jawaban_1, Jawaban_2, Jawaban_3,Jawaban_4;
                nomer = cursor.getString(0);
                Soal = cursor.getString(1);
                Jawaban_1 = cursor.getString(2);
                Jawaban_2 = cursor.getString(3);
                Jawaban_3 = cursor.getString(4);
                Jawaban_4 = cursor.getString(5);
                DataProvider dataProvider = new DataProvider(nomer,Soal,Jawaban_1,Jawaban_2,Jawaban_3,Jawaban_4);
                listDataAdapter.add(dataProvider);


            }while(cursor.moveToNext());
        }
    }
}
