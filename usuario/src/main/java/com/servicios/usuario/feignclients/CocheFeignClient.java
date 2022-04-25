package com.servicios.usuario.feignclients;

import com.servicios.usuario.models.Coche;
import com.servicios.usuario.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "coche")
@RequestMapping("/coche")
public interface CocheFeignClient {

    @PostMapping()
    public Coche save(@RequestBody Coche coche);

    @GetMapping("/usuario/{usuarioId}")
    public List<Coche> getCoches(@PathVariable("usuarioId") int usuarioId);

}
