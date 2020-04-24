package com.smartfreeze;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smartfreeze.domain.Boton;
import com.smartfreeze.domain.Notificacion;
import com.smartfreeze.ui.adapter.NotificacionesAdapter;
import com.smartfreeze.ui.bottom_menu.AjustesOpcion;
import com.smartfreeze.ui.bottom_menu.PrincipalOpcion;
import com.smartfreeze.ui.bottom_menu.StoreFragment;
import com.smartfreeze.ui.bottom_menu.TiendaOpcion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IPrincipalListener {
    RelativeLayout notificacionesLayout;
    NotificacionesAdapter adapter;
    RecyclerView recyclerView;
    public static BottomNavigationView bottomNavigationView;
    public static FragmentManager fm;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        if(savedInstanceState == null){
            fm.beginTransaction().replace(R.id.frameLayout_main, new PrincipalOpcion()).commit();
        }
        notificacionesLayout = findViewById(R.id.notificaciones_layout);
        bottomNavigationView = findViewById(R.id.nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        recyclerView = findViewById(R.id.recycler_principal);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotificacionesAdapter(getNotificacionesList(),this);
        recyclerView.setAdapter(adapter);

    }



    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()){
                        case R.id.navigation_ajustes:
                           notificacionesLayout.setVisibility(View.GONE);
                            fragment = new AjustesOpcion();
                            break;

                        case R.id.navigation_principal:
                            fragment = new PrincipalOpcion();
                            //notificacionesLayout.setVisibility(View.VISIBLE);
                            break;

                        case R.id.navigation_tienda:
                            fragment = new TiendaOpcion();
                            //notificacionesLayout.setVisibility(View.GONE);
                            break;

                        case R.id.navigation_store:
                            fragment = new StoreFragment();
                            //notificacionesLayout.setVisibility(View.GONE);
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_main, fragment).commit();
                    return true;
                }
            };



    public void botonSeleccionado(Boton botonSelec) {
        String resul="..........";
        switch (botonSelec.getId()){
            case 0: if(botonSelec.getFlagAbierto() % 2 == 0)
                        resul = "Cajon frutas 0 cerrado";
                    else {
                        resul = "Cajon frutas 0 abierto";

            }
                    break;

        }
        Toast.makeText(this,resul,Toast.LENGTH_SHORT).show();
    }

    private ArrayList<Notificacion> getNotificacionesList(){
        ArrayList<Notificacion> notificacionesList = new ArrayList<>();

        notificacionesList.add(new Notificacion("rojo", "producto a caducado"));
        notificacionesList.add(new Notificacion("rojo", "producto b caducado"));
        notificacionesList.add(new Notificacion("amarillo", "producto c caducado"));
        notificacionesList.add(new Notificacion("verde", "producto d caducado"));

        return notificacionesList;

    }


    public static void replaceFragmentNoBottomNavigation(Fragment fragment){

        fm.beginTransaction().replace(R.id.frameLayout_main2, fragment)
                .addToBackStack(null)
                .commit();
        bottomNavigationView.setVisibility(View.GONE);

    }
}
