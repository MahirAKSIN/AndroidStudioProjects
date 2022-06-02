package com.example.sqlite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BenimDao {
    @Insert
    public void kullaniciEkle(kullanici kullanici);

    @Query(value = "select * from kullanicilar")
    public List<kullanici> kullaniciGoster();

    @Delete
    public void kullaniciSil(kullanici kullanici);

    @Update
    public void kullaniciGuncelle(kullanici kullanici);

}
