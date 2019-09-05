package com.example.apparquivo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PesquisaActivity extends AppCompatActivity {

    private WebView pesquisaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        pesquisaView = (WebView) findViewById(R.id.pesquisaview);

        pesquisaView.setWebViewClient(new WebViewClient());
        pesquisaView.loadUrl("https://pesquisa.adporto.arquivos.pt/");

        WebSettings webSettings = pesquisaView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        pesquisaView.getSettings().setBuiltInZoomControls(true);
        pesquisaView.getSettings().setUseWideViewPort(true);


    }


    @Override
    public void onBackPressed() {
        if (pesquisaView.canGoBack()) {
            pesquisaView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
