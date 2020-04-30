package com.smartfreeze.ui.bottom_menu;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.smartfreeze.MainActivity;
import com.smartfreeze.PaymarketActivity;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.IStoreListener;
import com.smartfreeze.ui.adapter.StoreAdapter;
import com.smartfreeze.ui.fragments.DetailFragment;
import com.smartfreeze.util.Datos;
import com.smartfreeze.util.MyDialog;

import java.util.ArrayList;
import java.util.List;


public class StoreFragment extends Fragment implements IStoreListener {

    RecyclerView recyclerView;
    StoreAdapter adapter;
    Toolbar toolbar;
    View v;
    Button filtros;
    Drawable carrito;

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
        toolbar.setTitle("PAYMARKET");
        filtros = view.findViewById(R.id.filtros);
        setUpTablayout();
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        recyclerView = view.findViewById(R.id.rv_store);
        adapter = new StoreAdapter(Datos.getInstance().getDatos(), getContext(), this);
        layoutManager = new GridLayoutManager(requireContext(),4);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        setUpTablayout();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
     super.onCreateOptionsMenu(menu, inflater);
     inflater.inflate(R.menu.store_menu, menu);
        MenuItem itemSV = menu.findItem(R.id.action_search);
        carrito = menu.findItem(R.id.carrito).getIcon();
        SearchView searchView = (SearchView) itemSV.getActionView();
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        searchView.setLayoutParams(params);
        searchView.setBackgroundColor(Color.WHITE);

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    switch (item.getItemId()){
        case R.id.carrito: activityToPayMarket();
        return true;

        default: return super.onOptionsItemSelected(item);
    }
    }

    private void activityToPayMarket() {
    ArrayList<Producto> aux = adapter.getSelectedItems();
    Intent i =new Intent(getActivity(), PaymarketActivity.class);
    i.putExtra("productosSeleccionados", aux);
    startActivity(i);
    }


    void setUpTablayout(){
        filtros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    void showDialog() {
        DialogFragment dialogo = new MyDialog(this);
        dialogo.show(getChildFragmentManager(), "dialogo_categorias");
    }

    @Override
    public void clickProducto(Producto producto) {
        //MainActivity.replaceFragmentNoBottomNavigation(new DetailFragment(producto));
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = new DetailFragment(producto);
        dialogFragment.show(ft, "dialog");

    }


    @Override
    public void categoriasSelected(List<String> selectedItems) {
        ArrayList<Producto> todosProductos = Datos.getInstance().getDatos();
        ArrayList<Producto> productosFiltrdos = new ArrayList<>(todosProductos.size());
        Producto aux = new Producto();
        for(int i=0; i<todosProductos.size(); i++){
            aux = todosProductos.get(i);
            for (int j=0; j<selectedItems.size();j++){
                if(aux.getCategorioa().equals(selectedItems.get(j))){
                   productosFiltrdos.add(aux);
                }
            }

        }
        StoreAdapter nuevo = new StoreAdapter(productosFiltrdos, getContext(), this);
        recyclerView.setAdapter(nuevo);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void categoriasSelectedTodas(ArrayList<Producto> datos) {
        /*StoreAdapter nuevo = new StoreAdapter(datos, getContext(), this);
        recyclerView.setAdapter(nuevo);
        adapter.notifyDataSetChanged();*/
    }

    @Override
    public void cambiarColor(boolean b) {
    carrito.mutate();
        if(b){
            carrito.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        } else {
            carrito.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        }
    }
}
