package com.example.bilgigecis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bilgiAlan extends AppCompatActivity {
    TextView txt_isimSoyisim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi_alan);
        txt_isimSoyisim = (TextView) findViewById(R.id.txt_isimSoyisim);

        Intent gel = getIntent();
        String isim = gel.getStringExtra("isim");
        String soyad = gel.getStringExtra("soyad");

        txt_isimSoyisim.setText(isim + " " + soyad);

    }
}