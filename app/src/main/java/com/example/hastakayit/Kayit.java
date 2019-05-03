package com.example.hastakayit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Kayit extends AppCompatActivity {
    EditText h_tc,h_ad,h_soyad,h_yas,h_adres,h_tel;
    Context context = this;
    RadioButton rd_erkek,rd_kadın,rd_doc1,rd_doc2,rd_doc3;
    RadioButton rb_cinsiyet,rb_doktor;
    RadioGroup rg1,rg2;
    MySQLiteHelper mySQLiteHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit_layout);
        h_tc=findViewById(R.id.ed_tc);
        h_ad=findViewById(R.id.ed_ad);
        h_soyad=findViewById(R.id.ed_soyad);
        h_yas=findViewById(R.id.ed_yas);
        h_adres=findViewById(R.id.ed_adres);
        h_tel=findViewById(R.id.ed_tel);
        rd_erkek=findViewById(R.id.r_erkek);
        rd_kadın=findViewById(R.id.r_kadın);
        rd_doc1=findViewById(R.id.r_doc1);
        rd_doc2=findViewById(R.id.r_doc2);
        rd_doc3=findViewById(R.id.r_doc3);
        rg1=findViewById(R.id.rgroup_cinsiyet);
        rg2=findViewById(R.id.rgroup_doktor);
    }
    public void rbclick1(View v){
    int radiobuttonid1 = rg1.getCheckedRadioButtonId();
    rb_cinsiyet=(RadioButton)findViewById(radiobuttonid1);
    }
    public void rbclick2(View v){
    int radiobuttonid2 = rg2.getCheckedRadioButtonId();
    rb_doktor=(RadioButton)findViewById(radiobuttonid2);
    }
    public void addContact(View view) {

        String tc = h_tc.getText().toString();
        String ad = h_ad.getText().toString();
        String soyad = h_soyad.getText().toString();
        String yas = h_yas.getText().toString();
        String adres = h_adres.getText().toString();
        String tel = h_tel.getText().toString();
        String cinsiyet = rb_doktor.getText().toString();
        String doktor = rb_cinsiyet.getText().toString();
        mySQLiteHelper = new MySQLiteHelper(context);
        sqLiteDatabase = mySQLiteHelper.getWritableDatabase();
        mySQLiteHelper.addInformations(tc,ad,soyad,yas,adres,tel,cinsiyet,doktor,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        mySQLiteHelper.close();
    }
}
