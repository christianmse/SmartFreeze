package com.smartfreeze.ui.bottom_menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.smartfreeze.IPrincipalListener;
import com.smartfreeze.R;
import com.smartfreeze.domain.Boton;

import java.util.HashMap;
import java.util.Map;

public class PrincipalOpcion extends Fragment {

    //Crear array de botones
    private final int[] BOTONESMENU={R.id.boton_principal};
    private Boton[] botonesNevera = new Boton[BOTONESMENU.length];

    public PrincipalOpcion(){
        //Constructor vacio
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista =  inflater.inflate(R.layout.opcion_principal,container,false);

        Button botonAux;
        for(int i=0; i<BOTONESMENU.length; i++){
            botonAux = (Button) vista.findViewById(BOTONESMENU[i]);
            final int botonSelec=i;
            botonesNevera[i] = new Boton(i,0);
            botonAux.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    botonesNevera[botonSelec].setFlagAbierto(botonesNevera[botonSelec].getFlagAbierto()+1);
                    Activity estaActividad = getActivity();
                    ((IPrincipalListener) estaActividad).botonSeleccionado(botonesNevera[botonSelec]);
                    //((IPrincipalListener) estaActividad).botonSeleccionado(botonSelec);
                }
            });
        }

        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
