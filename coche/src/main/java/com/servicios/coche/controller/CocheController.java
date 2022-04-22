package com.servicios.coche.controller;

import com.servicios.coche.entities.Coche;
import com.servicios.coche.services.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coche")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @GetMapping
    public ResponseEntity<List<Coche>> listarCoches() {
        List<Coche> coches = cocheService.getAll();
        if (coches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(coches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> obtenerCoche(@PathVariable("id") int id) {
        Coche coche = cocheService.getCocheById(id);
        if (coche == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(coche);
    }

    @PostMapping
    public ResponseEntity<Coche> guardarCoche(@RequestBody Coche coche) {
        return ResponseEntity.ok(cocheService.save(coche));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Coche>> obtenerCochesUsuario(@PathVariable("usuarioId") int usuarioId) {
        List<Coche> coches = cocheService.byUsuarioId(usuarioId);
        if (coches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(coches);
    }

}
