package com.example.startstop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int x = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("", "onCreat: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("", "onStart: ");
        x = 11;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("", "onStop: ");
        x = 12;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("", "onResume: ");
        x = 13;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("", "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("", "onDestroy: ");
    }


}