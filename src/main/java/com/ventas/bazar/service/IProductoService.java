package com.ventas.bazar.service;

import com.ventas.bazar.model.Producto;

import java.util.List;

public interface IProductoService {
    public void guardarProducto(Producto pro);
    public void editarProducto(Producto pro);
    public void eliminarProducto(Long id);
    public List<Producto> listarProductos();
    public Producto buscarProducto(Long id);

    public List<Producto> obtenerProductosFaltaStock();
}
