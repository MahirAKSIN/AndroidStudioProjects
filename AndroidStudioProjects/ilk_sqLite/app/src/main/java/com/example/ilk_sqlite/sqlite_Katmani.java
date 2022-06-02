package com.example.ilk_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.PortUnreachableException;

import dalvik.system.BaseDexClassLoader;

public class sqlite_Katmani extends SQLiteOpenHelper {

    public sqlite_Katmani(Context c) {
        super(c, "kullanici", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table kullanici (id integer primary key autoincrement ," +
                "isim text not null)";
        db.execSQL(sql);
   }

    public void onUpgrade(SQLiteDatabase db, int eski, int yeni) {
        db.execSQL("drop table if exists kullanici ");
    }

//drop table if exists kullanici
}
