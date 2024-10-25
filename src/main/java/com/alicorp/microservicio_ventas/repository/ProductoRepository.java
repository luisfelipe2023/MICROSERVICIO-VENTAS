package com.alicorp.microservicio_ventas.repository;

import com.alicorp.microservicio_ventas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto , Long> {
}
