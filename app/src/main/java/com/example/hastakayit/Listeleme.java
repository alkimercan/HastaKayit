package com.example.hastakayit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

public class Listeleme extends AppCompatActivity {
    List<Bilgi> liste;
    Bilgi bilgi2;
    RecyclerView recyclerView;
    TrAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listeleme_layout);
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        liste=DbBaglanti.getInstance(getApplicationContext()).veriCek();
        adapter = new TrAdapter(this, liste);
        recyclerView.setAdapter(adapter);
    }

}
