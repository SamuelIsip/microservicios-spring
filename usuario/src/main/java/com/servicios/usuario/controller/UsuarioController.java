package com.servicios.usuario.controller;

import com.servicios.usuario.entities.Usuario;
import com.servicios.usuario.models.Coche;
import com.servicios.usuario.models.Moto;
import com.servicios.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.getAll();
        if (usuarios.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @GetMapping("/coches/{usuarioId}")
    public ResponseEntity<List<Coche>> listarCoches(@PathVariable("usuarioId") int usuarioId) {
        Usuario usuario = usuarioService.getUsuarioById(usuarioId);

        if (usuario == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuarioService.getCoches(usuarioId));
    }

    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int usuarioId) {
        Usuario usuario = usuarioService.getUsuarioById(usuarioId);

        if (usuario == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuarioService.getMotos(usuarioId));
    }

    @PostMapping("/coche/{usuarioId}")
    public ResponseEntity<Coche> guardarCoche(@PathVariable("usuarioId") int usuarioId, @RequestBody Coche coche){
        return ResponseEntity.ok(usuarioService.saveCoche(usuarioId,coche));
    }

    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") int usuarioId, @RequestBody Moto moto){
        return ResponseEntity.ok(usuarioService.saveMoto(usuarioId,moto));
    }

    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String,Object>> listarTodosLosVehiculos(@PathVariable("usuarioId") int usuarioId){
        return ResponseEntity.ok(usuarioService.getUsuarioAndVehiculos(usuarioId));
    }

}
