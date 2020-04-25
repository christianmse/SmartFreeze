package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class PaymarketActivity extends AppCompatActivity {
    ArrayList<Producto> productosSeleccionados = new ArrayList<>();
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymarket);
        txt = findViewById(R.id.txt_paymarket);
        productosSeleccionados = getIntent().getParcelableArrayListExtra("productosSeleccionados");
        txt.setText(productosSeleccionados.toString());
    }


}
