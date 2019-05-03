package com.example.hastakayit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbBaglanti {
private static DbBaglanti INSTANCE;
private static Context context;
private static SQLiteDatabase database;
private static MySQLiteHelper mySQLiteHelper;

    public DbBaglanti() {
        mySQLiteHelper=new MySQLiteHelper(context);
    }
    public static DbBaglanti getInstance(Context context){
        DbBaglanti.context=context;
        if(INSTANCE == null){
            INSTANCE=new DbBaglanti();
        }
        return INSTANCE;
    }
    private void dbAc(){
        database=mySQLiteHelper.getWritableDatabase();
    }
    private void dbKapa(){
        database.close();
    }

    public List<Bilgi> veriCek(){
        List<Bilgi> bilgiList= new ArrayList<>();
        String sql="SELECT * FROM HastaKayit";
        Bilgi bilgi = new Bilgi();
        dbAc();
        Cursor cursor = database.rawQuery(sql,null);
        if(cursor!=null&&cursor.getCount()!=0){
            while (cursor.moveToNext()){
                bilgi.setAdres(cursor.getString(cursor.getColumnIndex("adres")));
                bilgi.setCinsiyet(cursor.getString(cursor.getColumnIndex("cinsiyet")));
                bilgi.setDoktor_ad(cursor.getString(cursor.getColumnIndex("doktor_ad")));
                bilgi.setHasta_ad(cursor.getString(cursor.getColumnIndex("hasta_ad")));
                bilgi.setTc_no(cursor.getString(cursor.getColumnIndex("tc_no")));
                bilgi.setTel_no(cursor.getString(cursor.getColumnIndex("tel_no")));
                bilgi.setYas(cursor.getString(cursor.getColumnIndex("yas")));
                bilgi.setHasta_soyad(cursor.getString(cursor.getColumnIndex("hasta_soyad")));
                bilgiList.add(bilgi);
            }
        }
        dbKapa();
        return  bilgiList;
    }
}
