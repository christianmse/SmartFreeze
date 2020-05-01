package com.smartfreeze;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smartfreeze.domain.Ajustes;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.adapter.AjustesAdapter;
import com.smartfreeze.ui.fragments.DispensadorTab;

import java.util.ArrayList;
import java.util.List;

public class ListadoBebidas extends Activity {

    private ArrayList<Producto> datosBebidas = new ArrayList<>();
    RecyclerView recyclerView;
    AjustesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_bebidas);
        setListaBebidas();
        recyclerView = findViewById(R.id.recycler_tienda);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new AjustesAdapter(getListaBebidas(), this);
        recyclerView.setAdapter(adapter);

//        Clickar en alguna cardview
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(ListadoBebidas.this, MainActivity.class);
                        intent.putExtra("Texto", datosBebidas.get(position).getNombre());
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
    }


//          Creacion de las bebidas
    public ArrayList<Producto> getListaBebidas(){
        return datosBebidas;
    }
    public void setListaBebidas(){
        datosBebidas.add(new Producto("   Agua","Bebida","1", R.drawable.agauasingas,"Agua"));
        datosBebidas.add(new Producto("   Chipys", "Bebida", "2", R.drawable.cerveza, "Cerveza de malta"));
        datosBebidas.add(new Producto("   Fanta", "Bebida", "2", R.drawable.fanta_naranja, "Fanta de naranja"));
        datosBebidas.add(new Producto("   Cocacola","Bebida", "2", R.drawable.cocacola, "Coke"));
        datosBebidas.add(new Producto("   Agua con gas", "Bebida", "1,3", R.drawable.aguagas, "Gas"));
        datosBebidas.add(new Producto("Zumo de naranja", "Bebidas", "4", R.drawable.zumo_naranja, "Zumo natural"));
    }
}
