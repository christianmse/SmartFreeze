package com.smartfreeze.domain;


public class Boton{

    private int id;
    private int flagAbierto; //Si es 0 esta cerrado


    public Boton(int id, int abierto){
        this.flagAbierto = abierto;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getFlagAbierto() {
        return flagAbierto;
    }

    public void setFlagAbierto(int flagAbierto) {
        this.flagAbierto = flagAbierto;
    }
}
