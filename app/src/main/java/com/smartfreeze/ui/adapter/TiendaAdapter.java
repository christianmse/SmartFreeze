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
import com.smartfreeze.domain.Producto;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TiendaAdapter extends RecyclerView.Adapter<TiendaAdapter.TiendaViewHolder> {
    private ArrayList<Producto> listaProductos;
    private Context context;


    public TiendaAdapter(ArrayList<Producto> listaProductos, Context context) {
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public TiendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,parent,false);
        TiendaViewHolder holder = new TiendaViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TiendaViewHolder holder, int position) {
        String titulo = listaProductos.get(position).getNombre();
        String subtitulo = listaProductos.get(position).getCategorioa();
        String precio = listaProductos.get(position).getPrecio();
        int drawable = listaProductos.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);

        holder.imagen.setImageDrawable(img);
        holder.titulo.setText(titulo);
        holder.subtitulo.setText(subtitulo);
        holder.precio.setText(precio);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }


    public static class TiendaViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo;
        private TextView subtitulo;
        private TextView precio;
        private ImageView imagen;

        public TiendaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.txt_titulo);
            subtitulo = itemView.findViewById(R.id.txt_subtitulo);
            precio = itemView.findViewById(R.id.txt_precio);
            imagen = itemView.findViewById(R.id.icono_producto);

        }
    }
}
