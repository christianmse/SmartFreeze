package com.smartfreeze.ui.bottom_menu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.CambioTarjetaPago;
import com.smartfreeze.MainActivity;
import com.smartfreeze.R;
import com.smartfreeze.domain.Ajustes;
import com.smartfreeze.ui.adapter.AjustesAdapter;
import com.smartfreeze.ui.fragments.AyudaFragment;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.getSystemService;

public class AjustesOpcion extends Fragment {
<<<<<<< HEAD
    Switch Switch1, Switch2;
    TextView text1, text3, txt_frigo, txt_cong;
=======
    Switch Switch1, Switch2, Switch3;
    TextView text1, text3, txt_frigo, txt_cong, text4;
>>>>>>> 8f820d66c82b8c1e3ba928313b1f57afcff5b971
    RelativeLayout elem1, elem2, elem3;
    DiscreteSeekBar skb1, skb2;
    public static MutableLiveData<String> correo = new MutableLiveData<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.opcion_ajustes,container,false);
    }



    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt_frigo = view.findViewById(R.id.txt_frigo);
        txt_cong = view.findViewById(R.id.txt_congelador);
        text1 = view.findViewById(R.id.btn_ajusteS1);
        text3 = view.findViewById(R.id.btn_ajuste3);
<<<<<<< HEAD

        Switch1 = view.findViewById(R.id.switch1);
        Switch2 = view.findViewById(R.id.switch2);
=======
        text4 = view.findViewById(R.id.btn_ajusteS3);

        Switch1 = view.findViewById(R.id.switch1);
        Switch2 = view.findViewById(R.id.switch2);
        Switch3 = view.findViewById(R.id.switch3);
>>>>>>> 8f820d66c82b8c1e3ba928313b1f57afcff5b971

        elem1 = view.findViewById(R.id.elem1);
        elem2 = view.findViewById(R.id.elem2);
        elem3 = view.findViewById(R.id.elem3);

        skb1 = view.findViewById(R.id.seekBar_frigo);
        skb2 = view.findViewById(R.id.seekBar_congelador);
        final Intent intent = new Intent(view.getContext(), CambioTarjetaPago.class);



       elem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("Ayuda");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                AyudaFragment dialogFragment = new AyudaFragment();
                dialogFragment.show(ft, "Ayuda");
            }
        });

        skb1.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                txt_frigo.setText("Ajustar temperatura frigorífico (Actual temperatura: "+ value+"º)");
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
                Toast.makeText(view.getContext(), "¡Temperatura del frigorífico cambiada!", Toast.LENGTH_LONG).show();
            }
        });

        skb2.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                txt_cong.setText("Ajustar temperatura congelador (Actual temperatura: "+ value+"º)");
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {
                Toast.makeText(view.getContext(), "¡Temperatura del congelador cambiada!", Toast.LENGTH_LONG).show();
            }
        });

        final Observer<String> scoreObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String texto) {
                //Update the textview that holds the score
                text3.setText(texto);
            }
        };

        AjustesOpcion.correo.observe(getActivity(), scoreObserver);

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
                }else{
                    Log.d("switch-prueba", "desactivado");
                    elem3.setVisibility(elem3.GONE);
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

                final EditText et = new EditText(getContext());G
                correo.setValue(et.getText().toString());

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(et);

                // set title al dialog
                alertDialogBuilder.setTitle("Introduce tu correo:");

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
<<<<<<< HEAD
=======
        //APAGAR NEVERA
        Switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.d("switch-prueba", "Activo");
                    text4.setText("Apagar nevera (Actualmente encendida)");
                }else{
                    Log.d("switch-prueba", "desactivado");
                    text4.setText("Encender nevera (Actualmente apagada)");
                }
            }
        });
>>>>>>> 8f820d66c82b8c1e3ba928313b1f57afcff5b971

    }
}
