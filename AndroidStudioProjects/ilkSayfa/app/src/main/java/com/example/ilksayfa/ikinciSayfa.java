package com.example.ilksayfa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ikinciSayfa extends AppCompatActivity {
    Button btnilkGec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci_sayfa);
        btnilkGec = (Button) findViewById(R.id.btn_ilkeGec);
        btnilkGec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ilkGec = new Intent(ikinciSayfa.this, MainActivity.class);
                startActivity(ilkGec);
                Toast.makeText(ikinciSayfa.this, "ilk Sayfaya Gecti", Toast.LENGTH_LONG).show();

            }
        });


    }
}