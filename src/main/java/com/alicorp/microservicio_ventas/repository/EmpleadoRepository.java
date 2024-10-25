package com.alicorp.microservicio_ventas.repository;

import com.alicorp.microservicio_ventas.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado , Long> {
}
