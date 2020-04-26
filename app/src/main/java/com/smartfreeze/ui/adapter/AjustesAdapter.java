package com.smartfreeze.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.R;
import com.smartfreeze.domain.Ajustes;

import java.util.ArrayList;

public class AjustesAdapter extends RecyclerView.Adapter<AjustesAdapter.AjustesViewHolder> {

    private ArrayList<Ajustes> data;
    private Context context;
    private int posicion;

    public AjustesAdapter(ArrayList<Ajustes> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return data.size();
    }

    @NonNull
    @Override
    public AjustesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.opcion_ajustes, parent,false);
        AjustesViewHolder holder = new AjustesViewHolder(vista);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull AjustesViewHolder holder, int position) {
        String nombre = data.get(position).getNombre();
        int drawable = data.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);
        holder.btnOpcion.setText(nombre);
        holder.imageView.setImageDrawable(img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class AjustesViewHolder extends RecyclerView.ViewHolder{
        private TextView btnOpcion;
        private ImageView imageView;
        private Switch switchView;
        public AjustesViewHolder(@NonNull View itemView) {
            super(itemView);
            btnOpcion = (TextView) itemView.findViewById(R.id.btn_ajuste);
            imageView = (ImageView) itemView.findViewById(R.id.imageAjuste);
        }
        public AjustesViewHolder(@NonNull View itemView, Switch switchView) {
            super(itemView);
            btnOpcion = (TextView) itemView.findViewById(R.id.btn_ajuste);
            imageView = (ImageView) itemView.findViewById(R.id.imageAjuste);
            switchView = this.switchView.findViewById(R.id.switch1);
        }
    }

    public void setPosicion(int posicion){
        this.posicion = posicion;
    }
    public int getPosicion(){
        return this.posicion;
    }
}
