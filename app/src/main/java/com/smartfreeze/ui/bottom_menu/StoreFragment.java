package com.smartfreeze.ui.bottom_menu;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.smartfreeze.MainActivity;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.IStoreListener;
import com.smartfreeze.ui.adapter.StoreAdapter;
import com.smartfreeze.ui.adapter.TiendaAdapter;
import com.smartfreeze.ui.fragments.DetailFragment;

import java.util.ArrayList;


public class StoreFragment extends Fragment implements IStoreListener {

    RecyclerView recyclerView;
    StoreAdapter adapter;
    Toolbar toolbar;
    View v;
    AppCompatActivity activity;
    private ArrayList<Producto> datosTienda = new ArrayList<>();
    private GridLayoutManager layoutManager;

public StoreFragment(){
    //Constructor vacio
}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.v= inflater.inflate(R.layout.fragment_store, container, false);
        return v;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.store_toolbar);
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        recyclerView = view.findViewById(R.id.rv_store);
        adapter = new StoreAdapter(getListaProductos(), getContext(), this);
        layoutManager = new GridLayoutManager(requireContext(),2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
     super.onCreateOptionsMenu(menu, inflater);
     inflater.inflate(R.menu.store_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    public ArrayList<Producto> getListaProductos(){
        datosTienda.add(new Producto("Lengua", "Frescos", "3$", R.drawable.ic_launcher_foreground, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcisaon"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descrasipcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descrisapcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        return datosTienda;
    }

    @Override
    public void clickProducto(Producto producto) {
        MainActivity.replaceFragmentNoBottomNavigation(new DetailFragment(producto));
        //getChildFragmentManager().beginTransaction().replace(R.id.producto_clicked, new DetailFragment(producto)).commit();
        //v.findViewById(R.id.store_lyt).setVisibility(View.GONE);
    }
}
