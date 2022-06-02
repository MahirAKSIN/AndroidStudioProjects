package com.example.ilk_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class veriKaynagi {
    SQLiteDatabase db;
    sqlite_Katmani bdb;

    public veriKaynagi() {
        ac();
        kapat();
    }

    public veriKaynagi(Context c) {
        bdb = new sqlite_Katmani(c);
    }

    public void ac() {
        db = bdb.getWritableDatabase();
    }

    public void kapat() {
        bdb.close();
    }

    public int kullaniciOlustur(String isim) {
        //Varsayılan başlangıç boyutunu kullanarak boş bir değer kümesi oluşturur
        ContentValues val = new ContentValues();
        val.put("isim", isim);
        int sonId = (int) db.insert("kullanici", null, val);
        return sonId;
    }

    public void kullaniciSil(kullanici k) {
        int id = k.getId();
        db.delete("kullanici", "id=" + id, null);
    }

    public List<kullanici> listele() {
        List<kullanici> liste = new ArrayList<kullanici>();
        String[] kolonlar = {"id", "isim"};
        Cursor c = db.query("kullanici", kolonlar, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            int id = c.getInt(0);
            String isim = c.getString(1);
            String eleman = id + "" + isim;
            kullanici k = new kullanici(isim, id);
            liste.add(k);
            c.moveToNext();
        }
        c.close();
        return liste;
    }

    public int personBe(String isim) {
        ContentValues cV = new ContentValues();
        cV.put("isim", isim);
        int sonID = (int) db.insert("kullanici", null, cV);
        return sonID;
    }
}
