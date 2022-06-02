package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static VeritabaniApp veritabaniApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        veritabaniApp = Room.databaseBuilder(getApplicationContext(), VeritabaniApp.class, "kullaniciDB").
                allowMainThreadQueries().build();


        if (findViewById(R.id.cerceve_kapdayici) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.cerceve_kapdayici, new HomeFragment()).commit();

        }
    }
}