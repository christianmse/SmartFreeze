package com.smartfreeze.ui.bottom_menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.CambioTarjetaPago;
import com.smartfreeze.R;
import com.smartfreeze.domain.Ajustes;
import com.smartfreeze.ui.adapter.AjustesAdapter;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;

public class AjustesOpcion extends Fragment {
    Switch Switch1, Switch2;
    TextView text1, text3;
    RelativeLayout elem1, elem2, elem3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.opcion_ajustes,container,false);
    }



    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text1 = view.findViewById(R.id.btn_ajusteS1);
        text3 = view.findViewById(R.id.btn_ajuste3);

        Switch1 = view.findViewById(R.id.switch1);
        Switch2 = view.findViewById(R.id.switch2);

        elem1 = view.findViewById(R.id.elem1);
        elem2 = view.findViewById(R.id.elem2);
        elem3 = view.findViewById(R.id.elem3);




        final Intent intent = new Intent(view.getContext(), CambioTarjetaPago.class);
        //A LA PLATAFORMA DE CAMBIO DE TARJETA
        elem2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getActivity().startActivity(intent);
            }
        });
        //AÑADE EL BOTÓN DE CAMBIO DE CORREO ELECTRÓNICO
        Switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.d("switch-prueba", "Activo");
                    elem3.setVisibility(elem3.VISIBLE);
                    elem3.animate().translationY(elem3.getHeight());
                }else{
                    Log.d("switch-prueba", "desactivado");
                    elem3.setVisibility(elem3.GONE);
                    elem3.animate().alpha(0.0f);
                }
            }
        });
        //ACTIVAR NOTIFICACIONES
        Switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.d("switch-prueba", "Activo");
                }else{
                    Log.d("switch-prueba", "desactivado");
                }
            }
        });
        //INTRODUCCION CORREO ELECTRONICO
        elem3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Log.d("elem3-prueba", "Activo");

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                
                final EditText et = new EditText(getContext());

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(et);

                // set dialog message
                alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        text3.setText("Cambiar correo electrónico\n(Actualmente usted usa: "+ et.getText().toString() +")");
                    }
                });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

/*        if(view.getId()==R.id.switch1){
            if(Switch1.isChecked()){
                text1.setText("Fue activado");
*//*              AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                final EditText et = new EditText(getContext());
                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(et);

                // set dialog message
                alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();*//*
                }

            }*/

    }


/*    public ArrayList<Ajustes> getDatosAjustes2(){
        datosAjustes2.add(new Ajustes("   Envio de factura a tu correo electrónico", R.drawable.ic_alarm));
        datosAjustes2.add(new Ajustes("   Notificaciones", R.drawable.ic_alarm));
        return datosAjustes2;
    }


    public ArrayList<Ajustes> getListaAjustes(){
        datosAjustes.add(new Ajustes("   Contacta con el servicio técnico", R.drawable.ic_alarm));
        datosAjustes.add(new Ajustes("   Cambiar método de pago", R.drawable.ic_alarm));
        datosAjustes.add(new Ajustes("   Cambiar correo electrónico", R.drawable.ic_alarm));

        return datosAjustes;
    }*/
}
