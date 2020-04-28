package com.smartfreeze;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CambioTarjetaPago extends AppCompatActivity {
    Button cerrar, aceptar;
    TextView textTitular,textTarjeta;
    EditText textFechaMonth, textFechaYear, CVV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_ajustes);

        cerrar = findViewById(R.id.cerrar);
        aceptar = findViewById(R.id.submitButton);
        textTitular = findViewById(R.id.holderNameInput);
        textTarjeta = findViewById(R.id.cardNumberInput);
        textFechaMonth = findViewById(R.id.monthInput);
        textFechaYear = findViewById(R.id.yearInput);
        CVV = findViewById(R.id.cvvInput);



        final Intent intent = new Intent(this, MainActivity.class);
            /*cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });*/
    }
}
