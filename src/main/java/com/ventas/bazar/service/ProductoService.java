package com.ventas.bazar.service;

import com.ventas.bazar.model.Producto;
import com.ventas.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerProductosFaltaStock() {
        List<Producto> productos = productoRepository.findAll();
        List<Producto> productosFaltaStock = new ArrayList<>();
        for (Producto pro : productos){
            if(pro.getCantidad_disponible() < 5){
                productosFaltaStock.add(pro);
            }
        }
        return productosFaltaStock;
    }


    @Override
    public void guardarProducto(Producto pro) {
        productoRepository.save(pro);
    }

    @Override
    public void editarProducto(Producto pro) {
        this.guardarProducto(pro);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarProducto(Long id) {
        Producto pro = productoRepository.findById(id).orElse(null);
        return pro;
    }
}
