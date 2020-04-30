package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.adapter.CartAdapter;
import com.smartfreeze.ui.adapter.StoreAdapter;
import com.smartfreeze.util.Datos;

import java.util.ArrayList;
import java.util.Map;

public class PaymarketActivity extends AppCompatActivity {
    ArrayList<Producto> productosSeleccionados = new ArrayList<>();
    TextView articulosTotal, precioTotal;
    View vacio, cabecera;
    RecyclerView recyclerView;
    CartAdapter adapter;
    Toolbar toolbar;
    Button comenzarComprar, procederPago;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymarket);
        vacio = findViewById(R.id.cesta_vacia);
        cabecera = findViewById(R.id.cabecera);
        comenzarComprar = findViewById(R.id.emp_comprar);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rv_cart);
        articulosTotal = findViewById(R.id.articulosTotal);
        precioTotal = findViewById(R.id.precioTotal);
        procederPago = findViewById(R.id.cartButton);
        final Intent intent = new Intent(this, PagoActivity.class);
        sharedPreferences = getSharedPreferences(StoreAdapter.SHARED_PREF_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();


        if(getIntent().getParcelableArrayListExtra("productosSeleccionados").size() > 0 ){
            productosSeleccionados = getIntent().getParcelableArrayListExtra("productosSeleccionados");
            comprobarTodosSeleccionados(Datos.getInstance().getDatos());

            vacio.setVisibility(View.GONE);
            final int precio = calcularPrecioTotal(productosSeleccionados);
            articulosTotal.setText(String.valueOf(productosSeleccionados.size()));
            precioTotal.setText(String.valueOf(precio));

            adapter = new CartAdapter(productosSeleccionados, this,this);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(adapter);
            procederPago.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    editor.clear().apply();
                   intent.putExtra("productos_seleccionados",productosSeleccionados);
                   intent.putExtra("precio", precio);
                   startActivity(intent);
                }
            });
        }else{
            comenzarComprar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            procederPago.setVisibility(View.GONE);
            cabecera.setVisibility(View.GONE);
        }


    }

    private void comprobarTodosSeleccionados(ArrayList<Producto> datos) {
        Map<String, ?> map = sharedPreferences.getAll();
        boolean esta = false;
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            for (int i = 0; i < productosSeleccionados.size(); i++) {
                Producto aux = productosSeleccionados.get(i);

                if (entry.getKey().equals(aux.getNombre())) {
                    esta = true;
                    break;
                } else {
                    esta = false;
                }

            }

            if (!esta) {
                nombres.add(entry.getKey());
                cantidades.add((Integer) entry.getValue());
            }
        }

        for(Producto dato: datos){
            for(String nombre : nombres){
                if(nombre.equals(dato.getNombre())){
                    productosSeleccionados.add(dato);
                }
            }
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
