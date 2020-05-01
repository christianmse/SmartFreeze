package com.smartfreeze.ui.adapter;


import android.content.Context;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import android.widget.ImageView;


import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.R;

import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class AjustesAdapter extends RecyclerView.Adapter<AjustesAdapter.AjustesViewHolder> {
    private ArrayList<Producto> listaProductos;
    private Context context;

    public AjustesAdapter(ArrayList<Producto> listaProductos, Context context){
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @Override
    public int getItemViewType(int position) {
        return listaProductos.size();
    }

    @NonNull
    @Override
    public AjustesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ajuste, parent,false);
        AjustesViewHolder holder = new AjustesViewHolder(vista);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull AjustesViewHolder holder, int position) {
        String titulo = listaProductos.get(position).getNombre();
        int drawable = listaProductos.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);


        holder.imagen.setImageDrawable(img);
        holder.titulo.setText(titulo);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }



    public static class AjustesViewHolder extends RecyclerView.ViewHolder{

        private TextView titulo;

        private ImageView imagen;

        ConstraintLayout dataContainer;

        public AjustesViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.media_image);
            titulo = (TextView) itemView.findViewById(R.id.primary_text);
            dataContainer = itemView.findViewById(R.id.dataContainer);

        }

    }

    public ArrayList<Producto> getData(){
        return this.listaProductos;
    }
}
