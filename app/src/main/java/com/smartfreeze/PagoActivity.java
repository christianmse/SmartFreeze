package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PagoActivity extends AppCompatActivity {

    Button cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        int precioTotal1 = getIntent().getIntExtra("precio", 0);
        TextView PrecioTotal2;
        PrecioTotal2 = findViewById(R.id.precioTotal);
        PrecioTotal2.setText(String.valueOf(precioTotal1));
        cerrar = findViewById(R.id.cerrar);
        final Intent intent = new Intent(this, MainActivity.class);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
