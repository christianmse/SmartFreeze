package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.smartfreeze.domain.Producto;
import com.smartfreeze.util.Stock;

import java.util.ArrayList;
import java.util.HashMap;

public class SeleccionCajon extends AppCompatActivity {

    private ImageView iVNeveraAbierta, iVFrigoAbierto;
    private String elemento;
    private Producto elementop;
    private Button b3CajonF, b2CajonF, b1CajonF, b1Nevera, b2Nevera, b3Nevera, b4Nevera,
            b1Estante, b2Estante, b3Estante;

    private HashMap<Integer, ArrayList<Producto>> cambioaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_seleccion_cajon);
            Intent intent1 = getIntent();
//            elemento = intent1.getStringExtra("Elemento");
            elementop = intent1.getParcelableExtra("Elemento");
    /*        if(elemento != null){
                Toast.makeText(this,elemento, Toast.LENGTH_LONG).show();
            }*/

            //        BOTONES DE LA NEVERA
            iVNeveraAbierta = findViewById(R.id.iVNeveraAbierta);
            iVNeveraAbierta.setVisibility(View.VISIBLE);
            b1Nevera = findViewById(R.id.b1Nevera1);
            b2Nevera = findViewById(R.id.b2Nevera1);
            b3Nevera = findViewById(R.id.b3Nevera1);
            b4Nevera = findViewById(R.id.b4CajonIzq1);
            b1Estante = findViewById(R.id.bEstante11);
            b2Estante =  findViewById(R.id.bEstante21);

            b3Estante = findViewById(R.id.bEstante31);

            //        BOTONES DEL FRIGORIFICO
            iVFrigoAbierto = findViewById(R.id.iVFrigoAbierto);
            iVFrigoAbierto.setVisibility(View.VISIBLE);
            b3CajonF = findViewById(R.id.b3Cajon1);

            b2CajonF = findViewById(R.id.b2Cajon1);

            b1CajonF = findViewById(R.id.b1Cajon1);

    //                3ª CAJON DEL FRIGORIFICO
            b3CajonF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon3f = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon3f.putExtra("CCajon", R.id.b3Cajon);
                    abrircajon3f.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN

                    startActivity(abrircajon3f);
                }
            });

            //        2ª CAJON DEL FRIGORIFICO
            b2CajonF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon32f = new Intent(SeleccionCajon.this, ListadoComida.class);    //MainActivity.class
                    abrircajon32f.putExtra("CCajon", R.id.b2Cajon);
                    abrircajon32f.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    startActivity(abrircajon32f);
                }
            });

            //        1ª CAJON DEL FRIGORIFICO
            b1CajonF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon1f = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon1f.putExtra("CCajon", R.id.b1Cajon);
                    abrircajon1f.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN

                    startActivity(abrircajon1f);
                }
            });


    //        1º CAJON DE LA NEVERA
            b1Nevera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon1n = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon1n.putExtra("CCajon", R.id.b1Nevera);
                    abrircajon1n.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    startActivity(abrircajon1n);
                }
            });

    //               2º CAJON DE LA NEVERA
            b2Nevera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon2n = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon2n.putExtra("CCajon", R.id.b2Nevera);
                    abrircajon2n.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    startActivity(abrircajon2n);
                }
            });

    //               3º CAJON DE LA NEVERA
            b3Nevera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon3n = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon3n.putExtra("CCajon", R.id.b3Nevera);
                    abrircajon3n.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    startActivity(abrircajon3n);
                }
            });
    //               4º CAJON DE LA NEVERA
            b4Nevera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon4n = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon4n.putExtra("CCajon", R.id.b4CajonIzq);
                    abrircajon4n.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    startActivity(abrircajon4n);
                }
            });

    //                1º CAJON DE LA PUERTA
            b1Estante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon1e = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon1e.putExtra("CCajon", R.id.bEstante1);
                    abrircajon1e.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    startActivity(abrircajon1e);
                }
            });

    //                2º CAJON DE LA PUERTA
            b2Estante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon2e = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon2e.putExtra("CCajon", R.id.bEstante2);
                    abrircajon2e.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    startActivity(abrircajon2e);
                }
            });

    //                3º CAJON DE LA PUERTA
            b3Estante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon3e = new Intent(SeleccionCajon.this, ListadoComida.class);     //MainActivity.class
                    abrircajon3e.putExtra("CCajon", R.id.b3Nevera);
                    abrircajon3e.putExtra("Elemento", elementop);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    startActivity(abrircajon3e);
                }
            });

        }

    }