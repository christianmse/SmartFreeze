package com.smartfreeze.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smartfreeze.R;
import com.smartfreeze.domain.ItemStore;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    private final ArrayList<ItemStore> mArrayList;
    private Context mContext;

    public StoreAdapter(ArrayList<ItemStore> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(mContext)
                .load(mArrayList.get(position).getAppImage())
                .into(holder.iv_app_item);

        holder.tv_app_item_number.setText(String.valueOf(position + 1));
        holder.tv_app_name.setText(mArrayList.get(position).getAppName());
        holder.tv_app_developer.setText(mArrayList.get(position).getAppDeveloper());

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv_app_item;
        private final TextView tv_app_item_number;
        private final TextView tv_app_name;
        private final TextView tv_app_developer;
        private ImageButton add;
        private ImageButton remove;
        private TextView unidades;



        MyViewHolder(View view) {
            super(view);

            iv_app_item = view.findViewById(R.id.iv_app_item);
            tv_app_item_number = view.findViewById(R.id.tv_app_item_number);
            tv_app_name = view.findViewById(R.id.tv_app_name);
            tv_app_developer = view.findViewById(R.id.tv_app_developer);
            add =view.findViewById(R.id.add);
            remove = view.findViewById(R.id.remove);
            unidades = view.findViewById(R.id.unidades);

        }
    }
}
