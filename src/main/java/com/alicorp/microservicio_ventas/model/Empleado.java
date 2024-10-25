package com.alicorp.microservicio_ventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cargo;
    private String email;
    private String telefono;
    public Empleado(){

    }

}
