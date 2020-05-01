package com.smartfreeze;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.adapter.DespensaAdapter2;
import com.smartfreeze.util.Stock;

import java.util.ArrayList;

public class ListadoComida extends AppCompatActivity implements View.OnCreateContextMenuListener, IDespensaListener {
//Cambiar para cada 1
    private ArrayList<Producto> datosProducto0, datosProducto1, datosProducto2, datosProducto3,
            datosProducto4, datosProducto5, datosProducto6, datosProducto7, datosProducto8, datosProducto9;
    private Producto auxp;
    private GridLayoutManager manager;
    public static DespensaAdapter2 adapter2;
    private RecyclerView recyclerView;
    private int boton, cajon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_comida);

        datosProducto0 = Stock.getInstance().getDatosPorCajon(0);
        datosProducto1 = Stock.getInstance().getDatosPorCajon(1);
        datosProducto2 = Stock.getInstance().getDatosPorCajon(2);
        datosProducto3 = Stock.getInstance().getDatosPorCajon(3);
        datosProducto4 = Stock.getInstance().getDatosPorCajon(4);
        datosProducto5 = Stock.getInstance().getDatosPorCajon(5);
        datosProducto6 = Stock.getInstance().getDatosPorCajon(6);
        datosProducto7 = Stock.getInstance().getDatosPorCajon(7); //ESTE TIENEN QUE SER BOTELLAS, ESTANTE 1 DE LA NEVERA
        datosProducto8 = Stock.getInstance().getDatosPorCajon(8);
        datosProducto9 = Stock.getInstance().getDatosPorCajon(9);
//      INICIO DE CAJONES

//      FIN
        recyclerView = findViewById(R.id.recycler_listadoComida);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        boton = intent.getIntExtra("Boton", 0);
        manager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(manager);

        registerForContextMenu(recyclerView);

            switch (boton) {
//            FRIGORIFICO
                case R.id.b3Cajon:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(6), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto6.get(position);
                                    Stock.getInstance().getDatosPorCajon(6).remove(auxp);
                                    cajon = 6;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b2Cajon:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(5), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto5.get(position);
                                    Stock.getInstance().getDatosPorCajon(5).remove(auxp);
                                    cajon = 5;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b1Cajon:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(4), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto4.get(position);
                                    Stock.getInstance().getDatosPorCajon(4).remove(auxp);
                                    cajon = 4;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
//            NEVERA
                case R.id.b1Nevera:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(0), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto0.get(position);
                                    Stock.getInstance().getDatosPorCajon(0).remove(auxp);
                                    cajon = 0;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b2Nevera:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(1), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto1.get(position);
                                    Stock.getInstance().getDatosPorCajon(1).remove(auxp);
                                    cajon = 1;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b3Nevera:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(2), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto2.get(position);
                                    Stock.getInstance().getDatosPorCajon(2).remove(auxp);
                                    cajon = 2;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.b4CajonIzq:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(3), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto3.get(position);
                                    Stock.getInstance().getDatosPorCajon(3).remove(auxp);
                                    cajon = 3;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.bEstante3:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(7), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto7.get(position);
                                    Stock.getInstance().getDatosPorCajon(7).remove(auxp);
                                    cajon = 7;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.bEstante2:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(8), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto8.get(position);
                                    Stock.getInstance().getDatosPorCajon(8).remove(auxp);
                                    cajon = 8;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                case R.id.bEstante1:
                    adapter2 = new DespensaAdapter2(getApplicationContext(), Stock.getInstance().getDatosPorCajon(9), this);
                    recyclerView.setAdapter(adapter2);
                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
//                                    Toast.makeText(ListadoComida.this, "Click corto", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onLongItemClick(View view, int position) {
                                    auxp = datosProducto9.get(position);
                                    Stock.getInstance().getDatosPorCajon(9).remove(auxp);
                                    cajon = 9;
                                    recyclerView.showContextMenu();
                                }
                            }));
                    break;
                default:
                    Toast.makeText(this, "SOME ERROR HAPPENED", Toast.LENGTH_LONG).show();
                    break;
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
                Intent intent = new Intent(this, SeleccionCajon.class);
                intent.putExtra("Elemento", auxp);
                intent.putExtra("Cajon", cajon);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void sacarProducto(){
        Toast.makeText(this, "Producto sacado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void accion2(int cajonAntiguo, Producto producto){
    }
}