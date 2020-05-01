package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.smartfreeze.domain.Producto;
import com.smartfreeze.util.Stock;

public class SeleccionCajon extends AppCompatActivity {

    private ImageView iVNeveraAbierta, iVFrigoAbierto;
    private Producto elementop;
    private Button b3CajonF, b2CajonF, b1CajonF, b1Nevera, b2Nevera, b3Nevera, b4Nevera,
            b1Estante, b2Estante, b3Estante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_seleccion_cajon);
            Intent intent1 = getIntent();
            elementop = intent1.getParcelableExtra("Elemento");

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
                    Intent abrircajon3f = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon3f);
                }
            });

            //        2ª CAJON DEL FRIGORIFICO
            b2CajonF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon32f = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon32f);
                }
            });

            //        1ª CAJON DEL FRIGORIFICO
            b1CajonF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon1f = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon1f);
                }
            });


    //        1º CAJON DE LA NEVERA
            b1Nevera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon1n = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon1n);
                }
            });

    //               2º CAJON DE LA NEVERA
            b2Nevera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon2n = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon2n);
                }
            });

    //               3º CAJON DE LA NEVERA
            b3Nevera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon3n = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon3n);
                }
            });
    //               4º CAJON DE LA NEVERA
            b4Nevera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon4n = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon4n);
                }
            });

    //                1º CAJON DE LA PUERTA
            b1Estante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon1e = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon1e);
                }
            });

    //                2º CAJON DE LA PUERTA
            b2Estante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon2e = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon2e);
                }
            });

    //                3º CAJON DE LA PUERTA
            b3Estante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent abrircajon3e = new Intent(SeleccionCajon.this, MainActivity.class);
                    Stock.getInstance().insertarDatosPorCajon(0, elementop); //CAMBIAR EL NÚMERO DEL CAJÓN
                    Toast.makeText(getApplicationContext(), "Producto " + elementop.getNombre() + " cambiado",Toast.LENGTH_LONG).show();
                    startActivity(abrircajon3e);
                }
            });
        }
    }