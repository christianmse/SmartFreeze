package com.smartfreeze.ui;

import com.smartfreeze.domain.Producto;

import java.util.ArrayList;
import java.util.List;

public interface IStoreListener {
    void clickProducto(Producto producto);
    void categoriasSelected(List<String> selectedItems);
    void categoriasSelectedTodas(ArrayList<Producto> datos);

    void cambiarColor(boolean b);
}
