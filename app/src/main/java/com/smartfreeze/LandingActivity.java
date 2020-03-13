package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smartfreeze.domain.LandingPages;
import com.smartfreeze.ui.adapter.LandingAdapter;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {
    private List<LandingPages> listaView = new ArrayList<LandingPages>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        setListaView();
        ViewPager viewPager =  findViewById(R.id.viewpager);
        viewPager.setAdapter(new LandingAdapter(this,listaView));
        //ViewPagerIndicator viewPagerIndicator = findViewById(R.id.viewPagerIndicator);

        //viewPagerIndicator.initWithViewPager(viewPager);
        Button btnSaltar = findViewById(R.id.btnSaltar);

        btnSaltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void setListaView() {
        listaView.add(LandingPages.values()[0]);
        listaView.add(LandingPages.values()[1]);
        listaView.add(LandingPages.values()[2]);
        listaView.add(LandingPages.values()[3]);
        listaView.add(LandingPages.values()[4]);
    }


}
