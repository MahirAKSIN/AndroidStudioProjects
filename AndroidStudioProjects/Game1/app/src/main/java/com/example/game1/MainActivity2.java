package com.example.game1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();

        // String s = i.getStringExtra("mesaj");
        tv = (TextView) findViewById(R.id.txt_Isim);
        tv.setText(i.getStringExtra("mesaj"));
        btn = (Button) findViewById(R.id.btn_star);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setBackgroundResource(R.drawable.star);
            }
        });

        GridLayout gl = (GridLayout) findViewById(R.id.mahir);
        gl.addView(new kart(this));


    }

}