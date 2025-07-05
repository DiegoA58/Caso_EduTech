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

import com.example.edutech.modelo.Curso;
import com.example.edutech.servicio.CursoServicio;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@RequestMapping("/api/v1/Cursos")
@Tag(name="Cursos", description="Operaciones relacionadas con los Cursos")
public class CursoController {
    @Autowired
    private CursoServicio cursoServicio;

    @GetMapping
    @Operation(summary="Lista de todos los Cursos", description="Operaciones relacionadas con los Cursos")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente",
                    content = @Content(schema = @Schema(implementation = Curso[].class))),
        @ApiResponse(responseCode = "204", description = "No hay cursos registrados",
                    content = @Content)
    })
    public List<Curso> listaCursos(){
        return cursoServicio.geCursos();
    }

    @PostMapping
    @Operation(summary="Agregar un Curso", description="Operacion para agregar un Curso")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Curso agregado exitosamente",
                    content = @Content(schema = @Schema(implementation = Curso.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos",
                    content = @Content)
    })
    public Curso agregarCurso(@RequestBody Curso curso){
        return cursoServicio.saveCursos(curso);
    }

    @GetMapping("/{id}")
    @Operation(summary="Buscar un Curso", description="Operaciones para buscar un Curso")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Curso encontrado",
                    content = @Content(schema = @Schema(implementation = Curso.class))),
        @ApiResponse(responseCode = "404", description = "Curso no encontrado",
                    content = @Content)
    })
    public Curso buscCurso(@PathVariable int id){
        return cursoServicio.getCursoId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary="Actualizar los Cursos", description="Operacion para actualizar los Cursos")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Curso actualizado",
                    content = @Content(schema = @Schema(implementation = Curso.class))),
        @ApiResponse(responseCode = "404", description = "Cursoo no encontrado",
                    content = @Content),
        @ApiResponse(responseCode = "400", description = "Datos inválidos",
                    content = @Content)
    })
    public Curso actualizarCurso(@PathVariable long id, @RequestBody Curso curso){
        return cursoServicio.updateCurso(curso);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Eliminar los Cursos", description="Operacion para eliminar los Cursos")
     @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Curso eliminado",
                    content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "404", description = "Curso no encontrado",
                    content = @Content)
    })
    public String eliminarCurso(@PathVariable int id){
        return cursoServicio.deleteCurso(id);
    }

    
    
    

    
    






}
