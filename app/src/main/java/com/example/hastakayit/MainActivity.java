package com.example.hastakayit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button kayit,listele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kayit=findViewById(R.id.kayit_btn);
        listele=findViewById(R.id.liste_btn);
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(MainActivity.this, Kayit.class);
            startActivity(i);
            }
        });
        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(MainActivity.this, Listeleme.class);
                startActivity(b);
            }
        });
    }
}
