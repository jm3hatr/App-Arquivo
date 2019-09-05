package com.example.apparquivo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton Sitebtn;
    Button Pesquisabtn;
    Button AquisicaoBtn;
    Button VisitaBtn;
    Button Calendariobtn;
    Button Contactosbtn;

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Localizar botões
        Sitebtn = (ImageButton) findViewById(R.id.siteBtn);
        Pesquisabtn = (Button) findViewById(R.id.pesquisaBtn);
        AquisicaoBtn = (Button) findViewById(R.id.aquisicaoBtn);
        VisitaBtn = (Button) findViewById(R.id.visitaBtn);
        //Calendariobtn = (Button) findViewById(R.id.calendarioBtn);
        Contactosbtn = (Button) findViewById(R.id.contactosBtn);


        String text = getString(R.string.deslizar_calendario);
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();


        //Açionar botão WebSite
        Sitebtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);

                startActivity(intent);
            }
        });


        //Acionar botão WebPesquisa
        Pesquisabtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PesquisaActivity.class);

                startActivity(intent);
            }

        });

        //Acionar Botao para ir para a actividade do Formulário de Aquisiçao de documentos
        AquisicaoBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AquisicaoActivity.class);

                startActivity(intent);
            }
        });

        //Acionar Botao para ir para a actividade do Formulário de Pedido de Visita
        VisitaBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VisitaActivity.class);

                startActivity(intent);
            }
        });



        /**
        //Botão Calendário
        Calendariobtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalendarioActivity.class);

                startActivity(intent);
            }
        }); **/




        //Acionar botão para Contactos
        Contactosbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactosActivity.class);

                startActivity(intent);
            }
        });

    }


    //SwipeLeft to Calendar
    public boolean onTouchEvent (MotionEvent touchEvent) {
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 > x2) {
                    Intent intent = new Intent(MainActivity.this, CalendarioActivity.class);
                    startActivity(intent);
                }
                break;
        }
        return false;
    }
}
