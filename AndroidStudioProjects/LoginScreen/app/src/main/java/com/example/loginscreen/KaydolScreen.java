package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class KaydolScreen extends AppCompatActivity {
    EditText eTxt, eTxt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol_screen);
        eTxt = (EditText) findViewById(R.id.txt_ad);
        eTxt1 = (EditText) findViewById(R.id.txt_pass);
        Intent msj = getIntent();
        String msjAl = msj.getStringExtra("mess");
        String msjAl1 = msj.getStringExtra("pass");
        eTxt.setText(msjAl);
        eTxt1.setText(msjAl1);


    }
}