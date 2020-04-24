package com.smartfreeze.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.smartfreeze.R;
import com.smartfreeze.ui.IStoreListener;

import java.util.ArrayList;
import java.util.List;

public class MyDialog extends DialogFragment {

    List<String> selectedItems = new ArrayList<>();
    IStoreListener listener;

    public MyDialog(IStoreListener listener){
        this.listener = listener;
    }

   /* @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_store, container);
    }*/

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Selecciona las categorias");
        builder.setMultiChoiceItems(R.array.categories, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String[] items = getActivity().getResources().getStringArray(R.array.categories);

                if(isChecked){
                    selectedItems.add(items[which]);
                } else if (selectedItems.contains(items[which])){
                    selectedItems.remove(items[which]);
                }

            }
        });
        builder.setPositiveButton("Vale", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.categoriasSelected(selectedItems);
                dismiss();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedItems.clear();
                dismiss();
            }
        });
        return builder.create();
    }
}
