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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v1/Usuarios")
@Tag(name="Usuarios", description="Operaciones relacionadas con los Usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    @Operation(summary="Lista de todos los Usuarios", description="Operaciones relacionadas con los Usuarios")
    public List<Usuario> ListaUsuarios(){
        return usuarioServicio.getUsuarios();
    }

    @PostMapping
    @Operation(summary="Agregar un Usuario", description="Operacion para agregar un Usuario")
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.saveUsuarios(usuario); 

    }

    @GetMapping("/{id}")
    @Operation(summary="Buscar un Usuario", description="Operaciones para buscar un Usuario")
    public Usuario buscUsuario(@PathVariable int id){
        return usuarioServicio.getUsuarioId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary="Actualizar los Usuarios", description="Operacion para actualizar los Usuarios")
    public Usuario actualizarUsuario(@PathVariable long id,@RequestBody Usuario usuario) {
        return usuarioServicio.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Eliminar los Usuarios", description="Operacion para eliminar los Usuarios")
    public String eliminarUsuario(@PathVariable int id){
        return usuarioServicio.daleteUsuario(id);
    }



}
