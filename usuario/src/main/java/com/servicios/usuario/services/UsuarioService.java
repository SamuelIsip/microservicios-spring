package com.servicios.usuario.services;

import com.servicios.usuario.entities.Usuario;
import com.servicios.usuario.feignclients.CocheFeignClient;
import com.servicios.usuario.feignclients.MotoFeignClient;
import com.servicios.usuario.models.Coche;
import com.servicios.usuario.models.Moto;
import com.servicios.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CocheFeignClient cocheFeignClient;

    @Autowired
    private MotoFeignClient motoFeignClient;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Coche> getCoches(int usuarioId) {
        return restTemplate.getForObject("http://localhost:8082/coche/usuario/" + usuarioId, List.class);
    }

    public List<Moto> getMotos(int usuarioId) {
        return restTemplate.getForObject("http://localhost:8083/moto/usuario/" + usuarioId, List.class);
    }

    public Coche saveCoche(int usuarioId, Coche coche) {
        coche.setUsuarioId(usuarioId);
        return cocheFeignClient.save(coche);
    }

    public Moto saveMoto(int usuarioId, Moto moto) {
        moto.setUsuarioId(usuarioId);
        return motoFeignClient.save(moto);
    }

    public Map<String, Object> getUsuarioAndVehiculos(int usuarioId){
        Map<String,Object> resultado = new HashMap<>();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (usuario == null){
            resultado.put("Mensaje", "El usuario no existe");
            return resultado;
        }

        resultado.put("Usuario", usuario);

        List<Coche> coches = cocheFeignClient.getCoches(usuarioId);

        if (coches == null){
            resultado.put("Coches", "El usuario no tiene coches");
        }else{
            resultado.put("Coches", coches);
        }

        List<Moto> motos = motoFeignClient.getMotos(usuarioId);

        if (motos == null){
            resultado.put("Motos", "El usuario no tiene motos");
        }else{
            resultado.put("Motos", motos);
        }

        return resultado;
    }

}
