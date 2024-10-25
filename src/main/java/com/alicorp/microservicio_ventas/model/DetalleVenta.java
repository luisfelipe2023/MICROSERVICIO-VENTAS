package com.alicorp.microservicio_ventas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    @JsonIgnore
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)

    private Producto producto;

    private Integer cantidad;
    private BigDecimal precioUnitario;
}
