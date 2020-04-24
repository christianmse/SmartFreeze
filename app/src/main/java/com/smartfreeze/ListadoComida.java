package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.smartfreeze.domain.Ajustes;
import com.smartfreeze.ui.adapter.AjustesAdapter;

import java.util.ArrayList;

public class ListadoComida extends AppCompatActivity {

    private ArrayList<Ajustes> datosComida8 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida7 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida6 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida5 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida4 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida3 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida2 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida1 = new ArrayList<>();
    AjustesAdapter adapter;
    RecyclerView recyclerView;
    private int boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_comida);

        recyclerView = findViewById(R.id.recycler_tienda);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        boton = intent.getIntExtra("Boton", 0);
        switch (boton){
            case R.id.b3Cajon:
                adapter = new AjustesAdapter(getDatosComidaCF3(), this);
                break;
            case R.id.b2Cajon:
                adapter = new AjustesAdapter(getDatosComidaCF2(), this);
                break;
            case R.id.b1Cajon:
                adapter = new AjustesAdapter(getDatosComidaCF1(), this);
                break;
            default:
                Toast.makeText(this, "No pirula", Toast.LENGTH_LONG).show();
                break;
        }
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Ajustes> getDatosComidaCF3(){
        datosComida8.add(new Ajustes("Pollo c3f", R.drawable.pollo));
        datosComida8.add(new Ajustes("Filetes de ternera", R.drawable.filete));
        datosComida8.add(new Ajustes("Salmón", R.drawable.pescado));
        datosComida8.add(new Ajustes("Atún", R.drawable.pescado));
        datosComida8.add(new Ajustes("Filetes de potro", R.drawable.filete));
        datosComida8.add(new Ajustes("Queso", R.drawable.queso));
        return datosComida8;
    }

    public ArrayList<Ajustes> getDatosComidaCF2(){
        datosComida7.add(new Ajustes("Pollo c2f", R.drawable.pollo));
        datosComida7.add(new Ajustes("Filetes de ternera", R.drawable.filete));
        datosComida7.add(new Ajustes("Salmón", R.drawable.pescado));
        datosComida7.add(new Ajustes("Atún", R.drawable.pescado));
        datosComida7.add(new Ajustes("Boquerones", R.drawable.pescado));
        datosComida7.add(new Ajustes("Mozzarella", R.drawable.queso));
        return datosComida7;
    }

    public ArrayList<Ajustes> getDatosComidaCF1(){
        datosComida6.add(new Ajustes("Poll0 c1f", R.drawable.pollo));
        datosComida6.add(new Ajustes("Filetes de ternera", R.drawable.filete));
        datosComida6.add(new Ajustes("Salmón", R.drawable.pescado));
        datosComida6.add(new Ajustes("Atún", R.drawable.pescado));
        datosComida6.add(new Ajustes("Filetes de potro", R.drawable.filete));
        datosComida6.add(new Ajustes("Queso", R.drawable.queso));
        return datosComida6;
    }
}
