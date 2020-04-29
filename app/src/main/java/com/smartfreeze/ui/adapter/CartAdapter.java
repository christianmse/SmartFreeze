package com.smartfreeze.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CHolder> {

    private ArrayList<Producto> data;
    private Context context;
    Activity actividad;
    public static MutableLiveData cantidad = new MutableLiveData<>();

    public CartAdapter(ArrayList<Producto> data, Context context, Activity actividad){
        this.data = data;
        this.context = context;
        this.actividad = actividad;
    }

    @NonNull
    @Override
    public CHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrito, parent,false);
        CHolder holder = new CHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CHolder holder, int position) {
        String titulo = data.get(position).getNombre();
        final String precio = data.get(position).getPrecio();
        int drawable = data.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);
        int cantidad =  data.get(position).getCantidad();
        String cantidadText = String.valueOf(cantidad);
        String precioTotal = String.valueOf(cantidad * Integer.parseInt(precio));

        holder.precioObserver.setText(precioTotal);
        holder.cantidad.setText(cantidadText);
        //holder.btnOpcion.setCompoundDrawablesWithIntrinsicBounds(img,null,null,null);
        holder.imageView.setImageDrawable(img);
        holder.titulo.setText(titulo);
        holder.precio.setText(precio);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class CHolder extends RecyclerView.ViewHolder{
        private TextView precioObserver, precio, titulo, cantidad;
        private ImageView imageView;


        public CHolder(@NonNull View itemView) {
            super(itemView);
            precioObserver = (TextView) itemView.findViewById(R.id.totalPrice);
            precio = (TextView) itemView.findViewById(R.id.eachPrice);
            cantidad = itemView.findViewById(R.id.quantityEditText);
            titulo = (TextView) itemView.findViewById(R.id.titleText);
            imageView = (ImageView) itemView.findViewById(R.id.productImage);


        }
    }
}
