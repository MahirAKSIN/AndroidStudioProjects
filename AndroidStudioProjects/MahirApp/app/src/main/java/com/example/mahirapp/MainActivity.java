package com.example.mahirapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView txt;
    Button btn;
    int say = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt_sayac);
        if (savedInstanceState != null) {
            say = savedInstanceState.getInt("sayac");
            txt.setText("sayac : " + say);
        } else {
            say = 0;
        }

        btn = (Button) findViewById(R.id.btn_say);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                say++;
                txt.setText("sayac : " + say);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sayac", say);
    }


}
