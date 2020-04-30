package com.smartfreeze.util;

import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class Datos {
    private static Datos instance = null;
    private static ArrayList<Producto> datosTienda = new ArrayList<>();

    //Categorias:
    //        <item>Carnes</item>
    //        <item>Frutas</item>
    //        <item>Bebidas</item>
    //        <item>Pescados</item>
    //        <item>Pastas</item>
    //        <item>Legumbres</item>

    public Datos(){
        datosTienda.add(new Producto("Fanta Naranja", "Bebidas", "2", R.drawable.fanta_naranja, "Fanta Naranja 2L"));
        datosTienda.add(new Producto("Fanta Limón", "Bebidas", "2", R.drawable.fanta_limon, "Fanta Limón 2L"));
        datosTienda.add(new Producto("Coca Cola", "Bebidas", "2", R.drawable.cocacola, "CocaCola de 2L"));
        datosTienda.add(new Producto("Agua con gas", "Bebidas", "4", R.drawable.aguagas, "Agua con gas, espléndido sabor"));
        datosTienda.add(new Producto("Zumo de naranja", "Bebidas", "4", R.drawable.zumo_naranja, "Zumo natural"));
        datosTienda.add(new Producto("Salmon", "Pescados", "8", R.drawable.salmon, "Salmon fresco. Origen Noruega."));
        datosTienda.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno"));
        datosTienda.add(new Producto("Pollo", "Carnes", "3", R.drawable.pollo, "Pollo fresco"));
        datosTienda.add(new Producto("Costillas", "Carnes", "13", R.drawable.costillas, "Costillas de cerdo de jabugo"));
        datosTienda.add(new Producto("Solomillo de cerdo", "Carnes", "17", R.drawable.solomillo_cerdo, "Solomillo de primerísisma calidad"));
        datosTienda.add(new Producto("Cinta de lomo", "Carnes", "4", R.drawable.cintalomo, "Carne de calidad extremeña"));
        datosTienda.add(new Producto("Macarrones", "Pastas", "4", R.drawable.macarrones, "Macarrones hacendado"));
        datosTienda.add(new Producto("Spaguetti", "Pastas", "2", R.drawable.spaghetti, "descripcion"));
        datosTienda.add(new Producto("Raviolis", "Pastas", "6", R.drawable.raviolis, "Pasta italiana, calidad Romana"));
        datosTienda.add(new Producto("Capeletis", "Pastas", "10", R.drawable.capeletis, "Pasta italiana, calidad Romana"));
        datosTienda.add(new Producto("Noodles", "Pastas", "14", R.drawable.noodles, "Noodles de importación japonesa"));
        datosTienda.add(new Producto("Lechuga", "Verduras", "3", R.drawable.lechuga, "Lechuga fresca"));
        datosTienda.add(new Producto("Tomates", "Verduras", "8", R.drawable.tomates, "Tomates bio"));
        datosTienda.add(new Producto("Calabacín", "Verduras", "9", R.drawable.calabacin, "Calabacín de huerta familiar"));
        datosTienda.add(new Producto("Espárragos", "Verduras", "2", R.drawable.esparragos, "Espárragos frescos manchegos"));
        datosTienda.add(new Producto("Berenjena", "Verduras", "8", R.drawable.berenjena, "Berenjenas de granja de increíble sabor"));

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
