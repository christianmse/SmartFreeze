package com.smartfreeze.util;

import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;

public class Stock {
    private static Stock instance = null;
    private static ArrayList<Producto> datosPorCajon = new ArrayList<>();
    static HashMap<Integer,ArrayList<Producto>> datos = new HashMap<>();

    //Categorias:
    //        <item>Carnes</item>
    //        <item>Frutas</item>
    //        <item>Bebidas</item>
    //        <item>Pescados</item>
    //        <item>Pastas</item>
    //        <item>Legumbres</item>

    public Stock(){
        datosPorCajon.add(new Producto("Arroz", "Legumbres", "1", R.drawable.arroz, "Arroz a granel de Andalucia", "03/05/2020",1));
        datosPorCajon.add(new Producto("Coca Cola", "Bebidas", "2", R.drawable.cocacola, "CocaCola de 2L", "03/05/2020",1));
        datosPorCajon.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno", "03/05/2020",1));
        datosPorCajon.add(new Producto("Lentejas", "Legumbres", "2", R.drawable.lentejas, "Lentejas a granel de Andalucia", "03/05/2020",1));
        datosPorCajon.add(new Producto("Salmon", "Pescados", "8", R.drawable.salmon, "Salmon fresco. Origen Noruega.", "03/05/2020",1));
        datosPorCajon.add(new Producto("Pollo", "Carnes", "3", R.drawable.pollo, "Pollo fresco", "03/05/2020",1));
        datosPorCajon.add(new Producto("Macarrones", "Pastas", "4", R.drawable.macarrones, "Macarrones hacendado", "03/05/2020",1));
        datosPorCajon.add(new Producto("Spaguetti", "Pastas", "2", R.drawable.spaghetti, "descripcion", "03/05/2020",1));
        datosPorCajon.add(new Producto("Cinta de lomo", "Carnes", "4", R.drawable.cintalomo, "descripcion", "03/05/2020",1));
        datosPorCajon.add(new Producto("Pollo", "Carnes", "1", R.drawable.ic_tienda, "descripcion", "03/05/2020",1));
        datos.put(0,datosPorCajon);
        datos.put(1,datosPorCajon);
        datos.put(2,datosPorCajon);

    }

    public static Stock getInstance(){
        if(instance == null){
            instance = new Stock();
        }
        return instance;
    }

    public ArrayList<Producto> getDatosPorCajon(Integer cajon){
        return datos.getOrDefault(cajon, datosPorCajon);
    }

    public void insertarDatosPorCajon (Integer cajon, Producto producto, String nombre){
        for(Producto aux : Datos.getInstance().getDatos()){
            if(aux.getNombre().equals(nombre))
                datos.get(cajon).add(producto);
        }

    }

    public HashMap<Integer, ArrayList<Producto>> getDatos(){
        return datos;
    }

    public void eliminarProducto (Integer cajon,Producto producto, String nombre){
        for(Producto aux : Datos.getInstance().getDatos()){
            if(aux.getNombre().equals(nombre))
                datos.get(cajon).remove(producto);
        }

    }
}