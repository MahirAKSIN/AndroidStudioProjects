package com.example.maodb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities =Kullanici.class,version = 2)
public abstract class VeritabanApp extends RoomDatabase {
       public abstract mahirDao mahirDao();
}

