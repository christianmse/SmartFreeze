package com.smartfreeze.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable {

    private String nombre;
    private String categoria;
    private String precio;
    private int drawable;
    private String descripcion;

    public Producto(String nombre, String categoria, String precio, int drawable, String descripcion){
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.drawable = drawable;
        this.descripcion = descripcion;

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



    protected Producto(Parcel in) {
        nombre = in.readString();
        categoria = in.readString();
        precio = in.readString();
        drawable = in.readInt();
        descripcion = in.readString();
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
