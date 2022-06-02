package com.example.sss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txt1;
    EditText txt2;
    Button btn;
    Button btn_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (EditText) findViewById(R.id.txt_text1);
        txt2 = (EditText) findViewById(R.id.txt_text2);
        btn=(Button) findViewById(R.id.btn_birlestitr);
        btn_delete=(Button) findViewById(R.id.btn_sil);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setText((txt1.getText() +" "+ txt2.getText()).toString());
                Log.d("msj",(txt1.getText()+" "+ txt2.getText()));
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setText("Text See");
            }
        });
    }
}