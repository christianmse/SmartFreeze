package com.smartfreeze.domain;

import android.widget.ImageView;

import com.smartfreeze.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Ajustes {

    private String nombre;
    private int drawable;

    public Ajustes (String nombre, int drawable){
        this.drawable = drawable;
        this.nombre = nombre;
    }

        public String getNombre() {
            return nombre;
        }

        public int getDrawable() {
            return drawable;
        }


}
