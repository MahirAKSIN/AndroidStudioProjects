package com.example.s;

import android.content.Context;
import android.content.SharedPreferences;

public class paylasilanTercihYapilandirmasi {
    private SharedPreferences sharedPreferences;
    private Context context;

    public paylasilanTercihYapilandirmasi(Context c) {
        this.context = c;
        sharedPreferences = c.getSharedPreferences(c.getResources().getString(R.string.giris_tercih), Context.MODE_PRIVATE);
    }

    public void girisDurumuYaz(boolean durum) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.giris_durumu_tercihi), durum);
        editor.commit();
    }

    public boolean girisDurumuOku() {
        boolean durum = false;
        durum = sharedPreferences.getBoolean(context.getResources().getString(R.string.giris_durumu_tercihi), false);
        return durum;
    }







}
