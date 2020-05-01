package com.smartfreeze.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.IDialogDespensa;

public class DialogDespensa extends DialogFragment {
    IDialogDespensa listener;
    int cajonAntiguo;
    Producto producto;
    public DialogDespensa(IDialogDespensa listener, int cajonAntiguo, Producto producto){
        this.listener = listener;
        this.cajonAntiguo = cajonAntiguo;
        this.producto = producto;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        setShowsDialog(true);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("¿Qué quieres hacer?")
                .setItems(R.array.opciones_despensa, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getActivity().getResources().getStringArray(R.array.opciones_despensa);

                        switch (which){
                            case 0: //Cambiar de cajon
                                listener.cambiarCajon(cajonAntiguo, producto);
                                dismiss();
                                break;

                            case 1: //Descongelar
                                Toast.makeText(getContext(), "Producto sacado", Toast.LENGTH_SHORT).show();
                                listener.productoSacado(cajonAntiguo, producto);
                                dismiss();
                                break;
                        }

                    }

                });
        return builder.create();
    }
}
