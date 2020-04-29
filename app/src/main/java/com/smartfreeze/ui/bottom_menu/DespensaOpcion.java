package com.smartfreeze.ui.bottom_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.IDespensaListener;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.adapter.DespensaAdapter;
import com.smartfreeze.ui.adapter.SubItemAdapter;
import com.smartfreeze.util.Stock;

import java.util.ArrayList;

public class DespensaOpcion extends Fragment implements IDespensaListener {
    RecyclerView recyclerView;
    DespensaAdapter adapter;
    private ArrayList<Producto> datosTienda = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    ConstraintLayout rl;


    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.opcion_despensa,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_tienda);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DespensaAdapter(getContext(),Stock.getInstance().getDatos(),  this);
        recyclerView.setAdapter(adapter);
        rl = (ConstraintLayout) view.findViewById(R.id.myLayout);
    }



    @Override
    public void accion2() {


    }
}
