package com.alicorp.microservicio_ventas.repository;

import com.alicorp.microservicio_ventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta , Long> {
}
