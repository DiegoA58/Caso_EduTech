package com.example.edutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edutech.modelo.Usuario;
import com.example.edutech.servicio.UsuarioServicio;


@RestController
@RequestMapping("/api/v1/Usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public List<Usuario> ListaUsuarios(){
        return usuarioServicio.getUsuarios();
    }

    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.saveUsuarios(usuario); 

    }

    @GetMapping("/{id}")
    public Usuario buscUsuario(@PathVariable int id){
        return usuarioServicio.getUsuarioId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable long id,@RequestBody Usuario usuario) {
        return usuarioServicio.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable int id){
        return usuarioServicio.daleteUsuario(id);
    }



}
