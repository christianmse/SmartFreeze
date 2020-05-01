package com.smartfreeze.ui;

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

public class DialogCajon extends DialogFragment {
IDialogCajon listener;
int cajonAntiguo;
Producto producto;
public DialogCajon(IDialogCajon listener, int cajonAntiguo, Producto producto){
    this.listener = listener;
    this.cajonAntiguo = cajonAntiguo;
    this.producto = producto;
}

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        setShowsDialog(true);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Seleccione a que cajon")
                .setItems(R.array.cajones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.cambiarCajonSeleccionado(which, cajonAntiguo, producto);
                        dismiss();

                    }

                });
        return builder.create();
    }
}
