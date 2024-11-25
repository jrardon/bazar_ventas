package com.ventas.bazar.service;

import com.ventas.bazar.dto.MayorVentaDTO;
import com.ventas.bazar.dto.VentaResumenFechaDTO;
import com.ventas.bazar.model.Producto;
import com.ventas.bazar.model.Venta;
import com.ventas.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public void guardarVenta(Venta ven) {
        ventaRepository.save(ven);
    }

    @Override
    public void actualizarVenta(Venta ven) {
        this.guardarVenta(ven);
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta buscarVenta(Long id) {
        Venta ven = ventaRepository.findById(id).orElse(null);
        return ven;
    }

    @Override
    public List<Producto> obtenerProductosDeVenta(Long codigo_venta) {
        Venta venta = ventaRepository.findById(codigo_venta).orElse(null);
        return venta.getListaProductos();
    }

    @Override
    public List<Venta> obtenerSumaMontoCantidadTotalVentas(LocalDate fecha_venta) {
        List<Venta> ventas = ventaRepository.findAll();
        List<Venta> ventasFecha = new ArrayList<>();
        for (Venta ven : ventas) {
            if (ven.getFecha_venta().equals(fecha_venta)) {
                ventasFecha.add(ven);
            }
        }
        return ventasFecha;
    }

    @Override
    public VentaResumenFechaDTO obtenerSumaMontoTotalVentas(LocalDate fecha_venta) {
        List<Venta> ventas = ventaRepository.findAll();
        Double cantidadTotalVentas = 0.0;
        int cantidadVentas = 0;
        for (Venta ven : ventas) {
            if (ven.getFecha_venta().equals(fecha_venta)) {
                cantidadTotalVentas += ven.getTotal();
                cantidadVentas++;
            }
        }
        return new VentaResumenFechaDTO(cantidadVentas, cantidadTotalVentas);
    }

    @Override
    public MayorVentaDTO obtenerMayorVenta() {
        List<Venta> ventas = ventaRepository.findAll();
        if (ventas.isEmpty()) {
            return null;
        }
        Venta mayorVenta = ventas.get(0);
        for (Venta venta : ventas) {
            if (venta.getTotal() > mayorVenta.getTotal()) {
                mayorVenta = venta;
            }

        }
//      METODO PARA misma forma de obtener la mayor venta
//        Venta mayorVenta = Collections.max(ventas, Comparator.comparing(Venta::getTotal));

        return new MayorVentaDTO(
                mayorVenta.getCodigo_venta(),
                mayorVenta.getTotal(),
                mayorVenta.getListaProductos().size(),
                mayorVenta.getUnCliente().getNombre(),
                mayorVenta.getUnCliente().getApellido()
        );

    }
}