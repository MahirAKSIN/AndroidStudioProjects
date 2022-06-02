package com.example.firebaseexp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar_menü;
    EditText txt_isim, txt_mail, uid;
    ProgressBar circular_progressBar;
    ListView list_datam;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<kullanici> kullaniciList = new ArrayList<>();
    private kullanici seciliKullanici;
    ListView lstMhr;
    kullanici kullanici = new kullanici();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar_menü = (Toolbar) findViewById(R.id.toolbar_menu);
        toolbar_menü.setTitle("Firebase");
        setSupportActionBar(toolbar_menü);


        txt_isim = (EditText) findViewById(R.id.txt_name);
        txt_mail = (EditText) findViewById(R.id.txt_email);
        list_datam = (ListView) findViewById(R.id.list_data);
        circular_progressBar = (ProgressBar) findViewById(R.id.progress_circular);

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

//        circular_progressBar.setVisibility(View.VISIBLE);
        //   list_datam.setVisibility(View.INVISIBLE);
        list_datam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                kullanici list_kullanici = (kullanici) adapterView.getItemAtPosition(i);
                seciliKullanici = list_kullanici;
                txt_isim.setText(list_kullanici.getName().toString());
                txt_mail.setText(list_kullanici.getEmail().toString());
            }
        });
        databaseReference.child("kullanicilar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot posnapshot) {
                if (kullaniciList.size() > 0) {
                    kullaniciList.clear();
                    for (DataSnapshot dataSnapshot : posnapshot.getChildren()) {
                        kullanici kullanici = dataSnapshot.getValue(kullanici.class);
                        kullaniciList.add(kullanici);

                    }

                    listViewAdapter adapter = new listViewAdapter(MainActivity.this, kullaniciList);
                    list_datam.setAdapter(adapter);

                    //  circular_progressBar.setVisibility(View.INVISIBLE);
                    //list_datam.setVisibility(View.VISIBLE);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item
    ) {

        if (item.getItemId() == R.id.btn_add) {

            kullaniciEkle();

        } else if (item.getItemId() == R.id.btn_update) {

            kullaniciGuncelle();

        } else if (item.getItemId() == R.id.btn_delete) {

            kullaniciSil(seciliKullanici);

        }

        return true;
    }

    private void kullaniciSil(kullanici seciliKullanici) {
        databaseReference.child("kullanicilar").child(seciliKullanici.getUid()).removeValue();
        kontrolTemizle();

    }

    private void kullaniciGuncelle() {
        kullanici kullanici = new kullanici(UUID.randomUUID().toString(),
                txt_isim.getText().toString(), txt_mail.getText().toString());
        databaseReference.child("kullanicilar").child(kullanici.getUid()).child("name").setValue(kullanici.getName());
        databaseReference.child("kullanicilar").child(kullanici.getUid()).child("email").setValue(kullanici.getEmail());

        kontrolTemizle();
    }

    private void kullaniciEkle() {
        kullanici kullanici = new kullanici(UUID.randomUUID().toString(),
                txt_isim.getText().toString(), txt_mail.getText().toString());

        databaseReference.child("kullanicilar").child(kullanici.getUid()).setValue(kullanici);
        kontrolTemizle();
    }

    public void kontrolTemizle() {
        txt_mail.setText("");
        txt_isim.setText("");

    }
}