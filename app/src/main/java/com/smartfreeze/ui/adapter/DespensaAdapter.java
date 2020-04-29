package com.smartfreeze.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.IDespensaListener;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;

public class DespensaAdapter extends RecyclerView.Adapter<DespensaAdapter.Holder> {
    private HashMap<Integer, ArrayList<Producto>> listaProductos;
    private Context context;
    private RecyclerView.RecycledViewPool viewPoll;
    IDespensaListener listener;

    public DespensaAdapter(Context context, HashMap<Integer, ArrayList<Producto>> listaProductos, IDespensaListener listener ){
        this.context = context;
        this.listaProductos = listaProductos;
        this.viewPoll = new RecyclerView.RecycledViewPool();
        this.listener = listener;
    }

    @NonNull
    @Override
    public DespensaAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_despensa,parent,false);
        Holder holder = new Holder(vista);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DespensaAdapter.Holder holder, int position) {
        GridLayoutManager layoutManager;
        layoutManager = new GridLayoutManager(holder.rvSubItem.getContext(), 3);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        layoutManager.setInitialPrefetchItemCount(listaProductos.size());

        //subitem adapter
        ArrayList<Producto> aux = listaProductos.get(position);
        SubItemAdapter adapter = new SubItemAdapter(aux, context, listener);

        holder.rvSubItem.setLayoutManager(layoutManager);
        holder.rvSubItem.setAdapter(adapter);
        holder.rvSubItem.setRecycledViewPool(viewPoll);

        //Reemplazar por cajon
        String cajon = String.valueOf(position);
        holder.cajon.setText(cajon);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        RecyclerView rvSubItem;
        TextView cajon;
        public Holder(@NonNull View itemView) {
            super(itemView);
            rvSubItem = itemView.findViewById(R.id.recycler_subItemProducto);
            cajon = itemView.findViewById(R.id.cajon);
        }
    }
}