package com.example.ilk_sqlite;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {
    veriKaynagi vk;
    ArrayAdapter<kullanici> arrayAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vk = new veriKaynagi(this);
        vk.ac();
        // List<kullanici> kullanicilar = vk.listele();
        final ArrayAdapter<kullanici> adaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vk.listele());
        setListAdapter(adaptor);
        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            //{"Mahir Aksin", "Eren ESE", "Erhan Caglar Bayram", "Ercüment Akyurt"};
            public void onClick(View view) {
                String isiler[] = new String[4];
                isiler[0] = "Ercument Akyurt";
                isiler[1] = "Erhan Caglar Bayram";
                isiler[2] = "Eren Ese";
                isiler[3] = "Mahir Aksin";
                Random rd = new Random();
                int ras = rd.nextInt(3);
                kullanici k = new kullanici(isiler[ras]);
                int sonid = vk.kullaniciOlustur(k.getIsim());
                k.setId(sonid);
                adaptor.add(k);
            }
        });
        Button btn_sil = (Button) findViewById(R.id.btn_delete);
        btn_sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    kullanici k = (kullanici) getListAdapter().getItem(0);
                    vk.kullaniciSil(k);
                    adaptor.remove(k);
                } catch (Exception e) {
                    Log.d("mesaj", "Kayitli kişi kalmadi");
                }
            }
        });
    }

    protected void onResume() {
        vk.ac();
        super.onResume();
    }

    protected void onPause() {
        vk.kapat();
        super.onPause();
    }
}