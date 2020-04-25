package com.smartfreeze.util;

import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class Datos {
    private static Datos instance = null;
    private static ArrayList<Producto> datosTienda = new ArrayList<>();


    public Datos(){
        datosTienda.add(new Producto("Arroz", "Legumbres", "1", R.drawable.arroz, "Arroz a granel de Andalucia"));
        datosTienda.add(new Producto("Coca Cola", "Bebidas", "2", R.drawable.cocacola, "CocaCola de 2L"));
        datosTienda.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno"));
        datosTienda.add(new Producto("Lentejas", "Legumbres", "2", R.drawable.lentejas, "Lentejas a granel de Andalucia"));
        datosTienda.add(new Producto("Salmon", "Pescado", "8", R.drawable.salmon, "Salmon fresco. Origen Noruega."));
        datosTienda.add(new Producto("Pollo", "Frescos", "3", R.drawable.pollo, "Pollo fresco"));
        datosTienda.add(new Producto("Macarrones", "Pastas", "4", R.drawable.macarrones, "Macarrones hacendado"));
        datosTienda.add(new Producto("Spaguetti", "Pastas", "2", R.drawable.spaghetti, "descripcion"));
        datosTienda.add(new Producto("Cinta de lomo", "Carnes", "4", R.drawable.cintalomo, "descripcion"));
        datosTienda.add(new Producto("Pollo", "Frescos", "1", R.drawable.ic_tienda, "descripcion"));
    }

    public static Datos getInstance(){
    if(instance == null){
        instance = new Datos();
    }
    return instance;
    }

    public ArrayList<Producto> getDatos(){
        return datosTienda;
    }
}
