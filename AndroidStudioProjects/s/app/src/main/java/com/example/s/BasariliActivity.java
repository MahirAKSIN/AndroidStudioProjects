package com.example.s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BasariliActivity extends AppCompatActivity {
    EditText txt;
    public paylasilanTercihYapilandirmasi paylasilanTercihYapilandirmasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basarili);
        paylasilanTercihYapilandirmasi = new paylasilanTercihYapilandirmasi(getApplicationContext());
        Intent intent = getIntent();
        String val = intent.getStringExtra("Kadi");
        txt = (EditText) findViewById(R.id.txt_hosgeldiniz);
        txt.setText(val);
    }

    public void cikisYap(View view) {
        paylasilanTercihYapilandirmasi.girisDurumuYaz(false);
        Intent intent = new Intent(BasariliActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}