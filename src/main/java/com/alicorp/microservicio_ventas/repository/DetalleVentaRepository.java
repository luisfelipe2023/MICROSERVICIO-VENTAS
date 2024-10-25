package com.alicorp.microservicio_ventas.repository;

import com.alicorp.microservicio_ventas.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta , Long> {
}
