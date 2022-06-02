package com.example.s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText txt_kSifre, txt_kAdi;
    public paylasilanTercihYapilandirmasi paylasilanTercihYapilandirmasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_kAdi = (EditText) findViewById(R.id.txt_kullaniciAdi);
        txt_kSifre = (EditText) findViewById(R.id.txt_pass);
        paylasilanTercihYapilandirmasi = new paylasilanTercihYapilandirmasi(getApplicationContext());


        if (paylasilanTercihYapilandirmasi.girisDurumuOku()) {
            Intent intent = new Intent(MainActivity.this, BasariliActivity.class);
            startActivity(intent);
            finish();
        }
    }
      public void girisYap(View view) {
        String kullaniciAdi = txt_kAdi.getText().toString();
        String kullaniciPass = txt_kSifre.getText().toString();
        if ((kullaniciAdi.equals(getResources().getString(R.string.kullanici_adi)) &&
                (kullaniciPass.equals(getResources().getString(R.string.kullanici_sifre))))) {
            Toast.makeText(MainActivity.this, "Giris basarili", Toast.LENGTH_LONG);
            Intent intent = new Intent(MainActivity.this, BasariliActivity.class);
            String str = txt_kAdi.getText().toString();
            intent.putExtra("Kadi", str);
            startActivity(intent);
            paylasilanTercihYapilandirmasi.girisDurumuYaz(true);
            finish();
        } else {
            Toast.makeText(MainActivity.this, "Giris bilgilerinizi kontrol ediniz..", Toast.LENGTH_LONG);
            txt_kAdi.setText("");
            txt_kSifre.setText("");
        }

    }
}