package com.smartfreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CambioTarjetaPago extends AppCompatActivity {
    Button cerrar, aceptar;
    TextView textTitular,textTarjeta,textFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_ajustes);

        cerrar = findViewById(R.id.cerrar);
        aceptar = findViewById(R.id.Aceptar);
        textTitular = findViewById(R.id.textTitular);
        textTarjeta = findViewById(R.id.textTarjeta);
        textFecha = findViewById(R.id.editText);



        final Intent intent = new Intent(this, MainActivity.class);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
