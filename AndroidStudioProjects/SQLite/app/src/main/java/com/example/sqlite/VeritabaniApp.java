package com.example.sqlite;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;

@Database(entities = kullanici.class, version = 1)
public abstract class VeritabaniApp extends RoomDatabase {

    public abstract BenimDao benimDao();

}
