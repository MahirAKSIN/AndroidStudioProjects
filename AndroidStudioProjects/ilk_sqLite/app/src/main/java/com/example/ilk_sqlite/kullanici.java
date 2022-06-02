package com.example.ilk_sqlite;

public class kullanici {
    String isim;
    int id;

    public kullanici(String isim) {
        this.isim = isim;
    }

    public kullanici(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public int getId() {
        return id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "" + id + "-" + isim;

    }
}
