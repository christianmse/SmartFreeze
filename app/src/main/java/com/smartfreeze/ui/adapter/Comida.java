package com.smartfreeze.ui.adapter;

import com.smartfreeze.domain.Ajustes;

public class Comida extends Ajustes {

    private String nombre;
    private int drawable, cantidad;

    public Comida (String nombre, int drawable, int cantidad){
        super(nombre, drawable);
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDrawable() {
        return drawable;
    }

    public int getCantidad(){
        return cantidad;
    }

}
