package com.servicios.coche.services;

import com.servicios.coche.entities.Coche;
import com.servicios.coche.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {

    @Autowired
    CocheRepository cocheRepository;

    public List<Coche> getAll() {
        return cocheRepository.findAll();
    }

    public Coche getCocheById(int id) {
        return cocheRepository.findById(id).orElse(null);
    }

    public Coche save(Coche coche) {
        return cocheRepository.save(coche);
    }

    public List<Coche> byUsuarioId(int usuarioId){
        return cocheRepository.findByUsuarioId(usuarioId);
    }

}
