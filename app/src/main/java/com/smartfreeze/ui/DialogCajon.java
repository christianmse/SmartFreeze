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

public class DialogCajon extends DialogFragment {

public DialogCajon(){}

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        setShowsDialog(true);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Seleccione a que cajon")
                .setItems(R.array.cajones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which){
                            case 0: //Cambiar de cajon al 1
                                Toast.makeText(getContext(),"Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;

                            case 1: //Cambiar de cajon al 2
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;

                                case 2: //Cambiar de cajon al 3
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;
                            case 3: //Cambiar de cajon al 4
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;
                            case 4: //Cambiar de cajon al 5
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;
                            case 5: //Cambiar de cajon al 6
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;
                            case 6: //Cambiar de cajon al 7
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;
                                case 7: //Cambiar de cajon al estante 8
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;

                            case 8: //Cambiar de cajon al estante 9
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;

                            case 9: //Cambiar de cajon al estante 10
                                Toast.makeText(getContext(), "Cambiando de cajon al"+(which+1), Toast.LENGTH_SHORT).show();
                                dismiss();
                                break;
                        }

                    }

                });
        return builder.create();
    }
}
