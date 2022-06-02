package com.example.gsdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = kullanici.class,version =1)
public abstract class dataBaseApp extends RoomDatabase {

    public  abstract  myDao myDao();
}
