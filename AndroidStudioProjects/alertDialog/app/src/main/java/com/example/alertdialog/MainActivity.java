package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder uyariWin;
    Button btn_uyari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uyariWin = new AlertDialog.Builder(MainActivity.this);
        btn_uyari = (Button) findViewById(R.id.btn_gonder);

        uyariWin.setTitle("Uyari Durumu");
        uyariWin.setMessage("Uygun secenegi seciniz...");
        btn_uyari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uyariWin = uyariWin.setPositiveButton("Onayla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Afiyet olsun", Toast.LENGTH_LONG).show();
                    }
                });
                uyariWin = uyariWin.setNegativeButton("Vacgec", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                uyariWin.show();
            }
        });


    }
}