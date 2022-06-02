package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText txt_metin, txt_veri;
    Button btn_kaydet, btn_veriAlma;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_veri = (EditText) findViewById(R.id.txt_veriAlma);
        txt_metin = (EditText) findViewById(R.id.yxy_text);
        btn_kaydet = (Button) findViewById(R.id.btn_kaydet);
        btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String veriYazdır = txt_metin.getText().toString();
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Msj");
                reference.setValue(veriYazdır);
            }
        });
        btn_veriAlma = (Button) findViewById(R.id.btn_veriAlma);
        btn_veriAlma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String getDataa = snapshot.getValue(String.class);
                        txt_veri.setText(getDataa);
                        Log.d("mesaj : ", getDataa);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        error.getMessage();
                    }
                });
            }
        });
    }
}