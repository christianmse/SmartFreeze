package com.smartfreeze.ui.bottom_menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.google.android.material.tabs.TabLayout;
import com.smartfreeze.R;
import com.smartfreeze.ui.adapter.StorePagerAdapter;
import com.smartfreeze.ui.fragments.HomeFragment;

import java.util.Objects;


public class StoreFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

public StoreFragment(){
    //Constructor vacio
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewPager = view.findViewById(R.id.mainViewPager);
        setupViewPager(viewPager);

        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        final FloatingSearchView mSearchView = view.findViewById(R.id.search_view);

        mSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        StorePagerAdapter adapter = new StorePagerAdapter(getChildFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new HomeFragment(), "Games");
        adapter.addFragment(new HomeFragment(), "Movies");
        adapter.addFragment(new HomeFragment(), "Books");
        adapter.addFragment(new HomeFragment(), "Music");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabOne.setText("Carnes");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_explorer, 0, 0);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabTwo.setText("Pescados");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_explorer, 0, 0);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabThree.setText("Frutas");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_explorer, 0, 0);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabFour.setText("Verduras");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_explorer, 0, 0);
        Objects.requireNonNull(tabLayout.getTabAt(3)).setCustomView(tabFour);

        TextView tabFive = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_sub_tab, null);
        tabFive.setText("Pastas");
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_explorer, 0, 0);
        Objects.requireNonNull(tabLayout.getTabAt(4)).setCustomView(tabFive);
    }
}
