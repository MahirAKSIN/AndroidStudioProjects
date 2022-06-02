package com.example.maodb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static VeritabanApp veritabanApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        veritabanApp = Room.databaseBuilder(getApplicationContext(), VeritabanApp.class, "kullaniciDB").allowMainThreadQueries().build();
        if (findViewById(R.id.cerceve_home)!=null) {

            if(savedInstanceState!=null){
            return;

            }
            fragmentManager.beginTransaction().add(R.id.cerceve_home,new homeFragment()).commit();
        }


    }
}