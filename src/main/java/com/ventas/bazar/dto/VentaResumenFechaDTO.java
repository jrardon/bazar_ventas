package com.ventas.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaResumenFechaDTO {
    private int cantidadVentas;
    private Double totalVentas;

    public VentaResumenFechaDTO() {
    }

    public VentaResumenFechaDTO(int cantidadVentas, Double totalVentas) {
        this.cantidadVentas = cantidadVentas;
        this.totalVentas = totalVentas;
    }
}
