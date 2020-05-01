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
    private static ArrayList<Producto> datosporCajon3 = new ArrayList<>();
    private static ArrayList<Producto> datosporCajon4 = new ArrayList<>();
    private static ArrayList<Producto> datosporCajon5 = new ArrayList<>();
    private static ArrayList<Producto> datosporCajon6 = new ArrayList<>();
    private static ArrayList<Producto> datosporCajon7 = new ArrayList<>();
    private static ArrayList<Producto> datosporCajon8 = new ArrayList<>();
    private static ArrayList<Producto> datosporCajon9 = new ArrayList<>();
    private static ArrayList<Producto> datosporCajon10 = new ArrayList<>();
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



        //cajon 1

        datosPorCajon1.add(new Producto("Tomates", "Verduras", "8", R.drawable.tomates, "Tomates bio","07/10/2022",1));
        datosPorCajon1.add(new Producto("Calabacín", "Verduras", "9", R.drawable.calabacin, "Calabacín de huerta familiar","07/10/2022",1));
        datosPorCajon1.add(new Producto("Espárragos", "Verduras", "2", R.drawable.esparragos, "Espárragos frescos manchegos","07/10/2022",1));
        datosPorCajon1.add(new Producto("Berenjena", "Verduras", "8", R.drawable.berenjena, "Berenjenas de granja de increíble sabor","07-10-22",1));
        datosPorCajon1.add(new Producto("Pollo", "Carnes", "3", R.drawable.pollo, "Pollo fresco", "03/05/2020",1));
        datosPorCajon1.add(new Producto("Macarrones", "Pastas", "4", R.drawable.macarrones, "Macarrones hacendado", "03/05/2020",1));

        //cajon 2

        datosPorCajon2.add(new Producto("Fanta Naranja", "Bebidas", "2", R.drawable.fanta_naranja, "Fanta Naranja 2L","20/06/2020",2));
        datosPorCajon2.add(new Producto("Fanta Limón", "Bebidas", "2", R.drawable.fanta_limon, "Fanta Limón 2L","20/06/2020",2));
        datosPorCajon2.add(new Producto("Coca Cola", "Bebidas", "2", R.drawable.cocacola, "CocaCola de 2L","20/06/2020",2));
        datosPorCajon2.add(new Producto("Agua con gas", "Bebidas", "4", R.drawable.aguagas, "Agua con gas, espléndido sabor","20/06/2020",2));
        datosPorCajon2.add(new Producto("Zumo de naranja", "Bebidas", "4", R.drawable.zumo_naranja, "Zumo natural","20/06/2020",2));
        datosPorCajon2.add(new Producto("Spaguetti", "Pastas", "2", R.drawable.spaghetti, "descripcion", "03/05/2020",2));
        datosPorCajon2.add(new Producto("Cinta de lomo", "Carnes", "4", R.drawable.cintalomo, "descripcion", "03/05/2020",2));
        datosPorCajon2.add(new Producto("Pollo", "Carnes", "1", R.drawable.ic_tienda, "descripcion", "03/05/2020",2));

        // cajon 3

        datosporCajon3.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno", "04/08/2020",3));
        datosporCajon3.add(new Producto("Lentejas", "Legumbres", "2", R.drawable.lentejas, "Lentejas a granel de Andalucia", "13/05/2020",3));
        datosporCajon3.add(new Producto("Salmon", "Pescados", "8", R.drawable.salmon, "Salmon fresco. Origen Noruega.", "23/05/2020",3));
        datosporCajon3.add(new Producto("Pollo", "Carnes", "3", R.drawable.pollo, "Pollo fresco", "03/05/2020",3));

        // cajon 4

        datosporCajon4.add(new Producto("Macarrones", "Pastas", "4", R.drawable.macarrones, "Macarrones hacendado","20/09/2021",4));
        datosporCajon4.add(new Producto("Spaguetti", "Pastas", "2", R.drawable.spaghetti, "descripcion","20/09/2021",4));
        datosporCajon4.add(new Producto("Raviolis", "Pastas", "6", R.drawable.raviolis, "Pasta italiana, calidad Romana","20/09/2021",4));
        datosporCajon4.add(new Producto("Capeletis", "Pastas", "10", R.drawable.capeletis, "Pasta italiana, calidad Romana","20/09/2021",4));
        datosporCajon4.add(new Producto("Noodles", "Pastas", "14", R.drawable.noodles, "Noodles de importación japonesa","20/09/2021",4));

        // cajon5

        datosporCajon5.add(new Producto("Macarrones", "Pastas", "4", R.drawable.macarrones, "Macarrones hacendado","11/11/22",5));
        datosporCajon5.add(new Producto("Spaguetti", "Pastas", "2", R.drawable.spaghetti, "descripcion","11/11/22",5));
        datosporCajon5.add(new Producto("Raviolis", "Pastas", "6", R.drawable.raviolis, "Pasta italiana, calidad Romana","11/11/22",5));
        datosporCajon5.add(new Producto("Capeletis", "Pastas", "10", R.drawable.capeletis, "Pasta italiana, calidad Romana","11/11/22",5));
        datosporCajon5.add(new Producto("Noodles", "Pastas", "14", R.drawable.noodles, "Noodles de importación japonesa","11/11/22",5));

        // cajon 6

        datosporCajon6.add(new Producto("Macarrones", "Pastas", "4", R.drawable.macarrones, "Macarrones hacendado","20/11/2020",6));
        datosporCajon6.add(new Producto("Spaguetti", "Pastas", "2", R.drawable.spaghetti, "descripcion","20/11/2020",6));
        datosporCajon6.add(new Producto("Raviolis", "Pastas", "6", R.drawable.raviolis, "Pasta italiana, calidad Romana","20/11/2020",6));
        datosporCajon6.add(new Producto("Capeletis", "Pastas", "10", R.drawable.capeletis, "Pasta italiana, calidad Romana","20/11/2020",6));
        datosporCajon6.add(new Producto("Noodles", "Pastas", "14", R.drawable.noodles, "Noodles de importación japonesa","20/11/2020",6));

        // cajon 7

        datosporCajon7.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno", "07/08/2020",7));
        datosporCajon7.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno", "06/08/2020",7));
        datosporCajon7.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno", "06/08/2020",7));

        // cajon 8
        datosporCajon8.add(new Producto("Hamburguesa", "Carnes", "4", R.drawable.hamburguesa, "Hamburgesa de carne vacuno", "03/05/2022",8));
        datosporCajon8.add(new Producto("Pollo", "Carnes", "3", R.drawable.pollo, "Pollo fresco", "03/05/2022",8));

        //cajon 9
        datosporCajon9.add(new Producto("Zumo de naranja", "Bebidas", "4", R.drawable.zumo_naranja, "Zumo natural","22/02/20",9));
        datosporCajon9.add(new Producto("Zumo de naranja", "Bebidas", "4", R.drawable.zumo_naranja, "Zumo natural","22/02/20",9));
        datosporCajon9.add(new Producto("Zumo de naranja", "Bebidas", "4", R.drawable.zumo_naranja, "Zumo natural","22/02/20",9));



        datos.put(0,datosPorCajon0);
        datos.put(1,datosPorCajon1);
        datos.put(2,datosPorCajon2);
        datos.put(3,datosporCajon3);
        datos.put(4,datosporCajon4);
        datos.put(5,datosporCajon5);
        datos.put(6,datosporCajon6);
        datos.put(7,datosporCajon7);
        datos.put(8,datosporCajon8);
        datos.put(9,datosporCajon9);
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