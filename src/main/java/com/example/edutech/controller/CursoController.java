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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@RequestMapping("/api/v1/Cursos")
@Tag(name="Cursos", description="Operaciones relacionadas con los Cursos")
public class CursoController {
    @Autowired
    private CursoServicio cursoServicio;

    @GetMapping
    @Operation(summary="Lista de todos los Cursos", description="Operaciones relacionadas con los Cursos")
    public List<Curso> listaCursos(){
        return cursoServicio.geCursos();
    }

    @PostMapping
    @Operation(summary="Agregar un Curso", description="Operacion para agregar un Curso")
    public Curso agregarCurso(@RequestBody Curso curso){
        return cursoServicio.saveCursos(curso);
    }

    @GetMapping("/{id}")
    @Operation(summary="Buscar un Curso", description="Operaciones para buscar un Curso")
    public Curso buscCurso(@PathVariable int id){
        return cursoServicio.getCursoId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary="Actualizar los Cursos", description="Operacion para actualizar los Cursos")
    public Curso actualizarCurso(@PathVariable long id, @RequestBody Curso curso){
        return cursoServicio.updateCurso(curso);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Eliminar los Cursos", description="Operacion para eliminar los Cursos")
    public String eliminarCurso(@PathVariable int id){
        return cursoServicio.deleteCurso(id);
    }

    
    
    

    
    






}
