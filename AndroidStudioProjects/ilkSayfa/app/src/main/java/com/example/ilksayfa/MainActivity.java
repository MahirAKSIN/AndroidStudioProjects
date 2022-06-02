package com.example.ilksayfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnIkiyeGec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIkiyeGec=(Button) findViewById(R.id.btn_ikiyeGec);
        btnIkiyeGec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ikiyeGec=new Intent(MainActivity.this,ikinciSayfa.class);
                startActivity(ikiyeGec);
                Toast.makeText(MainActivity.this,"ikinci Sayfaya Gecti",Toast.LENGTH_LONG).show();;
            }
        });
    }
}