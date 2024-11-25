package com.ventas.bazar.controller;


import com.ventas.bazar.dto.MayorVentaDTO;
import com.ventas.bazar.dto.VentaResumenFechaDTO;
import com.ventas.bazar.model.Producto;
import com.ventas.bazar.model.Venta;
import com.ventas.bazar.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private VentaService ventaServ;

    @PostMapping ("/ventas/crear")
    public String crearVentas(@RequestBody Venta ven){
        ventaServ.guardarVenta(ven);
        return "Venta creada";
    }

    @GetMapping ("/ventas")
    public List<Venta> obtenerVentas(){
        return ventaServ.listarVentas();
    }

    @GetMapping ("/ventas/{codigo_venta}")
    public Venta obtenerVentaPorCodigo(@PathVariable Long codigo_venta){
        return ventaServ.buscarVenta(codigo_venta);
    }

    @DeleteMapping ("/ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
        ventaServ.eliminarVenta(codigo_venta);
        return "Venta eliminada";
    }

    @PutMapping ("/ventas/editar/{codigo_venta}")
    public Venta editarVenta(@RequestBody Venta ven){
        ventaServ.actualizarVenta(ven);
        return ventaServ.buscarVenta(ven.getCodigo_venta());
    }

    @GetMapping ("/ventas/productos/{codigo_venta}")
    public List<Producto> obtenerProductosDeVenta(@PathVariable Long codigo_venta){
        return ventaServ.obtenerProductosDeVenta(codigo_venta);
    }

    @GetMapping ("/ventas/fecha/{fecha_venta}")
    public List<Venta> obtenerSumanMontoCantidadTotalVentas(@PathVariable LocalDate fecha_venta){
        return ventaServ.obtenerSumaMontoCantidadTotalVentas(fecha_venta);
    }

    @GetMapping ("/ventas/fechas/{fecha_venta}")
    public VentaResumenFechaDTO obtenerSumanMontoTotalVentas(@PathVariable LocalDate fecha_venta){
        return ventaServ.obtenerSumaMontoTotalVentas(fecha_venta);
    }

    @GetMapping ("/ventas/mayor_venta")
    public MayorVentaDTO obtenerMayorVenta(){
        return ventaServ.obtenerMayorVenta();
    }


}
