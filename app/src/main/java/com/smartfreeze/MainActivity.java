package com.smartfreeze;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smartfreeze.domain.Boton;
import com.smartfreeze.ui.bottom_menu.AjustesOpcion;
import com.smartfreeze.ui.bottom_menu.PrincipalOpcion;
import com.smartfreeze.ui.bottom_menu.TiendaOpcion;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements IPrincipalListener {
    RelativeLayout notificacionesLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_main, new PrincipalOpcion()).commit();
        }
        notificacionesLayout = findViewById(R.id.notificaciones_layout);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

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
                            notificacionesLayout.setVisibility(View.VISIBLE);
                            break;

                        case R.id.navigation_tienda:
                            fragment = new TiendaOpcion();
                            notificacionesLayout.setVisibility(View.GONE);
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
}
