package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> 8f820d66c82b8c1e3ba928313b1f57afcff5b971

public class PagoActivity extends AppCompatActivity {

    Button cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
<<<<<<< HEAD
        int precioTotal1 = getIntent().getIntExtra("precio", 0);
        TextView PrecioTotal2;
        PrecioTotal2 = findViewById(R.id.precioTotal);
        PrecioTotal2.setText(String.valueOf(precioTotal1));
=======

>>>>>>> 8f820d66c82b8c1e3ba928313b1f57afcff5b971
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
