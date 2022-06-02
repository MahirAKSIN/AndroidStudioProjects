package com.example.gsdb;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kullanici")
public class kullanici {

    @PrimaryKey
    int id;
    @ColumnInfo()
    String isim;
    @ColumnInfo()
    String adres;
    @ColumnInfo
    Double mass;


}
