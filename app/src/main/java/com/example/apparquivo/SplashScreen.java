package com.example.apparquivo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2200)
                .withBackgroundColor(Color.parseColor("#074E72"))
                .withLogo(R.mipmap.logo_adporto)
                .withFooterText("Copyright 2019")
                .withBeforeLogoText(getString(R.string.bem_vindo));


        //Set Text Color
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextSize(25);

        //Set to view

        View view = config.create();


        //Set view to content view
        setContentView(view);

    }
}
