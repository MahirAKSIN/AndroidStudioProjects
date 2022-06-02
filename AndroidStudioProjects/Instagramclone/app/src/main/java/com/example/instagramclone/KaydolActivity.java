package com.example.instagramclone;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class KaydolActivity extends AppCompatActivity {

    EditText txt_kAdi, txt_isim, txt_email, txt_sifre;
    Button btn_kaydol, btn_xxx;
    TextView txt_giriSayfasinaGİt;
    FirebaseAuth yetki;
    DatabaseReference yol;
    ProgressDialog pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);


        txt_kAdi = (EditText) findViewById(R.id.xt_kullaniciAdi);
        txt_isim = (EditText) findViewById(R.id.xt_adK);
        txt_email = (EditText) findViewById(R.id.xt_emailK);
        txt_sifre = (EditText) findViewById(R.id.xt_sifreK);
        btn_kaydol = (Button) findViewById(R.id.btn_kaydolK);
        txt_giriSayfasinaGİt = (TextView) findViewById(R.id.txt_girisSayfasinaGit);
        yetki = FirebaseAuth.getInstance();
        txt_giriSayfasinaGİt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KaydolActivity.this, GirisYapActivity.class);
                startActivity(intent);
            }
        });
        btn_kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pb = new ProgressDialog(KaydolActivity.this);
                pb.setMessage("Kayit ediliyor..");
                pb.show();

                String kAdi = txt_kAdi.getText().toString();
                String isim = txt_isim.getText().toString();
                String email = txt_email.getText().toString();
                String sifre = txt_sifre.getText().toString();


                if (TextUtils.isEmpty(kAdi) || TextUtils.isEmpty(isim) || TextUtils.isEmpty(email) || TextUtils.isEmpty(sifre)) {
                    Toast.makeText(KaydolActivity.this, "Bos alanlari doldurunuz...", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(String.valueOf(txt_sifre.getText())) < 6) {
                    Toast.makeText(KaydolActivity.this, "Sifreniz 6 karakterden fazla olmalidir...", Toast.LENGTH_SHORT).show();
                } else {
                    Kaydet(kAdi, isim, email, sifre);
                    pb.dismiss();
                }
            }
        });
    }

    public void Kaydet(final String kAdi, final String isim, final String email, final String sifre) {
        yetki.createUserWithEmailAndPassword(email, sifre)
                .addOnCompleteListener(KaydolActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            FirebaseUser firebaseKullanici = yetki.getCurrentUser();
                            String kullaniciId = yetki.getUid();
                            yol = FirebaseDatabase.getInstance().getReference().child("kullanicilar").child(kullaniciId);

                            HashMap<String, Object> hashMap = new HashMap<>();

                            hashMap.put("id", kullaniciId);
                            hashMap.put("kullaniciAdi", kAdi.toLowerCase());
                            hashMap.put("Isim", isim);
                            hashMap.put("bio", "");
                            hashMap.put("resimUrl", "https://firebasestorage.googleapis.com/v0/b/instagramclone-51109.appspot.com/o/egg.png?alt=media&token=e8d57618-871a-42cf-ae20-74c28cc3d0ac");

                            yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(KaydolActivity.this, AnaSayfaActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        pb.dismiss();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(KaydolActivity.this, "BU sifre veya email ile kayit basarisiz... ", Toast.LENGTH_SHORT).show();
                            pb.dismiss();
                        }
                    }
                });
    }
}