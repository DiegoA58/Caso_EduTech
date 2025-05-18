package com.example.edutech.controller;
import com.example.edutech.modelo.Usuario;
import com.example.edutech.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/Usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public List<Usuario> ListaUsuarios(){
        return usuarioServicio.getRol();
    }

    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.saveUsuario(usuario); 

    }

    @GetMapping("/{id}")
    public Usuario buscUsuario(@PathVariable long id){
        return usuarioServicio.getId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable long idU,@RequestBody Usuario usuario) {
        return usuarioServicio.updateLibro(usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathaVariable log idU){
        retun UsuarioServicio.deleteUsuario(idU);
    }



}
