package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.instagramclone.Cerceve.AramaFragment;
import com.example.instagramclone.Cerceve.BildirimFragment;
import com.example.instagramclone.Cerceve.HomeFragment;
import com.example.instagramclone.Cerceve.ProfilFragment;
import com.example.instagramclone.model1.kullanicilar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class AnaSayfaActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView, x;
    Fragment secili_cerceve = new Fragment();
    Fragment ddddd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        getSupportFragmentManager().beginTransaction().replace(R.id.cerceve_kapsayici, new HomeFragment()).commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnItemSelectedListener(itemSelectedListener);
    }

    private NavigationBarView.OnItemSelectedListener itemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.nav_home:
                    secili_cerceve = new HomeFragment();
                    break;
                case R.id.nav_arama:
                    secili_cerceve = new AramaFragment();
                    break;
                case R.id.nav_ekle:
                    secili_cerceve = null;
                    startActivity(new Intent(AnaSayfaActivity.this, kullanicilar.GonderiActivity.class));
                    break;
                case R.id.nav_kalp:
                    secili_cerceve = new BildirimFragment();
                    break;
                case R.id.nav_profil:

                    SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                    editor.putString("profilID", FirebaseAuth.getInstance().getCurrentUser().getUid());
                    editor.apply();
                    secili_cerceve = new ProfilFragment();
                    break;
            }
            if (secili_cerceve != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.cerceve_kapsayici, secili_cerceve).commit();

            }
            return true;
        }
    };
}