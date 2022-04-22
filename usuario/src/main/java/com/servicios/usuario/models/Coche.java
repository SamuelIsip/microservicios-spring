package com.servicios.usuario.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Coche {

    private String marca;
    private String modelo;
    private int usuarioId;

}
