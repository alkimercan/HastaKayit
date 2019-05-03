package com.example.hastakayit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.example.hastakayit.UserContract.NewUserInfo.TABLE_NAME;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "KayitSistemi.db";
    private static final int DATABASE_VERSION = 1;
    private static SQLiteDatabase db;
    private static MySQLiteHelper mySQLiteHelper;

    private static final String CREATE_QUERY="CREATE TABLE "+ TABLE_NAME+"("+UserContract.NewUserInfo.TC_NO+" TEXT,"+UserContract.NewUserInfo.CINSIYET+" TEXT,"+
            UserContract.NewUserInfo.ADRES+" TEXT,"+UserContract.NewUserInfo.DOKTOR_AD+" TEXT,"+UserContract.NewUserInfo.HASTA_AD+" TEXT,"+UserContract.NewUserInfo.HASTA_SOYAD+" TEXT,"+
            UserContract.NewUserInfo.TEL_NO+" TEXT,"+UserContract.NewUserInfo.YAS+" TEXT);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db=this.getWritableDatabase();
        Log.e("DATABASE OPERATIONS","Database created / opened");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table created...");
    }
    public void addInformations(String tc,String ad,String soyad,String yasi,String adresi,String tel,String doktoru,String cinsiyeti,SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TC_NO",tc);
        contentValues.put("HASTA_AD",ad);
        contentValues.put("HASTA_SOYAD",soyad);
        contentValues.put("YAS",yasi);
        contentValues.put("ADRES",adresi);
        contentValues.put("TEL_NO",tel);
        contentValues.put("CINSIYET",cinsiyeti);
        contentValues.put("DOKTOR_AD",doktoru);
        db.insert(TABLE_NAME,null,contentValues);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}
