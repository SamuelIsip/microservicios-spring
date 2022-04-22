package com.servicios.moto.repository;

import com.servicios.moto.entities.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {


    List<Moto> findByUsuarioId(int usuarioId);

}
