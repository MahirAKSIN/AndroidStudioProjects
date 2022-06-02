package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BaslangicActivity extends AppCompatActivity {

    Button btn_giriB, btn_kaydolB;

    FirebaseUser baslangicKullanici;
    FirebaseUser deniz;

    @Override
    protected void onStart() {
        super.onStart();
        baslangicKullanici = FirebaseAuth.getInstance().getCurrentUser();
        if (baslangicKullanici != null) {
            startActivity(new Intent(BaslangicActivity.this, GirisYapActivity.class));
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baslangic);
        btn_giriB = (Button) findViewById(R.id.btn_girisB);
        btn_kaydolB = (Button) findViewById(R.id.btn_kaydolB);
        btn_giriB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaslangicActivity.this, GirisYapActivity.class);
                startActivity(intent);
                finish();
            }

        });
        btn_kaydolB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaslangicActivity.this, KaydolActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}