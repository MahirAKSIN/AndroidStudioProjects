package com.example.pbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar pBar;
    TextView txt;
    Timer tmr;
    int sayac = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pBar = (ProgressBar) findViewById(R.id.pBar_tmr);
        txt = (TextView) findViewById(R.id.txt_sayac);
        tmr = new Timer();
        TimerTask tmrTsk = new TimerTask() {
            @Override
            public void run() {
                sayac++;
                pBar.setProgress(sayac);
                if (sayac == 100) {
                    tmr.cancel();
                    
                }

            }
        };
        tmr.schedule(tmrTsk, 0, 100);
    }
}