package com.smartfreeze.ui.bottom_menu;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.gustavofao.materialtabs.SlidingFragmentPagerAdapter;
import com.gustavofao.materialtabs.SlidingTabLayout;
import com.gustavofao.materialtabs.TabType;
import com.smartfreeze.IPrincipalListener;
import com.smartfreeze.R;
import com.smartfreeze.domain.Boton;
import com.smartfreeze.ui.adapter.InicioPagerAdapter;
import com.smartfreeze.ui.fragments.DispensadorTab;
import com.smartfreeze.ui.fragments.NeveraTab;

import java.util.HashMap;
import java.util.Map;

public class PrincipalOpcion extends Fragment implements DispensadorTab.OnFragmentInteractionListener, NeveraTab.OnFragmentInteractionListener {

    //Crear array de botones
    private final int[] BOTONESMENU = {R.id.boton_principal};
    private Boton[] botonesNevera = new Boton[BOTONESMENU.length];
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;




    public PrincipalOpcion() {
        //Constructor vacio
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.opcion_principal, container, false);

        Button botonAux;
        for (int i = 0; i < BOTONESMENU.length; i++) {
            botonAux = (Button) vista.findViewById(BOTONESMENU[i]);
            final int botonSelec = i;
            botonesNevera[i] = new Boton(i, 0);
            botonAux.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    botonesNevera[botonSelec].setFlagAbierto(botonesNevera[botonSelec].getFlagAbierto() + 1);
                    Activity estaActividad = getActivity();
                    ((IPrincipalListener) estaActividad).botonSeleccionado(botonesNevera[botonSelec]);
                    //((IPrincipalListener) estaActividad).botonSeleccionado(botonSelec);
                }
            });
        }

        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.pager);
        toolbar= view.findViewById(R.id.toolbar);

        tabLayout.addTab(tabLayout.newTab().setText("Nevera"));
        tabLayout.addTab(tabLayout.newTab().setText("Dispensador"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("ho","hilsa");
    }

    private void setUpViewPager(ViewPager viewPager){
        InicioPagerAdapter adapter = new InicioPagerAdapter(getActivity().getSupportFragmentManager(),tabLayout.getTabCount());
        adapter.addFragment(new DispensadorTab());
        adapter.addFragment(new NeveraTab());

        viewPager.setAdapter(adapter);

    }
}
