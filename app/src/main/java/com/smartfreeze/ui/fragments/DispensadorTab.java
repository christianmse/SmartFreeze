package com.smartfreeze.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.smartfreeze.ListadoBebidas;
import com.smartfreeze.MainActivity;
import com.smartfreeze.R;




public class DispensadorTab extends Fragment {
    public static final String ARG_OBJECT = "object";
    private String nombre;

    private ImageButton iBBotella,iBCubito;
    private ImageButton iBDispensador;
    private TextView text_Botella;


    public DispensadorTab(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String strtext = getArguments().getString("Texto");
        return inflater.inflate(R.layout.fragment_dispensador_tab, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        //Boton
        iBBotella = (ImageButton) view.findViewById(R.id.iBBotella);
        iBCubito = (ImageButton) view.findViewById(R.id.iBCubito);

        iBBotella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListadoBebidas.class);
                startActivity(intent);
            }
        });

        iBDispensador = (ImageButton) view.findViewById(R.id.iBDispensador);
        iBDispensador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Dispensando Bebida", Toast.LENGTH_LONG).show();
            }
        });

        iBCubito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Dispensando Hielo", Toast.LENGTH_LONG).show();
            }
        });

//        TextBotella
        text_Botella = (TextView) view.findViewById(R.id.text_bebida);
        final Observer<String> scoreObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String texto) {
                //Update the textview that holds the score
                text_Botella.setText(texto);
            }
        };

        MainActivity.mText.observe(getActivity(), scoreObserver);
    }


    public String getNombre() {
        return nombre;
    }
}
