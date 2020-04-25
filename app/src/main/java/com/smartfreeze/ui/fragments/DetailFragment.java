package com.smartfreeze.ui.fragments;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.smartfreeze.MainActivity;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

public class DetailFragment extends Fragment {

    Producto producto;
    TextView descripcionLabel, description, precio, titulo;
    NestedScrollView scrollView;
    View mainContainer;
    ConstraintLayout dataContainer;
    ImageView imagen;
    EditText cantidad;
    Button anadirCarrito;

    public DetailFragment(Producto producto) {
        this.producto = producto;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        descripcionLabel = v.findViewById(R.id.descriptionLabel);
        description = v.findViewById(R.id.description);
        scrollView = v.findViewById(R.id.scrollView);
        mainContainer = v.findViewById(R.id.mainContainer);
        dataContainer = v.findViewById(R.id.dataContainer);
        precio = v.findViewById(R.id.priceValue);
        imagen = v.findViewById(R.id.galleryContainer);
        titulo = v.findViewById(R.id.productTitle);
        cantidad = v.findViewById(R.id.quantityEditText);
        anadirCarrito = v.findViewById(R.id.cartButton);

        int drawable = producto.getDrawable();
        Drawable img = getContext().getResources().getDrawable(drawable);
        imagen.setImageDrawable(img);
        precio.setText(producto.getPrecio());
        titulo.setText(producto.getNombre());
        description.setText(producto.getCategorioa());
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupDescripcion();

        anadirCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);
    }

    private void setupDescripcion() {
        final Transition transition = new ChangeBounds();
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionEnd(@NonNull Transition transition) {
                if(description.getHeight() != 0){
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            ObjectAnimator.ofInt(scrollView, "scrollY", ((int) descripcionLabel.getY()))
                                    .setDuration(400L)
                                    .start();
                        }
                    });


                }
            }

            @Override
            public void onTransitionCancel(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionPause(@NonNull Transition transition) {

            }

            @Override
            public void onTransitionResume(@NonNull Transition transition) {

            }
        });

        descripcionLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition((ViewGroup) mainContainer, transition);
                Boolean isExpanded = description.getHeight() != 0;
                int icon, height;
                if(isExpanded) {
                    icon= R.drawable.ic_plus;
                    height = 0;
                }
                else {
                    icon = R.drawable.ic_minus;
                    height = ViewGroup.LayoutParams.WRAP_CONTENT;
                }

                descripcionLabel.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,icon,0);

                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone(dataContainer);
                constraintSet.constrainHeight(description.getId(), height);
                constraintSet.applyTo(dataContainer);

            }
        });

    }
}
