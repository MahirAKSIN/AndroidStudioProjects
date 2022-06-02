package com.example.bilgigecis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editIsim,editSoyad;
    Button btn_gonder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editIsim=(EditText) findViewById(R.id.txt_isim);
        editSoyad=(EditText) findViewById(R.id.txt_soyad);
        btn_gonder=(Button) findViewById(R.id.btn_gonder);

        btn_gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String isimAl= editIsim.getText().toString();
                String soyadAl= editSoyad.getText().toString();

                Intent git=new Intent(MainActivity.this,bilgiAlan.class);
                git.putExtra("isim",isimAl);
                git.putExtra("soyad",soyadAl);
                startActivity(git);
            }
        });

    }
    }
