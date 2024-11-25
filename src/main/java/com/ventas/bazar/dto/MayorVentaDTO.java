package com.ventas.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MayorVentaDTO {
    private Long codigo_venta;
    private Double total;
    private int cantidad_productos;
    private String nombre;
    private String apellido;

    public MayorVentaDTO() {
    }

    public MayorVentaDTO(Long codigo_venta, Double total, int cantidad_productos, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_productos = cantidad_productos;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
