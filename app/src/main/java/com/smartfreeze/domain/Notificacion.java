package com.smartfreeze.domain;

public class Notificacion {
    private String prioridad;
    private String titulo;

    public Notificacion(String prioridad, String titulo){
        this.prioridad = prioridad;
        this.titulo = titulo;
    }
    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
