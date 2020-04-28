package com.smartfreeze.ui.adapter;

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
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.IDespensaListener;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class DespensaAdapter extends RecyclerView.Adapter<DespensaAdapter.TiendaViewHolder> {
    private ArrayList<Producto> listaProductos;
    private Context context;
    IDespensaListener listener;


    public DespensaAdapter(ArrayList<Producto> listaProductos, Context context, IDespensaListener listener) {
        this.context = context;
        this.listener = listener;
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
        String descripcion = listaProductos.get(position).getDescripcion();
        int drawable = listaProductos.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);

        holder.imagen.setImageDrawable(img);
        holder.titulo.setText(titulo);
        holder.subtitulo.setText(subtitulo);
        holder.expanded_text.setText(descripcion);

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
        private TextView expanded_text;
        private ImageView imagen;
        private Button accion1, accion2;
        private ImageButton btn_expand;

        public TiendaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.primary_text);
            subtitulo = itemView.findViewById(R.id.sub_text);
            expanded_text = itemView.findViewById(R.id.supporting_text);
            imagen = itemView.findViewById(R.id.media_image);
            accion1 = itemView.findViewById(R.id.action_button_1);
            accion2= itemView.findViewById(R.id.action_button_2);
            btn_expand = itemView.findViewById(R.id.expand_button);

            btn_expand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (expanded_text.getVisibility() == View.VISIBLE) {
                        btn_expand.setImageResource(R.drawable.ic_expand_less_black_36dp);
                        expanded_text.setVisibility(View.GONE);
                    } else {
                        btn_expand.setImageResource(R.drawable.ic_expand_more_black_36dp);
                        expanded_text.setVisibility(View.VISIBLE);
                    }
                }
            });

        }
    }
}
