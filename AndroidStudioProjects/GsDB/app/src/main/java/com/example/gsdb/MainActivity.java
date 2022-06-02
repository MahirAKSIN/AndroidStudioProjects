package com.example.gsdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    dataBaseApp DataBaseApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        DataBaseApp = Room.databaseBuilder(getApplicationContext(), dataBaseApp.class, "kullaniciDB").allowMainThreadQueries().build();

        if (findViewById(R.id.cerceve_frame) != null) {
            if (savedInstanceState != null) {
                return;
            }

            fragmentManager.beginTransaction().add(R.id.cerceve_frame,new HomeFragment()).commit();
        }
    }
}