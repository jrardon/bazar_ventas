package com.ventas.bazar.service;

import com.ventas.bazar.dto.MayorVentaDTO;
import com.ventas.bazar.dto.VentaResumenFechaDTO;
import com.ventas.bazar.model.Producto;
import com.ventas.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService{
    public void guardarVenta(Venta ven);
    public void actualizarVenta(Venta ven);
    public void eliminarVenta(Long id);
    public List<Venta> listarVentas();
    public Venta buscarVenta(Long id);

    public List<Producto> obtenerProductosDeVenta(Long codigo_venta);
    public List<Venta> obtenerSumaMontoCantidadTotalVentas(LocalDate fecha_venta);

    public VentaResumenFechaDTO obtenerSumaMontoTotalVentas(LocalDate fecha_venta);

    public MayorVentaDTO obtenerMayorVenta();
}
