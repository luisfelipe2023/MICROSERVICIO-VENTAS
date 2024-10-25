package com.alicorp.microservicio_ventas.service.impl;

import com.alicorp.microservicio_ventas.model.*;
import com.alicorp.microservicio_ventas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class VentaService{
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Transactional
    public Venta registrarVenta(Venta venta) {
        Cliente cliente = clienteRepository.findById(venta.getCliente().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        Empleado empleado = empleadoRepository.findById(venta.getEmpleado().getId())
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));

        venta.setCliente(cliente);
        venta.setEmpleado(empleado);
        BigDecimal total = BigDecimal.ZERO;

        for (DetalleVenta detalle : venta.getDetalles()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            detalle.setProducto(producto);
            detalle.setVenta(venta);
            total = total.add(detalle.getPrecioUnitario().multiply(BigDecimal.valueOf(detalle.getCantidad())));
        }

        venta.setTotal(total);


        return ventaRepository.save(venta);
    }

}
