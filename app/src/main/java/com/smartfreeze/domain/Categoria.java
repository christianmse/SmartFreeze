package com.smartfreeze.domain;

import com.smartfreeze.R;

public enum Categoria {

    FIRST("Pescados", R.drawable.ic_alarm,R.color.white),
    SECOND("Verduras", R.drawable.ic_tienda,R.color.colorPrimaryDark),
    THIRD("Frutas", R.drawable.ic_launcher_foreground,R.color.black);



    private String nombre;
    private int drawable;
    private int background;

    Categoria(String nombre, int drawable, int background) {
        this.background = background;
        this.drawable = drawable;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getBackgroung() {
        return background;
    }

    public void setBackgroung(int backgroung) {
        this.background = backgroung;
    }
}
