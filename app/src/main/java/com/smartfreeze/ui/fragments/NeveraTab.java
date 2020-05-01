package com.smartfreeze.ui.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.smartfreeze.ListadoComida;
import com.smartfreeze.R;


public class NeveraTab extends Fragment {

    private ImageButton iBNeveraCerrada, iBFrigoCerrado, iBCerrarNevera, iBCerrarFrigo;
    private ImageView iVNeveraAbierta, iVFrigoAbierto;
    private Button  b3CajonF, b2CajonF, b1CajonF, b1Nevera, b2Nevera, b3Nevera, b4Nevera,
                    b1Estante, b2Estante, b3Estante;
    private boolean abierto1 = false, abierto2 = false, abierto3 = false, abierto4 = false,
            abierto5 = false, abierto6 = false, abierto7 = false, abierto9 = false,
            abierto10 = false, abierto11 = false;
    Drawable botonfondo;

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
        b1Estante = view.findViewById(R.id.bEstante1);
        b2Estante = view. findViewById(R.id.bEstante2);
        b3Estante = view.findViewById(R.id.bEstante3);



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
                b1Estante.setVisibility(View.VISIBLE);
                b2Estante.setVisibility(View.VISIBLE);
                b3Estante.setVisibility(View.VISIBLE);

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
                b1Estante.setVisibility(View.GONE);
                b2Estante.setVisibility(View.GONE);
                b3Estante.setVisibility(View.GONE);
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
        botonfondo = b3CajonF.getBackground();
//                3ª CAJON DEL FRIGORIFICO
        b3CajonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto1) {
                    abierto1 = true;
                    b3CajonF.setText("Cajón abierto");
                    b3CajonF.setBackgroundResource(R.drawable.fondo_gradiente);
                }

                else{
                    abierto1 = false;
                    b3CajonF.setText("Cajón 3");
                    b3CajonF.setBackground(botonfondo);

                }
            }
        });
        b3CajonF.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrircajon3f = new Intent(getActivity(), ListadoComida.class);
                abrircajon3f.putExtra("Boton", R.id.b3Cajon);
                startActivity(abrircajon3f);
                return true;
            }
        });
        //        2ª CAJON DEL FRIGORIFICO
        b2CajonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto2) {
                    abierto2 = true;
                    b2CajonF.setText("Cajón abierto");
                    b2CajonF.setBackgroundResource(R.drawable.fondo_gradiente);
                }
                else{
                    abierto2 = false;
                    b2CajonF.setText("Cajón 2");
                    b2CajonF.setBackground(botonfondo);
                }
            }
        });
        b2CajonF.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrircajon2f = new Intent(getActivity(), ListadoComida.class);
                abrircajon2f.putExtra("Boton", R.id.b2Cajon);
                startActivity(abrircajon2f);
                return true;
            }
        });
        //        1ª CAJON DEL FRIGORIFICO
        b1CajonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!abierto3) {
                    abierto3 = true;
                    b1CajonF.setText("Cajón abierto");
                    b1CajonF.setBackgroundResource(R.drawable.fondo_gradiente);
                }
                else{
                    abierto3 = false;
                    b1CajonF.setText("Cajón 1");
                    b1CajonF.setBackground(botonfondo);
                }
            }
        });
        b1CajonF.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrircajon1f = new Intent(getActivity(), ListadoComida.class);
                abrircajon1f.putExtra("Boton", R.id.b1Cajon);
                startActivity(abrircajon1f);
                return true;
            }
        });

//        1º CAJON DE LA NEVERA
        b1Nevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto4) {
                    abierto4 = true;
                    b1Nevera.setText("Cajón abierto");
                    b1Nevera.setBackgroundResource(R.drawable.fondo_gradiente);
                }
                else{
                    abierto4 = false;
                    b1Nevera.setText("Cajón 1");
                    b1Nevera.setBackground(botonfondo);
                }
            }
        });
        b1Nevera.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrirCajon1N = new Intent(getActivity(), ListadoComida.class);
                abrirCajon1N.putExtra("Boton", R.id.b1Nevera);
                startActivity(abrirCajon1N);
                return true;
            }
        });
//               2º CAJON DE LA NEVERA
        b2Nevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto5) {
                    abierto5 = true;
                    b2Nevera.setText("Cajón abierto");
                    b2Nevera.setBackgroundResource(R.drawable.fondo_gradiente);

                }
                else{
                    abierto5 = false;
                    b2Nevera.setText("Cajón 2");
                    b2Nevera.setBackground(botonfondo);
                }
            }
        });
        b2Nevera.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrirCajon2N = new Intent(getActivity(), ListadoComida.class);
                abrirCajon2N.putExtra("Boton", R.id.b2Nevera);
                startActivity(abrirCajon2N);
                return true;
            }
        });
//               3º CAJON DE LA NEVERA
        b3Nevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto6) {
                    abierto6 = true;
                    b3Nevera.setText("Cajón abierto");
                    b3Nevera.setBackgroundResource(R.drawable.fondo_gradiente);
                }
                else{
                    abierto6 = false;
                    b3Nevera.setText("Cajón 3");
                    b3Nevera.setBackground(botonfondo);
                }
            }
        });
        b3Nevera.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrirCajon3N = new Intent(getActivity(), ListadoComida.class);
                abrirCajon3N.putExtra("Boton", R.id.b3Nevera);
                startActivity(abrirCajon3N);
                return true;
            }
        });
//               4º CAJON DE LA NEVERA
        b4Nevera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto7) {
                    abierto7 = true;
                    b4Nevera.setText("Cajón abierto");
                    b4Nevera.setBackgroundResource(R.drawable.fondo_gradiente);
                }
                else{
                    abierto7 = false;
                    b4Nevera.setText("Cajón 4");
                    b4Nevera.setBackground(botonfondo);
                }
            }
        });
        b4Nevera.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrirCajon4N = new Intent(getActivity(), ListadoComida.class);
                abrirCajon4N.putExtra("Boton", R.id.b4CajonIzq);
                startActivity(abrirCajon4N);
                return true;
            }
        });
//                1º CAJON DE LA PUERTA
        b1Estante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto9) {
                    abierto9 = true;
                    b1Estante.setText("Puerta Abierta");
                    b1Estante.setBackgroundResource(R.drawable.fondo_gradiente);
                }
                else{
                    abierto9 = false;
                    b1Estante.setText("Estante 1");
                    b1Estante.setBackground(botonfondo);
                }
            }
        });
        b1Estante.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrirEstante1 = new Intent(getActivity(), ListadoComida.class);
                abrirEstante1.putExtra("Boton", R.id.bEstante1);
                startActivity(abrirEstante1);
                return true;
            }
        });
//                2º CAJON DE LA PUERTA
        b2Estante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto10) {
                    abierto10 = true;
                    b2Estante.setText("Puerta Abierta");
                    b2Estante.setBackgroundResource(R.drawable.fondo_gradiente);
                }
                else{
                    abierto10 = false;
                    b2Estante.setText("Estante 2");
                    b2Estante.setBackground(botonfondo);
                }
            }
        });
        b2Estante.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrirEstante2 = new Intent(getActivity(), ListadoComida.class);
                abrirEstante2.putExtra("Boton", R.id.bEstante2);
                startActivity(abrirEstante2);
                return true;
            }
        });
//                3º CAJON DE LA PUERTA
        b3Estante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!abierto11) {
                    abierto11 = true;
                    b3Estante.setText("Puerta Abierta");
                    b3Estante.setBackgroundResource(R.drawable.fondo_gradiente);
                }
                else{
                    abierto11 = false;
                    b3Estante.setText("Estante 3");
                    b3Estante.setBackground(botonfondo);
                }
            }
        });
        b3Estante.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent abrirEstante3 = new Intent(getActivity(), ListadoComida.class);
                abrirEstante3.putExtra("Boton", R.id.bEstante3);
                startActivity(abrirEstante3);
                return true;
            }
        });

    }

    public String getNombre() {
        return nombre;
    }

}
