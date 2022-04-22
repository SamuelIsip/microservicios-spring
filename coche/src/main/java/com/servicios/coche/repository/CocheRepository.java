package com.servicios.coche.repository;

import com.servicios.coche.entities.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {

    List<Coche> findByUsuarioId(int usuarioId);

}
