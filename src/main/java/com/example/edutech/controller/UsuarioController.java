package com.example.edutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/Usuarios")
@Tag(name="Usuarios", description="Operaciones relacionadas con los Usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    @Operation(summary="Lista de todos los Usuarios", description="Operaciones relacionadas con los Usuarios")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente",
                    content = @Content(schema = @Schema(implementation = Usuario[].class))),
        @ApiResponse(responseCode = "204", description = "No hay usuarios registrados",
                    content = @Content)
    })
    public List<Usuario> ListaUsuarios(){
        return usuarioServicio.getUsuarios();
    }

    @PostMapping
    @Operation(summary="Agregar un Usuario", description="Operacion para agregar un Usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuario agregado exitosamente",
                    content = @Content(schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos",
                    content = @Content)
    })
    public Usuario agregarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.saveUsuarios(usuario); 
    }

    @GetMapping("/{id}")
    @Operation(summary="Buscar un Usuario", description="Operaciones para buscar un Usuario")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                    content = @Content(schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                    content = @Content)
    })
    public EntityModel<Usuario> buscUsuario(@PathVariable int id){
        Usuario usuario = usuarioServicio.getUsuarioId(id);
        
        EntityModel<Usuario> recurso = EntityModel.of(usuario);
        
        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).buscUsuario(id)).withSelfRel());
        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).ListaUsuarios()).withRel("listaUsuarios"));
        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).agregarUsuario(usuario)).withRel("agregarUsuario"));
        
        return recurso;
    }

    @PutMapping("/{id}")
    @Operation(summary="Actualizar los Usuarios", description="Operacion para actualizar los Usuarios")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario actualizado",
                    content = @Content(schema = @Schema(implementation = Usuario.class))),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                    content = @Content),
        @ApiResponse(responseCode = "400", description = "Datos inválidos",
                    content = @Content)
    })
    public Usuario actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        return usuarioServicio.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Eliminar los Usuarios", description="Operacion para eliminar los Usuarios")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario eliminado",
                    content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                    content = @Content)
    })
    public String eliminarUsuario(@PathVariable int id){
        return usuarioServicio.daleteUsuario(id);
    }
}
