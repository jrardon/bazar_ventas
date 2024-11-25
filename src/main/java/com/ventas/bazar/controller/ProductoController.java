package com.ventas.bazar.controller;

import com.ventas.bazar.model.Producto;
import com.ventas.bazar.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoServ;

    @PostMapping ("/productos/crear")
    public void registrarProducto(@RequestBody Producto pro){
        productoServ.guardarProducto(pro);
    }

    @DeleteMapping ("/productos/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable Long codigo_producto){
        productoServ.eliminarProducto(codigo_producto);
    }

    @PutMapping ("/productos/editar/{codigo_producto}")
    public Producto editarProducto(@RequestBody Producto pro){
        productoServ.editarProducto(pro);
        return productoServ.buscarProducto(pro.getCodigo_producto());
    }

    @GetMapping ("/productos")
    public List<Producto> listarProductos(){
        return productoServ.listarProductos();
    }

    @GetMapping ("/productos/{codigo_producto}")
    public Producto buscarProducto(@PathVariable Long codigo_producto){
        return productoServ.buscarProducto(codigo_producto);
    }

    @GetMapping ("/productos/falta_stock")
    public List<Producto> obtenerProductosFaltaStock(){
        return productoServ.obtenerProductosFaltaStock();
    }

}
