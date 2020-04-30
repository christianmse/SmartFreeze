package com.smartfreeze.ui.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.smartfreeze.IDespensaListener;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class SubItemAdapter extends RecyclerView.Adapter<SubItemAdapter.TiendaViewHolder> {
    private ArrayList<Producto> listaProductos;
    private Context context;
    IDespensaListener listener;


    public SubItemAdapter(ArrayList<Producto> listaProductos, Context context, IDespensaListener listener) {
        this.context = context;
        this.listener = listener;
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public TiendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.subitem_producto,parent,false);
        TiendaViewHolder holder = new TiendaViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TiendaViewHolder holder, int position) {
        String titulo = listaProductos.get(position).getNombre();
        String subtitulo = listaProductos.get(position).getCategorioa();
        String precio = listaProductos.get(position).getPrecio();
        String caducidad = listaProductos.get(position).getCaducidad();
        int cantidad = listaProductos.get(position).getCantidad();
        String descripcion = listaProductos.get(position).getDescripcion() + "\n" +
                "Fecha de caducidad: " + caducidad + "\n" +
                "Cantidad: " + cantidad;

        int drawable = listaProductos.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);


        holder.imagen.setImageDrawable(img);
        holder.titulo.setText(titulo);
        holder.subtitulo.setText(subtitulo);
        holder.descripcion.setText(descripcion);

        holder.accion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.accion2();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }


    public static class TiendaViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo;
        private TextView subtitulo;
        private TextView descripcion, caducidad, cantidad, descripcionLabel;
        private ImageView imagen;
        private Button accion2;
        private ImageButton btn_expand;
        private View lyt_caducidad, lyt_cantidad, mainContainer;
        private NestedScrollView scrollView;
        ConstraintLayout dataContainer;


        public TiendaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.media_image);
            titulo = (TextView) itemView.findViewById(R.id.primary_text);
            subtitulo = itemView.findViewById(R.id.sub_text);
            accion2= itemView.findViewById(R.id.action_button_2);
            descripcionLabel = itemView.findViewById(R.id.descriptionLabel);
            descripcion = itemView.findViewById(R.id.description);




            scrollView = itemView.findViewById(R.id.scrollView);
            mainContainer = itemView.findViewById(R.id.mainContainer);
            dataContainer = itemView.findViewById(R.id.dataContainer);


            setupDescripcion();



        }

        private void setupDescripcion(){
            final Transition transition = new ChangeBounds();

            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(@NonNull Transition transition) {

                }

                @Override
                public void onTransitionEnd(@NonNull Transition transition) {
                    if(descripcion.getHeight() != 0){
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
                    Boolean isExpanded = descripcion.getHeight() != 0;
                    int icon, height;
                    if(isExpanded) {
                        icon= R.drawable.ic_expand_more_black_36dp;
                        height = 0;
                    } else {
                        icon = R.drawable.ic_expand_less_black_36dp;
                        height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    }

                    descripcionLabel.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,icon,0);

                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(dataContainer);
                    constraintSet.constrainHeight(descripcion.getId(), height);
                    constraintSet.applyTo(dataContainer);
                }
            });
        }


    }
}
