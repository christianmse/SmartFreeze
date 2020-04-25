package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.adapter.CartAdapter;
import com.smartfreeze.ui.adapter.StoreAdapter;

import java.util.ArrayList;

public class PaymarketActivity extends AppCompatActivity {
    ArrayList<Producto> productosSeleccionados = new ArrayList<>();
    TextView articulosTotal, precioTotal;
    View vacio;
    RecyclerView recyclerView;
    CartAdapter adapter;
    Toolbar toolbar;
    Button comenzarComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymarket);
        vacio = findViewById(R.id.cesta_vacia);
        comenzarComprar = findViewById(R.id.emp_comprar);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rv_cart);
        articulosTotal = findViewById(R.id.articulosTotal);
        precioTotal = findViewById(R.id.precioTotal);


        if(getIntent().getParcelableArrayListExtra("productosSeleccionados").size() > 0 ){
            productosSeleccionados = getIntent().getParcelableArrayListExtra("productosSeleccionados");

            vacio.setVisibility(View.GONE);
            int precio = calcularPrecioTotal(productosSeleccionados);
            articulosTotal.setText(String.valueOf(productosSeleccionados.size()));
            precioTotal.setText(String.valueOf(precio));

            adapter = new CartAdapter(productosSeleccionados, this,this);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
        }else{
            comenzarComprar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }


    }

    private int calcularPrecioTotal(ArrayList<Producto> productosSeleccionados) {
        int result =0;
        for(int i=0; i<productosSeleccionados.size(); i++){
            String precio =((Producto)productosSeleccionados.get(i)).getPrecio();
            result += ((Producto)productosSeleccionados.get(i)).getCantidad() * Integer.parseInt(precio);
        }
        return result;
    }


}