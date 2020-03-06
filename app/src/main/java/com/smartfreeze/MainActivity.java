package com.smartfreeze;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smartfreeze.domain.EnumBotonesPrincipal;
import com.smartfreeze.ui.bottom_menu.AjustesOpcion;
import com.smartfreeze.ui.bottom_menu.PrincipalOpcion;
import com.smartfreeze.ui.bottom_menu.TiendaOpcion;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements IPrincipalListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_main, new PrincipalOpcion()).commit();
        }

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
                            fragment = new AjustesOpcion();
                            break;

                        case R.id.navigation_principal:
                            fragment = new PrincipalOpcion();
                            break;

                        case R.id.navigation_tienda:
                            fragment = new TiendaOpcion();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_main, fragment).commit();
                    return true;
                }
            };



    public void botonSeleccionado(int botonSelec) {
        String resul = EnumBotonesPrincipal.cajon(botonSelec);
        Log.e("11111111",resul);
        Toast.makeText(getApplicationContext(),resul,Toast.LENGTH_LONG).show();
    }
}
