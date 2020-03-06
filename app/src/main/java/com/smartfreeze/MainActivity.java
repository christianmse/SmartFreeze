package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void abrirFrutas1(){
        Toast.makeText(this, "Abierto cajon de frutas 1", Toast.LENGTH_LONG).show();
    }




}
