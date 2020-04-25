package com.smartfreeze.ui.bottom_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.R;
import com.smartfreeze.domain.Ajustes;
import com.smartfreeze.ui.adapter.AjustesAdapter;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;

public class AjustesOpcion extends Fragment {

    RecyclerView recyclerView;
    AjustesAdapter adapter;
    AjustesAdapter adapter2;

    private ArrayList<Ajustes> datosAjustes = new ArrayList<>();
    private ArrayList<Ajustes> datosAjustes2 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.opcion_ajustes,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_ajustes);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AjustesAdapter(getListaAjustes(), getContext());

        adapter2 = new AjustesAdapter(getDatosAjustes2(), getContext());
        recyclerView.setAdapter(adapter);

    }

    public ArrayList<Ajustes> getDatosAjustes2(){
        datosAjustes2.add(new Ajustes("   Envio de factura a tu correo electrónico", R.drawable.ic_alarm));
        datosAjustes2.add(new Ajustes("   Notificaciones", R.drawable.ic_alarm));
        return datosAjustes2;
    }




    public ArrayList<Ajustes> getListaAjustes(){
                datosAjustes.add(new Ajustes("   Contacta con el servicio técnico", R.drawable.ic_alarm));
                datosAjustes.add(new Ajustes("   Cambiar método de pago", R.drawable.ic_alarm));
                datosAjustes.add(new Ajustes("   Cambiar correo electrónico", R.drawable.ic_alarm));

                return datosAjustes;
    }
}
