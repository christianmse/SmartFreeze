package com.smartfreeze.ui.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.smartfreeze.ui.fragments.DispensadorTab;
import com.smartfreeze.ui.fragments.NeveraTab;

import java.util.ArrayList;
import java.util.List;

public class InicioPagerAdapter extends FragmentPagerAdapter {

    int numTabs;
    final int NEVERA =0;
    final int DISPENSADOR=1;
    List<Fragment> fragmentList = new ArrayList<>();

    public InicioPagerAdapter(@NonNull FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putString(NeveraTab.ARG_OBJECT, "hola");
        Fragment fragment = fragmentList.get(position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragments(Fragment fragment){
        fragmentList.add(fragment);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String nombre;

        switch (position){
            case 0: nombre=
                    ((DispensadorTab)fragmentList.get(position)).getNombre();
            break;
            case 1: nombre =
                    ((NeveraTab)fragmentList.get(position)).getNombre();
            break;

            default: nombre="default";
            break;
        }

        return nombre;
    }
}
