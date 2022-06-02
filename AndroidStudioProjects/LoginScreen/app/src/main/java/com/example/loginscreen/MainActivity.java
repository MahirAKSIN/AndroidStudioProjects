package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText eTxt;
    String mess;
    EditText eTxt1;
    String Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTxt = (EditText) findViewById(R.id.txt_email);
        eTxt1 = (EditText) findViewById(R.id.txt_loginSifre);
        btn = (Button) findViewById(R.id.btn_kaydol);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(MainActivity.this, KaydolScreen.class);
                mess = eTxt.getText().toString();
                Pass = eTxt1.getText().toString();

                if ((mess.toString().equals(null)) && (!Pass.toString().equals(null))) {

                    Int.putExtra("mess", mess);
                    Int.putExtra("pass", Pass);
                    startActivity(Int);
                } else {
                    Toast.makeText(MainActivity.this, "Bos alanları doldurunuz!!!", Toast.LENGTH_SHORT).show();


                }
            }
        });

    }
}