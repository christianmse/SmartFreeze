package com.smartfreeze.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.R;
import com.smartfreeze.domain.Ajustes;

import java.util.ArrayList;

public class AjustesAdapter extends RecyclerView.Adapter<AjustesAdapter.AjustesViewHolder> {

    private ArrayList<Ajustes> data;
    private Context context;

    public AjustesAdapter(ArrayList<Ajustes> data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public AjustesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ajuste, parent,false);
        AjustesViewHolder holder = new AjustesViewHolder(vista);
        return holder;
    }
    public AjustesViewHolder onCreateViewHolder2(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ajuste_activable, parent,false);
        AjustesViewHolder holder = new AjustesViewHolder(vista);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull AjustesViewHolder holder, int position) {
        String nombre = data.get(position).getNombre();
        int drawable = data.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);
        holder.btnOpcion.setText(nombre);
        //holder.btnOpcion.setCompoundDrawablesWithIntrinsicBounds(img,null,null,null);
        holder.imageView.setImageDrawable(img);
    }

    public void onBindViewHolder2(@NonNull AjustesViewHolder holder, int position) {
        String nombre = data.get(position).getNombre();
        int drawable = data.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);
        holder.btnOpcion.setText(nombre);
        //holder.btnOpcion.setCompoundDrawablesWithIntrinsicBounds(img,null,null,null);
        holder.imageView.setImageDrawable(img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class AjustesViewHolder extends RecyclerView.ViewHolder{
        private TextView btnOpcion;
        private ImageView imageView;
        public AjustesViewHolder(@NonNull View itemView) {
            super(itemView);
            btnOpcion = (TextView) itemView.findViewById(R.id.btn_ajuste);
            imageView = (ImageView) itemView.findViewById(R.id.imageAjuste);
        }
    }
}
