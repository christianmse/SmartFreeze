package com.smartfreeze;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

public class CambioTarjetaPago extends AppCompatActivity {
    Button cerrar, aceptar;
    TextView mostrarTarjeta;
    EditText textFechaMonth, textFechaYear, CVV, textTarjeta, textTitular;
    //boolean clicked;
    public static MutableLiveData<String> tarjeta = new MutableLiveData<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_ajustes);

        cerrar = findViewById(R.id.cerrar);
        aceptar = findViewById(R.id.submitButton);
        textTitular = findViewById(R.id.holderNameInput);
        textTarjeta = findViewById(R.id.cardNumberInput);
        textFechaMonth = findViewById(R.id.monthInput);
        textFechaYear = findViewById(R.id.yearInput);
        CVV = findViewById(R.id.cvvInput);
        mostrarTarjeta = findViewById(R.id.textoMostrarTarjeta);
        //clicked = false;

        final int[] x = {5};
        Log.d("TEST RESPONSE", String.valueOf(x));




        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clicked = true;
                Toast.makeText(v.getContext(), "Tarjeta aceptada", Toast.LENGTH_LONG).show();
                mostrarTarjeta.setText("Tarjeta de crédito actual: **** **** **** **** "+ textTarjeta.getText().toString().substring(15,19) +"");
                tarjeta.setValue(mostrarTarjeta.getText().toString());
            }
        });

        //TARJETA
        textTarjeta.addTextChangedListener(new TextWatcher() {
            String a;
            int keyDel;


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // noop
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                boolean flag = true;
                String eachBlock[] = textTarjeta.getText().toString().split("-");
                for (int i = 0; i < eachBlock.length; i++) {
                    if (eachBlock[i].length() > 4) {
                        flag = false;
                    }
                }
                if (flag) {

                    textTarjeta.setOnKeyListener(new View.OnKeyListener() {

                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {

                            if (keyCode == KeyEvent.KEYCODE_DEL)
                                keyDel = 1;
                            return false;
                        }
                    });

                    if (keyDel == 0) {

                        if (((textTarjeta.getText().length() + 1) % 5) == 0) {

                            if (textTarjeta.getText().toString().split("-").length <= 3) {
                                textTarjeta.setText(textTarjeta.getText() + "-");
                                textTarjeta.setSelection(textTarjeta.getText().length());
                            }
                        }
                        a = textTarjeta.getText().toString();
                    } else {
                        a = textTarjeta.getText().toString();
                        keyDel = 0;
                    }

                } else {
                    textTarjeta.setText(a);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

    /*    //TITULAR
        textTitular.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    Log.d("TEST RESPONSE", "No se ha introducido nada después de introducir titular");
                    Log.d("TEST RESPONSE", String.valueOf(x));
                    if(x[0] <6){
                        x[0]++;
                        Log.d("TEST RESPONSE", String.valueOf(x));
                    }else if(aceptar.isEnabled()){
                        aceptar.setEnabled(false);
                    }
                }else if(x[0] == 0){
                    aceptar.setEnabled(true);
                }
            }
        });

        //MES
        textFechaMonth.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    Log.d("TEST RESPONSE", "No se ha introducido nada después de introducir mes");
                    Log.d("TEST RESPONSE", String.valueOf(x));
                    if(x[0] <6){
                        x[0]++;
                        Log.d("TEST RESPONSE", String.valueOf(x));
                    }else if(aceptar.isEnabled()){
                        aceptar.setEnabled(false);
                    }
                }else if(x[0] == 0){
                    aceptar.setEnabled(true);
                }
            }
        });
        //AÑO
        textFechaYear.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    Log.d("TEST RESPONSE", "No se ha introducido nada después de introducir año");
                    Log.d("TEST RESPONSE", String.valueOf(x));
                    if(x[0] <6){
                        x[0]++;
                        Log.d("TEST RESPONSE", String.valueOf(x));
                    }else if(aceptar.isEnabled()){
                        aceptar.setEnabled(false);
                    }
                }else if(x[0] == 0){
                    aceptar.setEnabled(true);
                }
            }
        });*/
        //CVV
        CVV.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                aceptar.setEnabled(true);
            }
        });

    }
}
