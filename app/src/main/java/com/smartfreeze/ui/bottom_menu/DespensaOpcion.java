package com.smartfreeze.ui.bottom_menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smartfreeze.IDespensaListener;
import com.smartfreeze.R;
import com.smartfreeze.domain.Producto;
import com.smartfreeze.ui.DialogCajon;
import com.smartfreeze.ui.IDialogCajon;
import com.smartfreeze.ui.IDialogDespensa;
import com.smartfreeze.ui.adapter.DespensaAdapter;
import com.smartfreeze.util.DialogDespensa;
import com.smartfreeze.util.Stock;

import java.util.ArrayList;

public class DespensaOpcion extends Fragment implements IDespensaListener, IDialogDespensa, IDialogCajon {
    RecyclerView recyclerView;
    DespensaAdapter adapter;
    private ArrayList<Producto> datosTienda = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    Spinner spinner;
    Toolbar toolbar;





    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.opcion_despensa,container,false);
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_tienda);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DespensaAdapter(getContext(), Stock.getInstance().getDatos(),  this);
        recyclerView.setAdapter(adapter);
        toolbar = view.findViewById(R.id.toolbar_store);
        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adaptadores = new ArrayAdapter<String>(getContext(), R.layout.spinner, getResources().getStringArray(R.array.spinner_opciones));
        spinner.setAdapter(adaptadores);

    }



    @Override
    public void accion2(int cajonAntiguo, Producto producto) {
        DialogFragment dialogo = new DialogDespensa(this, cajonAntiguo, producto);
        dialogo.show(getChildFragmentManager(), "dialogo opciones");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.depensa_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_sort: showSortDialog();
            return true;
            case  R.id.ordenar_caducidad: Toast.makeText(getContext(), "por Caducidad", Toast.LENGTH_LONG).show();
                return true;
            case R.id.ordenar_cajon: Toast.makeText(getContext(), "Cajon", Toast.LENGTH_LONG).show();
                return true;
            case R.id.ordenar_cantidad: Toast.makeText(getContext(), "Cantidad", Toast.LENGTH_LONG).show();
                return true;
            default: return super.onOptionsItemSelected(item);

        }
    }

    private void showSortDialog() {
        String[] opciones = {"fecha de caducidad, cantidad"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Ordenar por:");
        builder.setIcon(R.drawable.ic_sort_white);
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0){//fecha caducidad
                    Toast.makeText(getContext(),"caducidad", Toast.LENGTH_SHORT).show();
                } else if(which ==1){ //cantidad
                    Toast.makeText(getContext(),"cantidad", Toast.LENGTH_SHORT).show();

                }
            }
        });
        builder.create().show();
    }


    @Override
    public void cambiarCajon(int cajonAntiguo, Producto producto) {
        DialogFragment dialogo = new DialogCajon(this, cajonAntiguo, producto);
        dialogo.show(getChildFragmentManager(), "dialogo cajones");
    }

    @Override
    public void cambiarCajonSeleccionado(int i, int cajonAntiguo, Producto producto) {
        ArrayList<Producto> productosDelCajon = new ArrayList<>();
        switch (i){
            case 0: //Cambiar de cajon al 1
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;

            case 1: //Cambiar de cajon al 2
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;

            case 2: //Cambiar de cajon al 3
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;
            case 3: //Cambiar de cajon al 4
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;
            case 4: //Cambiar de cajon al 5
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;
            case 5: //Cambiar de cajon al 6
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;
            case 6: //Cambiar de cajon al 7
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;
            case 7: //Cambiar de cajon al estante 8
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;

            case 8: //Cambiar de cajon al estante 9
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;

            case 9: //Cambiar de cajon al estante 10
                producto.setCajon(i);
                Stock.getInstance().getDatosPorCajon(cajonAntiguo).remove(producto);
                Stock.getInstance().getDatosPorCajon(i).add(producto);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Cambiando de cajon al "+(i+1)+" desde cajon"+(cajonAntiguo+1), Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
