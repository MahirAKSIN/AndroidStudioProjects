package com.example.httpurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.txt1);
        btn = (Button) findViewById(R.id.btn_click);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new ArkaPlan().execute("//http://192.168.1.110:8000/ listele");
                tv1.setText("Sunucu cevabi");

            }
        });
    }

    class ArkaPlan extends AsyncTask<String, String, String> {
        protected String doInBackground(String... params) {
            //ilk elemanı sunucu adresi url
            HttpURLConnection connection = null;
            BufferedReader bReader = null;
            try {
                URL url = new URL(params[0]);//http://127.0.0.1:8000/ listele
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                bReader = new BufferedReader(new InputStreamReader(is));
                String satir;
                String dosya = "";
                while ((satir = bReader.readLine()) != null) {
                    Log.d("Satir", satir);
                    dosya += satir;
                }
                return dosya;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "hata";
        }
    }

    protected void onPostExecute(String s) {
        Log.d("postExecuteGelen", s);
        tv1.setText(s);
    }
}