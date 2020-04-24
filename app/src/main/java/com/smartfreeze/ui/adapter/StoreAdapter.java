package com.smartfreeze.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;
import java.util.Collection;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.Holder> implements Filterable {
    private ArrayList<Producto> listaProductos;
    private ArrayList<Producto> listaProductosAll;
    private Context context;

    Filter filter = new Filter() {
        //run on background
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Producto> filteredList = new ArrayList<>();
            if(constraint.toString().isEmpty()){
                filteredList.addAll(listaProductosAll);
            } else{
                for (Producto producto : listaProductosAll){
                    if(producto.getNombre().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(producto);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }
        //run on ui thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listaProductos.clear();
            listaProductos.addAll((Collection<? extends Producto>) results.values);
            notifyDataSetChanged();
        }
    };


    public StoreAdapter(ArrayList<Producto> listaProductos, Context context) {
        this.context = context;
        this.listaProductos = listaProductos;
        this.listaProductosAll = new ArrayList<>(listaProductos);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store,parent,false);
        Holder holder = new Holder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String titulo = listaProductos.get(position).getNombre();
        String categoria = listaProductos.get(position).getCategorioa();
        String precio = listaProductos.get(position).getPrecio();
        String descripcion = listaProductos.get(position).getDescripcion();
        int drawable = listaProductos.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);

        holder.imagen.setImageDrawable(img);
        holder.titulo.setText(titulo);
        holder.categoria.setText(categoria);
        holder.precio.setText(precio);
        holder.descripcion.setText(descripcion);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }




    public static class Holder extends RecyclerView.ViewHolder{
        private TextView titulo;
        private TextView descripcion;
        private TextView categoria;
        private TextView precio;
        private ImageView imagen;


        public Holder(@NonNull View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titleText);
            descripcion = itemView.findViewById(R.id.productDescription);
            categoria = itemView.findViewById(R.id.productCategoria);
            precio = itemView.findViewById(R.id.price);
            imagen = itemView.findViewById(R.id.image);

        }
    }
}
