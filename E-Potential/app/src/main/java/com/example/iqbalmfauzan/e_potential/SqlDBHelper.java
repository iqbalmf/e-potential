package com.example.iqbalmfauzan.e_potential;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Iqbal M Fauzan on 3/7/2016.
 */
public class SqlDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ADMINSOAL.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ UserContract.NewInfo.TABLE_NAME+"("+ UserContract.NewInfo.ADMIN_NOMER+" TEXT,"+ UserContract.NewInfo.ADMIN_SOAL+
                    " TEXT,"+ UserContract.NewInfo.ADMIN_JAWABAN_1+" TEXT,"+ UserContract.NewInfo.ADMIN_JAWABAN_2+
                    " TEXT,"+ UserContract.NewInfo.ADMIN_JAWABAN_3+" TEXT,"+ UserContract.NewInfo.ADMIN_JAWABAN_BENAR+" TEXT);";
    public SqlDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.e("DATABASE OPERATIONS", "DATABASE CREATED / OPENED...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS" ,"TABLE CREATED...");

    }

    public void addInformation(String no,String Soal, String Jawaban_1, String Jawaban_2, String Jawaban_3, String Jawaban_Benar, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewInfo.ADMIN_NOMER, no);
        contentValues.put(UserContract.NewInfo.ADMIN_SOAL, Soal);
        contentValues.put(UserContract.NewInfo.ADMIN_JAWABAN_1, Jawaban_1);
        contentValues.put(UserContract.NewInfo.ADMIN_JAWABAN_2, Jawaban_2);
        contentValues.put(UserContract.NewInfo.ADMIN_JAWABAN_3, Jawaban_3);
        contentValues.put(UserContract.NewInfo.ADMIN_JAWABAN_BENAR, Jawaban_Benar);
        db.insert(UserContract.NewInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "ONE ROW INSERTED...");

    }

    public Cursor getInformation(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {UserContract.NewInfo.ADMIN_NOMER, UserContract.NewInfo.ADMIN_SOAL, UserContract.NewInfo.ADMIN_JAWABAN_1,
                UserContract.NewInfo.ADMIN_JAWABAN_2, UserContract.NewInfo.ADMIN_JAWABAN_3, UserContract.NewInfo.ADMIN_JAWABAN_BENAR
        };
        cursor = db.query(UserContract.NewInfo.TABLE_NAME, projections,null,null,null,null,null);
        return cursor;
    }

    public Cursor getContact(String nomer, SQLiteDatabase sqLiteDatabase){
        String[] projections = {UserContract.NewInfo.ADMIN_SOAL, UserContract.NewInfo.ADMIN_JAWABAN_1, UserContract.NewInfo.ADMIN_JAWABAN_2,
                UserContract.NewInfo.ADMIN_JAWABAN_3, UserContract.NewInfo.ADMIN_JAWABAN_BENAR};
        String selection = UserContract.NewInfo.ADMIN_NOMER+" LIKE ?";
        String[] selection_args = {nomer};
        Cursor cursor = sqLiteDatabase.query(UserContract.NewInfo.TABLE_NAME,projections,selection,selection_args,null,null,null);
        return cursor;

    }

    public void deleteInformation(String nomer, SQLiteDatabase sqLiteDatabase)
    {
        String selection = UserContract.NewInfo.ADMIN_NOMER+" LIKE ?";
        String[] selection_args = {nomer};
        sqLiteDatabase.delete(UserContract.NewInfo.TABLE_NAME,selection,selection_args);
    }

    public int updateInformation(String oldnomer, String newSoal,  String newA, String newB, String newC, String newD, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewInfo.ADMIN_SOAL,newSoal);
        contentValues.put(UserContract.NewInfo.ADMIN_JAWABAN_1,newA);
        contentValues.put(UserContract.NewInfo.ADMIN_JAWABAN_2,newB);
        contentValues.put(UserContract.NewInfo.ADMIN_JAWABAN_3,newC);
        contentValues.put(UserContract.NewInfo.ADMIN_JAWABAN_BENAR,newD);
        String selection = UserContract.NewInfo.ADMIN_NOMER+" LIKE ?";
        String [] selection_args = {oldnomer};
        int count = sqLiteDatabase.update(UserContract.NewInfo.TABLE_NAME,contentValues,selection,selection_args);
        return count;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
