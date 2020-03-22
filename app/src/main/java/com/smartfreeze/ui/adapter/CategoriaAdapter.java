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
import com.smartfreeze.domain.Categoria;

import java.util.ArrayList;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {


    private Context context;
    private ArrayList<Categoria> data = new ArrayList<>();

    public CategoriaAdapter(Context ctx, ArrayList<Categoria> data){
        this.context = ctx;
        this.data=data;
    }
    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent,false);
        CategoriaViewHolder holder = new CategoriaViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        String txt = data.get(position).getNombre();
        int drawable = data.get(position).getDrawable();
        Drawable img = context.getResources().getDrawable(drawable);
        holder.txt.setText(txt);
        //holder.btnOpcion.setCompoundDrawablesWithIntrinsicBounds(img,null,null,null);
        holder.img.setImageDrawable(img);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        ImageView img;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt_categoria);
            img = itemView.findViewById(R.id.img_categoria);
        }
    }
}
