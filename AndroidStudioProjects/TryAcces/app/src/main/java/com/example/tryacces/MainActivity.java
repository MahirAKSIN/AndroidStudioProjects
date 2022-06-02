package com.example.tryacces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tryacces.Kullanici;
import com.example.tryacces.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText txt_data, txt_email, txt_read;
    Button btn_add, btn_read;
    FirebaseDatabase database;
    DatabaseReference databaseReference = database.getReference();
    RecyclerView recyclerView;
    ArrayList<Kullanici> List;
    KullaniciAdaptor kullaniciAdaptor;
    DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_add = (Button) findViewById(R.id.btn_add);
        btn_read = (Button) findViewById(R.id.btn_read);



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = UUID.randomUUID().toString();
                String isim = txt_data.getText().toString();
                String email = txt_email.getText().toString();
                if (!TextUtils.isEmpty(isim) || (!TextUtils.isEmpty(email))) {
                    Kullanici users = new Kullanici(isim, email);
                    databaseReference.child("Users").child(id).setValue(users);
                    Toast.makeText(MainActivity.this, "Kullanici eklendi.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Bos alanlari doldurunuz...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        List = new ArrayList<Kullanici>();
        recyclerView = (RecyclerView) findViewById(R.id.myRecy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        kullaniciAdaptor = new KullaniciAdaptor(MainActivity.this, List);
        recyclerView.setAdapter(kullaniciAdaptor);

        DatabaseReference dataRead = FirebaseDatabase.getInstance().getReference().child("Users");
        dataRead.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Kullanici users = dataSnapshot.getValue(Kullanici.class);
                    List.add(users);

                }

                kullaniciAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Bilgiler gelmedi...", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
