package com.servicios.moto.controller;

import com.servicios.moto.entities.Moto;
import com.servicios.moto.services.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos() {
        List<Moto> motos = motoService.getAll();
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id) {
        Moto coche = motoService.getMotoById(id);
        if (coche == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(coche);
    }

    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto) {
        return ResponseEntity.ok(motoService.save(moto));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> obtenerMotosUsuario(@PathVariable("usuarioId") int usuarioId) {
        List<Moto> motos = motoService.byUsuarioId(usuarioId);
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

}
