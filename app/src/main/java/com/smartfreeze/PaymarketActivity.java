package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class PaymarketActivity extends AppCompatActivity {
    ArrayList<Producto> productosSeleccionados = new ArrayList<>();
    TextView txt;
    View vacio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymarket);
        vacio = findViewById(R.id.cesta_vacia);

        if(getIntent().getParcelableArrayListExtra("productosSeleccionados").size() > 0 ){
            productosSeleccionados = getIntent().getParcelableArrayListExtra("productosSeleccionados");
            String aux = ((Producto)productosSeleccionados.get(0)).getNombre() + ((Producto)productosSeleccionados.get(0)).getCantidad();
            vacio.setVisibility(View.GONE);
        }else{

        }


    }


}
