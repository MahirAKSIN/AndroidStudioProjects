package com.example.baslangic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (TextUtils.isEmpty(textview.getText().toString())) {
            Toast.makeText(MainActivity.this, "Alanlari doldurunuz", Toast.LENGTH_SHORT).show();

        }

    }
}