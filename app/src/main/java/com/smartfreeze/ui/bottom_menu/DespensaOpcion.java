package com.smartfreeze.ui.bottom_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emredavarci.noty.Noty;
import com.smartfreeze.IDespensaListener;
import com.smartfreeze.MainActivity;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.adapter.DespensaAdapter;
import com.smartfreeze.util.Datos;

import java.util.ArrayList;

public class DespensaOpcion extends Fragment implements IDespensaListener {
    RecyclerView recyclerView;
    DespensaAdapter adapter;
    private ArrayList<Producto> datosTienda = new ArrayList<>();
    private GridLayoutManager layoutManager;
    ConstraintLayout rl;


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
        layoutManager = new GridLayoutManager(requireContext(), 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DespensaAdapter(Datos.getInstance().getDatos(), getContext(), this);
        recyclerView.setAdapter(adapter);
        rl = (ConstraintLayout) view.findViewById(R.id.myLayout);
    }

    public ArrayList<Producto> getListaProductos(){
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "3$", R.drawable.ic_tienda, "descripcion"));


        return datosTienda;
    }

    @Override
    public void accion2() {


        Noty.init(getActivity(), "No internet connection!", rl,
                Noty.WarningStyle.SIMPLE)
                .setAnimation(Noty.RevealAnim.SLIDE_UP, Noty.DismissAnim.BACK_TO_BOTTOM, 400,400)
                .setWarningInset(0,0,0,0)
                .setWarningBoxRadius(0,0,0,0)
                .show();
    }
}
