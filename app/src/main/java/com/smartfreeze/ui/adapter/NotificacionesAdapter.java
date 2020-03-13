package com.smartfreeze.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.R;
import com.smartfreeze.domain.Notificacion;

import java.util.ArrayList;

public class NotificacionesAdapter extends RecyclerView.Adapter<NotificacionesAdapter.NotificacionesHolder> {

    private ArrayList<Notificacion> notificacionesList;
    Context context;

    public NotificacionesAdapter(ArrayList<Notificacion> listNotificaciones, Context context){
        this.notificacionesList = listNotificaciones;
        this.context = context;
    }
    @NonNull
    @Override
    public NotificacionesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notificacion, parent, false);
        NotificacionesHolder holder = new NotificacionesHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificacionesHolder holder, int position) {
        Drawable img = null;
        String txtNotificacion = notificacionesList.get(position).getTitulo();
        String colorPrioridad = notificacionesList.get(position).getPrioridad();

        holder.txtNotificacion.setText(txtNotificacion);
        switch (colorPrioridad){
            case "rojo": img = context.getResources().getDrawable(R.color.design_default_color_error);
            break;
            case "verde": img = context.getResources().getDrawable(R.color.colorPrimary);
            break;
            case "amarillo": img = context.getResources().getDrawable(R.color.colorAccent);
            break;
        }

        holder.colorPrioridad.setBackground(img);


    }

    @Override
    public int getItemCount() {
        return notificacionesList.size();
    }



    public static class NotificacionesHolder extends RecyclerView.ViewHolder{

        private TextView txtNotificacion;
        View colorPrioridad;
        public NotificacionesHolder(@NonNull View itemView) {
            super(itemView);
            txtNotificacion = itemView.findViewById(R.id.txt_notificacion);
            colorPrioridad = itemView.findViewById(R.id.color_prioridad);
        }
    }
}
