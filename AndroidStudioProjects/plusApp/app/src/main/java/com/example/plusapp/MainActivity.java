package com.example.plusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt_ilkSayi;
    EditText txt_ikinciSayi;
    EditText txt_sonuc;
    Button btn_topla1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_ilkSayi = (EditText) findViewById(R.id.txt_ilkSayi);
        txt_ikinciSayi = (EditText) findViewById(R.id.txt_ikinciSayi);
        txt_sonuc = (EditText) findViewById(R.id.txt_sonuc);
        btn_topla1 = (Button) findViewById(R.id.btn_toplam);
        btn_topla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double ilkSayi = Double.parseDouble(txt_ilkSayi.getText().toString());
                Double ikinciSayi = Double.parseDouble(txt_ikinciSayi.getText().toString());

                Double sonuc= ilkSayi / ikinciSayi;
               txt_sonuc.setText(sonuc.toString());

                Toast.makeText(MainActivity.this,"Sonuc :" +txt_sonuc.getText(),Toast.LENGTH_LONG).show();

            }
        });

    }
}