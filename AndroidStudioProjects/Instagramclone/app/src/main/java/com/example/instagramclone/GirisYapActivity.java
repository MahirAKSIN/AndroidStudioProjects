package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GirisYapActivity extends AppCompatActivity {

    EditText txt_email, txt_sifre;
    Button btn_giris;
    TextView txt_kayitSayfasinaGit;
    ProgressDialog pb;

    FirebaseAuth girisYetkisi;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);

        txt_sifre = (EditText) findViewById(R.id.xt_sifreG);
        txt_email = (EditText) findViewById(R.id.xt_emailG);
        btn_giris = (Button) findViewById(R.id.btn_GirisG);
        txt_kayitSayfasinaGit = (TextView) findViewById(R.id.txtkayitSayfasinaGit);
        girisYetkisi = FirebaseAuth.getInstance();
        txt_kayitSayfasinaGit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                startActivity(new Intent(GirisYapActivity.this, KaydolActivity.class));
                finish();
            }
        });


        btn_giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb = new ProgressDialog(GirisYapActivity.this);
                pb.setMessage("Giris yapiliyor..");
                pb.show();

                String txt_emailG = txt_email.getText().toString();
                String txt_sifreG = txt_sifre.getText().toString();
                if (TextUtils.isEmpty(txt_emailG) || TextUtils.isEmpty(txt_sifreG)) {
                    Toast.makeText(GirisYapActivity.this, "Bos alanlari dolsurunuz...", Toast.LENGTH_SHORT).show();
                } else {
                    girisYetkisi.signInWithEmailAndPassword(txt_emailG, txt_sifreG)
                            .addOnCompleteListener(GirisYapActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        DatabaseReference yolYetkisi = FirebaseDatabase.getInstance().getReference()
                                                .child("kullanicilar").child(girisYetkisi.getCurrentUser().getUid());

                                        yolYetkisi.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                pb.dismiss();
                                                Intent intent = new Intent(GirisYapActivity.this, AnaSayfaActivity.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                                finish();
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {
                                                pb.dismiss();
                                            }
                                        });
                                    } else {
                                        Toast.makeText(GirisYapActivity.this, "Giris Basarisiz", Toast.LENGTH_LONG).show();
                                    }

                                }
                            });
                }
            }
        });
    }
}