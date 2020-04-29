package com.smartfreeze;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.smartfreeze.domain.Ajustes;
import com.smartfreeze.ui.adapter.AjustesAdapter;

import java.util.ArrayList;

public class ListadoComida extends AppCompatActivity implements View.OnCreateContextMenuListener {

    private ArrayList<Ajustes> datosComida8 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida7 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida6 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida5 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida4 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida3 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida2 = new ArrayList<>();
    private ArrayList<Ajustes> datosComida1 = new ArrayList<>();
    private ArrayList<Ajustes> datosEstante2 = new ArrayList<>();
    private ArrayList<Ajustes> datosEstante3 = new ArrayList<>();
    private ArrayList<Ajustes> datosBebidas = new ArrayList<>();
    private Ajustes aux;
    AjustesAdapter adapter;
    RecyclerView recyclerView;
    private int boton;
    static int ccajon;
    private String elemento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_comida);

//      INICIO DE CAJONES
        setDatosComida1();
        setDatosComida2();
        setDatosComida3();
        setDatosComida4();
        setDatosComida5();
        setDatosComida6();
        setDatosComida7();
        setDatosComida8();
        setDatosEstante2();
        setDatosEstante3();
        setDatosBebidas();
//      FIN
        recyclerView = findViewById(R.id.recycler_listadoComida);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        boton = intent.getIntExtra("Boton", 0);
        ccajon = intent.getIntExtra("CCajon", 0);
        elemento = intent.getStringExtra("Elemento");
        if(ccajon == 0) {

            switch (boton) {
//            FRIGORIFICO
                case R.id.b3Cajon:
                    adapter = new AjustesAdapter(getDatosComidaCF3(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b2Cajon:
                    adapter = new AjustesAdapter(getDatosComidaCF2(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b1Cajon:
                    adapter = new AjustesAdapter(getDatosComidaCF1(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                     aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
//            NEVERA
                case R.id.b1Nevera:
                    adapter = new AjustesAdapter(getDatosComidaCN1(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b2Nevera:
                    adapter = new AjustesAdapter(getDatosComidaCN2(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b3Nevera:
                    adapter = new AjustesAdapter(getDatosComidaCN3(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b4CajonIzq:
                    adapter = new AjustesAdapter(getDatosComidaCN4(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b5CajonDer:
                    adapter = new AjustesAdapter(getDatosComidaCN5(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.bEstante3:
                    adapter = new AjustesAdapter(getDatosComidaE1(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.bEstante2:
                    adapter = new AjustesAdapter(getDatosComidaE2(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.bEstante1:
                    adapter = new AjustesAdapter(getListaBebidas(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    aux = adapter.getData().get(position);
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                default:
                    Toast.makeText(this, "SOME ERROR HAPPENED", Toast.LENGTH_LONG).show();
                    break;
            }
        }
        else {
            switch (ccajon){
                case R.id.b3Cajon:
                    adapter = new AjustesAdapter(getDatosComidaCF3(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.b2Cajon:
                    adapter = new AjustesAdapter(getDatosComidaCF2(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.b1Cajon:
                    adapter = new AjustesAdapter(getDatosComidaCF1(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.b1Nevera:
                    adapter = new AjustesAdapter(getDatosComidaCN1(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.b2Nevera:
                    adapter = new AjustesAdapter(getDatosComidaCN2(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.b3Nevera:
                    adapter = new AjustesAdapter(getDatosComidaCN3(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.b4CajonIzq:
                    adapter = new AjustesAdapter(getDatosComidaCN4(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.b5CajonDer:
                    adapter = new AjustesAdapter(getDatosComidaCN5(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.bEstante1:
                    adapter = new AjustesAdapter(getListaBebidas(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.bEstante2:
                    adapter = new AjustesAdapter(getDatosComidaE1(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
                case R.id.bEstante3:
                    adapter = new AjustesAdapter(getDatosComidaE2(), this);
                    recyclerView.setAdapter(adapter);
                    registerForContextMenu(recyclerView);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.card_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.sacar:
                sacarProducto();
                return true;
            case R.id.cambiar_cajon:
                Toast.makeText(this, aux.getNombre(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, SeleccionCajon.class);
                intent.putExtra("Elemento", aux.getNombre());
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    //    CAJONES DEL FRIGORIIFCO
    public ArrayList<Ajustes> getDatosComidaCF3(){

        return datosComida8;
    }
    public void setDatosComida8(){
        datosComida8.add(new Ajustes("Pollo c3f", R.drawable.pollo));
        datosComida8.add(new Ajustes("Filetes de ternera", R.drawable.filete));
        datosComida8.add(new Ajustes("Salmón", R.drawable.pescado));
        datosComida8.add(new Ajustes("Atún", R.drawable.pescado));
        datosComida8.add(new Ajustes("Filetes de potro", R.drawable.filete));
        datosComida8.add(new Ajustes("Queso", R.drawable.queso));
    }

    public ArrayList<Ajustes> getDatosComidaCF2(){
        return datosComida7;
    }
    public void setDatosComida7(){
        datosComida7.add(new Ajustes("Pollo c2f", R.drawable.pollo));
        datosComida7.add(new Ajustes("Filetes de ternera", R.drawable.filete));
        datosComida7.add(new Ajustes("Salmón", R.drawable.pescado));
        datosComida7.add(new Ajustes("Atún", R.drawable.pescado));
        datosComida7.add(new Ajustes("Boquerones", R.drawable.pescado));
        datosComida7.add(new Ajustes("Mozzarella", R.drawable.queso));
    }

    public ArrayList<Ajustes> getDatosComidaCF1(){
        return datosComida6;
    }
    public void setDatosComida6(){
        datosComida6.add(new Ajustes("Poll0 c1f", R.drawable.pollo));
        datosComida6.add(new Ajustes("Filetes de ternera", R.drawable.filete));
        datosComida6.add(new Ajustes("Salmón", R.drawable.pescado));
        datosComida6.add(new Ajustes("Atún", R.drawable.pescado));
        datosComida6.add(new Ajustes("Filetes de potro", R.drawable.filete));
        datosComida6.add(new Ajustes("Queso", R.drawable.queso));
    }

//    CAJONES DE LA NEVERA
    public ArrayList<Ajustes> getDatosComidaCN1(){
        return datosComida5;
    }

    public void setDatosComida5() {
        datosComida5.add(new Ajustes("Poll0 c1N", R.drawable.pollo));
        datosComida5.add(new Ajustes("Filetes de salmón", R.drawable.filete));
        datosComida5.add(new Ajustes("Boquerones", R.drawable.pescado));
        datosComida5.add(new Ajustes("Atún", R.drawable.pescado));
        datosComida5.add(new Ajustes("Filetes de pescado", R.drawable.filete));
    }

    public ArrayList<Ajustes> getDatosComidaCN2(){

        return datosComida4;
    }
    public void setDatosComida4(){
        datosComida4.add(new Ajustes("Poll0 c2N", R.drawable.chicken));
        datosComida4.add(new Ajustes("Ternera", R.drawable.ternera));
        datosComida4.add(new Ajustes("Cerdo", R.drawable.cerdo));
        datosComida4.add(new Ajustes("Contramuslo de pavo", R.drawable.chicken));
        datosComida4.add(new Ajustes("Filetes de ciervo", R.drawable.filete));
        datosComida4.add(new Ajustes("Queso", R.drawable.queso));
    }
    public ArrayList<Ajustes> getDatosComidaCN3(){

        return datosComida3;
    }
    public void setDatosComida3(){
        datosComida3.add(new Ajustes("Poll0 c3N", R.drawable.chicken));
        datosComida3.add(new Ajustes("Filetes de pollo", R.drawable.filete));
        datosComida3.add(new Ajustes("Muslos de pollo", R.drawable.pollo));
        datosComida3.add(new Ajustes("Filetes de potro", R.drawable.filete));
        datosComida3.add(new Ajustes("Queso", R.drawable.queso));
    }
    public ArrayList<Ajustes> getDatosComidaCN4(){
        return datosComida2;
    }
    public void setDatosComida2(){
        datosComida2.add(new Ajustes("Helado de fresa", R.drawable.helado));
        datosComida2.add(new Ajustes("Helado de chocolate", R.drawable.helado));
        datosComida2.add(new Ajustes("Queso Mozzarella", R.drawable.queso));
    }
    public ArrayList<Ajustes> getDatosComidaCN5(){

        return datosComida1;
    }
    public void setDatosComida1(){
        datosComida1.add(new Ajustes("Pera", R.drawable.pera));
        datosComida1.add(new Ajustes("Tomate", R.drawable.tomate));
        datosComida1.add(new Ajustes("Pimiento", R.drawable.pimiento));
        datosComida1.add(new Ajustes("Queso Cheddar", R.drawable.queso));
    }

//    BEBIDAS DEL ESTANTE Y OTRAS COSAS

    public ArrayList<Ajustes> getDatosComidaE1(){

        return datosEstante2;
    }
    public void setDatosEstante2(){
        datosEstante2.add(new Ajustes("Estante 1", R.drawable.pera));
        datosEstante2.add(new Ajustes("Pera", R.drawable.pera));
        datosEstante2.add(new Ajustes("Tomate", R.drawable.tomate));
        datosEstante2.add(new Ajustes("Pimiento", R.drawable.pimiento));
        datosEstante2.add(new Ajustes("Queso Cheddar", R.drawable.queso));
    }
    public ArrayList<Ajustes> getDatosComidaE2(){

        return datosEstante3;
    }
    public void setDatosEstante3(){
        datosEstante3.add(new Ajustes("Estante 2", R.drawable.pera));
        datosEstante3.add(new Ajustes("Pera", R.drawable.pera));
        datosEstante3.add(new Ajustes("Tomate", R.drawable.tomate));
        datosEstante3.add(new Ajustes("Pimiento", R.drawable.pimiento));
        datosEstante3.add(new Ajustes("Queso Cheddar", R.drawable.queso));
    }
    public ArrayList<Ajustes> getListaBebidas(){


        return datosBebidas;
    }
    public void setDatosBebidas(){
        datosBebidas.add(new Ajustes("   Agua", R.drawable.water));
        datosBebidas.add(new Ajustes("   Cerveza", R.drawable.water));
        datosBebidas.add(new Ajustes("   Fanta", R.drawable.water));
        datosBebidas.add(new Ajustes("   Cocacola", R.drawable.water));
        datosBebidas.add(new Ajustes("   Agua con gas", R.drawable.water));
    }

    public void sacarProducto(){
        Toast.makeText(this, "Producto sacado", Toast.LENGTH_SHORT).show();
    }
     public void moverProductos(int posicion, ArrayList<Ajustes> iCajon, ArrayList<Ajustes> fCajon){
        Ajustes auxiliar;
        auxiliar = iCajon.get(posicion);
        iCajon.remove(posicion);
        fCajon.add(auxiliar);
     }

}