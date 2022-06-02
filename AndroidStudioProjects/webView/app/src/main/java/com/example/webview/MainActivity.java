package com.example.webview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView tarayıcı;
    EditText txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tarayıcı = (WebView) findViewById(R.id.web_url);
        txt = (EditText) findViewById(R.id.txt_url);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _url;
                _url = txt.getText().toString();
                tarayıcı.setWebViewClient(new WebViewClient());
                tarayıcı.loadUrl(_url);

            }

        });
    }

    @Override
    public void onBackPressed() {

        if (tarayıcı.canGoBack()) {
            tarayıcı.goBack();
        } else
            super.onBackPressed();
    }
}