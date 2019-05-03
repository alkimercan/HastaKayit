package com.example.hastakayit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class Listeleme extends AppCompatActivity {
    List<Bilgi> liste;
    Bilgi bilgi2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listeleme_layout);
        liste=DbBaglanti.getInstance(getApplicationContext()).veriCek();
        bilgi2=liste.get(0);
        tv.setText(bilgi2.getAdres());
        int deneme =0;
    }

}
