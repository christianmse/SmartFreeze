package com.smartfreeze.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartfreeze.ListadoComida;
import com.smartfreeze.R;

import java.util.List;

public class NeveraTab extends Fragment {

    private ImageButton iBNeveraCerrada, iBFrigoCerrado, iBCerrarNevera, iBCerrarFrigo;
    private ImageView iVNeveraAbierta, iVFrigoAbierto;
    private Button b3CajonF, b2CajonF, b1CajonF, b1Nevera, b2Nevera, b3Nevera, b4Nevera, b5Nevera;

    public static final String ARG_OBJECT = "object";
    private String nombre;
    public NeveraTab(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nevera_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
//        BOTONES DE LA NEVERA
        iBNeveraCerrada = view.findViewById(R.id.iBNeveDoor);
        iBCerrarNevera = view.findViewById(R.id.iBCloseNevera);
        iVNeveraAbierta = view.findViewById(R.id.iVNeveraAbierta);
        b1Nevera = view.findViewById(R.id.b1Nevera);
        b2Nevera = view.findViewById(R.id.b2Nevera);
        b3Nevera = view.findViewById(R.id.b3Nevera);
        b4Nevera = view.findViewById(R.id.b4CajonIzq);
        b5Nevera = view.findViewById(R.id.b5CajonDer);


//        BOTONES DEL FRIGORIFICO
        iBFrigoCerrado = view.findViewById(R.id.iBFrigoDoor);
        iVFrigoAbierto = view.findViewById(R.id.iVFrigoAbierto);
        iBCerrarFrigo = view.findViewById(R.id.iBCloseFrigo);
        b3CajonF = view.findViewById(R.id.b3Cajon);
        b2CajonF = view.findViewById(R.id.b2Cajon);
        b1CajonF = view.findViewById(R.id.b1Cajon);

//          ABRIR LA NEVERA
        iBNeveraCerrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iBNeveraCerrada.setVisibility(View.INVISIBLE);
                iBCerrarNevera.setVisibility(View.VISIBLE);
                iVNeveraAbierta.setVisibility(View.VISIBLE);
                b1Nevera.setVisibility(View.VISIBLE);
                b2Nevera.setVisibility(View.VISIBLE);
                b3Nevera.setVisibility(View.VISIBLE);
                b4Nevera.setVisibility(View.VISIBLE);
                b5Nevera.setVisibility(View.VISIBLE);

            }
        });
//          CERRAR LA NEV3RA
        iBCerrarNevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iBNeveraCerrada.setVisibility(View.VISIBLE);
                iBCerrarNevera.setVisibility(View.GONE);
                iVNeveraAbierta.setVisibility(View.GONE);
                b1Nevera.setVisibility(View.GONE);
                b2Nevera.setVisibility(View.GONE);
                b3Nevera.setVisibility(View.GONE);
                b4Nevera.setVisibility(View.GONE);
                b5Nevera.setVisibility(View.GONE);
            }
        });
//        ABRIR FRIGORIFICO
        iBFrigoCerrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iBFrigoCerrado.setVisibility(View.GONE);
                iVFrigoAbierto.setVisibility(View.VISIBLE);
                iBCerrarFrigo.setVisibility(View.VISIBLE);
                b3CajonF.setVisibility(View.VISIBLE);
                b2CajonF.setVisibility(View.VISIBLE);
                b1CajonF.setVisibility(View.VISIBLE);
            }
        });
//        CERRAR FRIGORIFICO
        iBCerrarFrigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iBFrigoCerrado.setVisibility(View.VISIBLE);
                iBCerrarFrigo.setVisibility(View.GONE);
                iVFrigoAbierto.setVisibility(View.GONE);
                b3CajonF.setVisibility(View.GONE);
                b2CajonF.setVisibility(View.GONE);
                b1CajonF.setVisibility(View.GONE);
            }
        });
//        3ª CAJON DEL FRIGORIFICO
        b3CajonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrircajon3f = new Intent(getActivity(), ListadoComida.class);
                abrircajon3f.putExtra("Boton", R.id.b3Cajon);
                startActivity(abrircajon3f);
            }
        });
        //        2ª CAJON DEL FRIGORIFICO
        b2CajonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrircajon2f = new Intent(getActivity(), ListadoComida.class);
                abrircajon2f.putExtra("Boton", R.id.b2Cajon);
                startActivity(abrircajon2f);
            }
        });
        //        1ª CAJON DEL FRIGORIFICO
        b1CajonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrircajon1f = new Intent(getActivity(), ListadoComida.class);
                abrircajon1f.putExtra("Boton", R.id.b1Cajon);
                startActivity(abrircajon1f);
            }
        });
    }

    public String getNombre() {
        return nombre;
    }
}
