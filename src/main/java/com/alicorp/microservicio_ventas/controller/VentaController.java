package com.alicorp.microservicio_ventas.controller;


import com.alicorp.microservicio_ventas.model.Venta;
import com.alicorp.microservicio_ventas.service.impl.VentaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/registrar")
    public ResponseEntity<Venta> registrarVenta(@RequestBody Venta venta) {
        try {
            Venta ventaGuardada = ventaService.registrarVenta(venta);
            return ResponseEntity.ok(ventaGuardada);
        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
