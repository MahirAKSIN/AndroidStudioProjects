package com.example.dosya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            FileOutputStream fos = openFileOutput("Dosya", Context.MODE_PRIVATE);
            String mesaj = "bilgisayar Kavramları";
            fos.write(mesaj.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = openFileInput("Dosya");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            TextView tv = (TextView) findViewById(R.id.txt1);
            tv.setText(br.readLine());
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Resources r = getResources();
            InputStream isr = r.openRawResource(R.raw.deneme);
            Scanner s = new Scanner(isr);
            TextView tv = (TextView) findViewById(R.id.txt1);
            // String str = "";
            tv.setText(s.nextLine() + " "+ s.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}