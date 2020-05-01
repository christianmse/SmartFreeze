package com.smartfreeze.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

public class Producto implements Parcelable {

    private String nombre;
    private String categoria;
    private String precio;
    private String caducidad;
    private int drawable;
    private String descripcion;
    int cantidad, cajon;

    public Producto(String nombre, String categoria, String precio, int drawable, String descripcion){
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.drawable = drawable;
        this.descripcion = descripcion;
        this.cantidad =1 ;

    }

    public Producto(String nombre, String categoria, String precio, int drawable, String descripcion, String caducidad, int cajon){
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.drawable = drawable;
        this.descripcion = descripcion;
        this.cantidad =1;
        this.caducidad = caducidad;
        this.cajon = cajon;
    }

    public Producto(){

    }

    public int getCajon(){
        return cajon;
    }
    public void setCajon(int cajon){
        this.cajon = cajon;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategorioa() {
        return categoria;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public void setCategorioa(String categorioa) {
        this.categoria = categorioa;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static final Comparator<Producto> BY_CANTIDAD = new Comparator<Producto>() {
        @Override
        public int compare(Producto o1, Producto o2) {
            //ascendente
            return String.valueOf(o1.getCantidad()).compareTo(String.valueOf(o2.getCantidad()));
        }
    };

    protected Producto(Parcel in) {
        nombre = in.readString();
        categoria = in.readString();
        precio = in.readString();
        drawable = in.readInt();
        descripcion = in.readString();
        cantidad = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(categoria);
        dest.writeString(precio);
        dest.writeInt(drawable);
        dest.writeString(descripcion);
        dest.writeInt(cantidad);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Producto> CREATOR = new Parcelable.Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };


}