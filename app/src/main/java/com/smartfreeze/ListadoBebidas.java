package com.smartfreeze;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
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
import com.smartfreeze.ui.adapter.AjustesAdapter;
import com.smartfreeze.ui.fragments.DispensadorTab;

import java.util.ArrayList;
import java.util.List;

public class ListadoBebidas extends Activity {

    private ArrayList<Ajustes> datosBebidas = new ArrayList<>();
    RecyclerView recyclerView;
    AjustesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_bebidas);
        setListaBebidas();
        recyclerView = findViewById(R.id.recycler_tienda);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
    public ArrayList<Ajustes> getListaBebidas(){
        return datosBebidas;
    }
    public void setListaBebidas(){
        datosBebidas.add(new Ajustes("   Agua", R.drawable.botellaagua));
        datosBebidas.add(new Ajustes("   Cerveza", R.drawable.beer));
        datosBebidas.add(new Ajustes("   Fanta", R.drawable.fanta));
        datosBebidas.add(new Ajustes("   Cocacola", R.drawable.coke));
        datosBebidas.add(new Ajustes("   Agua con gas", R.drawable.nestea));
    }
}
