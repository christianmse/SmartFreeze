package com.smartfreeze.ui.bottom_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.R;
import com.smartfreeze.domain.Ajustes;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.adapter.AjustesAdapter;
import com.smartfreeze.ui.adapter.TiendaAdapter;

import java.util.ArrayList;

public class TiendaOpcion extends Fragment {
    RecyclerView recyclerView;
    TiendaAdapter adapter;
    private ArrayList<Producto> datosTienda = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.opcion_tienda,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_tienda);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TiendaAdapter(getListaProductos(), getContext());
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Producto> getListaProductos(){
        datosTienda.add(new Producto("   Pollo", "Frescos", "3$", R.drawable.ic_tienda));
        datosTienda.add(new Producto("   Pollo", "Frescos", "3$", R.drawable.ic_tienda));
        datosTienda.add(new Producto("   Pollo", "Frescos", "3$", R.drawable.ic_tienda));
        datosTienda.add(new Producto("   Pollo", "Frescos", "3$", R.drawable.ic_tienda));
        datosTienda.add(new Producto("   Pollo", "Frescos", "3$", R.drawable.ic_tienda));

        return datosTienda;
    }
}
