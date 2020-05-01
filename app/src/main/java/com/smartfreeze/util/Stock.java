package com.smartfreeze.util;

import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;

public class Stock {
    private static Stock instance = null;
    private static ArrayList<Producto> datosPorCajon0 = new ArrayList<>();
    private static ArrayList<Producto> datosPorCajon1 = new ArrayList<>();
    private static ArrayList<Producto> datosPorCajon2= new ArrayList<>();
    static HashMap<Integer, ArrayList<Producto>> datos = new HashMap<>();

    //Categorias:
    //        <item>Carnes</item>
    //        <item>Frutas</item>
    //        <item>Bebidas</item>
    //        <item>Pescados</item>
    //        <item>Pastas</item>
    //        <item>Legumbres</item>

    public Stock(){
        //cajon0
        datosPorCajon0.add(new Producto("Arroz", "Legumbres", "1", R.drawable.arroz, "Arroz a granel de Andalucia", "03/05/2020",0));
        datosPorCajon0.add(new Producto("Coca Cola", "Bebidas", "2", R.drawable.cocacola, "CocaCola de 2L", "03/05/2020",0));
        datosPorCajon0.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno", "03/05/2020",0));
        datosPorCajon0.add(new Producto("Lentejas", "Legumbres", "2", R.drawable.lentejas, "Lentejas a granel de Andalucia", "03/05/2020",0));
        datosPorCajon0.add(new Producto("Salmon", "Pescados", "8", R.drawable.salmon, "Salmon fresco. Origen Noruega.", "03/05/2020",0));
        datosPorCajon1.add(new Producto("Pollo", "Carnes", "3", R.drawable.pollo, "Pollo fresco", "03/05/2020",1));
        datosPorCajon1.add(new Producto("Macarrones", "Pastas", "4", R.drawable.macarrones, "Macarrones hacendado", "03/05/2020",1));
        datosPorCajon2.add(new Producto("Spaguetti", "Pastas", "2", R.drawable.spaghetti, "descripcion", "03/05/2020",2));
        datosPorCajon2.add(new Producto("Cinta de lomo", "Carnes", "4", R.drawable.cintalomo, "descripcion", "03/05/2020",2));
        datosPorCajon2.add(new Producto("Pollo", "Carnes", "1", R.drawable.ic_tienda, "descripcion", "03/05/2020",2));



        datos.put(0,datosPorCajon0);
        datos.put(1,datosPorCajon1);
        datos.put(2,datosPorCajon2);


    }

    public static Stock getInstance() {
        if (instance == null) {
            instance = new Stock();
        }
        return instance;
    }



    public ArrayList<Producto> getDatosPorCajon(Integer cajon) {
        return datos.get(cajon);
    }

    public void insertarDatosPorCajon(Integer cajon, Producto producto) {
                datos.get(cajon).add(producto);
    }

    public HashMap<Integer, ArrayList<Producto>> getDatos() {
        return datos;
    }


    public void eliminarProducto(Producto producto, Integer cajon) {
                datos.get(cajon).remove(producto);
    }


}