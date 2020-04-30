package com.smartfreeze.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.IStoreListener;

import java.util.ArrayList;
import java.util.Collection;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.Holder> implements Filterable {
    private ArrayList<Producto> listaProductos;
    private ArrayList<Producto> listaProductosAll;
    SparseBooleanArray selected_items = new SparseBooleanArray();
    SparseIntArray selected_items_cantidad = new SparseIntArray();
    int currentSelected = -1;

    IStoreListener listener;
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
        protected void publishResults(CharSequence constraint, FilterResults results ) {
            listaProductos.clear();
            listaProductos.addAll((Collection<? extends Producto>) results.values);
            notifyDataSetChanged();
        }
    };


    public StoreAdapter(ArrayList<Producto> listaProductos, Context context, IStoreListener listener) {
        this.context = context;
        this.listaProductos = listaProductos;
        this.listaProductosAll = new ArrayList<>(listaProductos);
        this.listener = listener;
    }

    public void setData(ArrayList<Producto> listaProductos){
        listaProductosAll.clear();
        this.listaProductosAll = listaProductos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store,parent,false);
        Holder holder = new Holder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        String titulo = listaProductos.get(position).getNombre();
        String categoria = listaProductos.get(position).getCategorioa();
        String precio = listaProductos.get(position).getPrecio();
        int drawable = listaProductos.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);

        holder.imagen.setImageDrawable(img);
        holder.titulo.setText(titulo);
        holder.categoria.setText(categoria);
        holder.precio.setText(precio);

        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickProducto(listaProductos.get(position));
            }
        });

        holder.anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer contadorMasUno =Integer.parseInt(holder.contador.getText().toString()) +1;
                holder.contador.setText(contadorMasUno.toString());
                holder.agregado.setVisibility(View.VISIBLE);
                selected_items.put(position,true);
                selected_items_cantidad.put(position, contadorMasUno);

                pintarCarrito(selected_items.size());

            }
        });

        holder.quitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int act = Integer.parseInt(holder.contador.getText().toString());
                if(act !=0){
                    Integer contadorMenosUno =Integer.parseInt(holder.contador.getText().toString()) -1;
                    holder.contador.setText(contadorMenosUno.toString());
                    if(contadorMenosUno == 0){
                        holder.agregado.setVisibility(View.GONE);
                        if(selected_items.get(position,false))
                        selected_items.delete(position);
                        selected_items_cantidad.put(position, contadorMenosUno);

                        pintarCarrito(selected_items.size());

                    }


                } else{
                    holder.agregado.setVisibility(View.GONE);
                    if(selected_items.get(position,false)){
                        selected_items.delete(position);
                        selected_items_cantidad.put(position, 0);

                        pintarCarrito(selected_items.size());

                    }



                }
            }
        });



    }

    private void pintarCarrito(int size) {
        if(selected_items.size() > 0){
            listener.cambiarColor(true);
        } else {
            listener.cambiarColor(false);
        }
    }


    public ArrayList<Producto> getSelectedItems(){
        ArrayList<Producto> aux = new ArrayList<>();

       for(int i=0; i<listaProductosAll.size(); i++){
           if(selected_items.get(i,false)){
               int cantidad = selected_items_cantidad.get(i,0);
               Producto producto = listaProductos.get(i);
               producto.setCantidad(cantidad);
               aux.add(producto);
           }
       }
       return aux;
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
        private TextView categoria;
        private TextView precio;
        private ImageView imagen;
        ImageView anadir, quitar;
        TextView contador;
        View agregado;


        public Holder(@NonNull View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.titleText);
            categoria = itemView.findViewById(R.id.productCategoria);
            precio = itemView.findViewById(R.id.price);
            imagen = itemView.findViewById(R.id.image);

            anadir = itemView.findViewById(R.id.btn_add);
            quitar = itemView.findViewById(R.id.btn_quitar);
            contador= itemView.findViewById(R.id.contador);
            agregado= itemView.findViewById(R.id.agregado);


        }
    }
}