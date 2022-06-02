package com.example.instagramclone.model1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instagramclone.R;

public class kullanicilar {
    String id,kullaniciAd,ad,resimUrl,bio;

    public kullanicilar() {
    }

    public kullanicilar(String id, String kullaniciAd, String ad, String resimUrl, String bio) {
        this.id = id;
        this.kullaniciAd = kullaniciAd;
        this.ad = ad;
        this.resimUrl = resimUrl;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public static class GonderiActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gonderi);
        }
    }
}

