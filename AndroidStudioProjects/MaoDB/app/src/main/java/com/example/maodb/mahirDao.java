package com.example.maodb;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@SuppressWarnings("AndroidUnresolvedRoomSqlReference")
@Dao
public interface mahirDao {
    @Insert
    public void kuyllaniciEkle(Kullanici kullanici);

    @Query(value = "select * from kullanici")
    public List<Kullanici> kullaniciGoster();

    @Delete
    public  void kullaniciSil(Kullanici  kullanici);

    @Update
    public void kullaniciGuncelle(Kullanici kullanici);

  //  @Query("select id from kullanici where kullanici.isim=ad ")
   // public  void idGoster(Kullanici kullanici,String ad);
}
