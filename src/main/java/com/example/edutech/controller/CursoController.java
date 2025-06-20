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




@RestController
@RequestMapping("/api/v1/Cursos")
public class CursoController {
    @Autowired
    private CursoServicio cursoServicio;

    @GetMapping
    public List<Curso> listaCursos(){
        return cursoServicio.geCursos();
    }

    @PostMapping
    public Curso agregarCurso(@RequestBody Curso curso){
        return cursoServicio.saveCursos(curso);
    }

    @GetMapping("/{id}")
    public Curso buscCurso(@PathVariable int id){
        return cursoServicio.getCursoId(id);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable long id, @RequestBody Curso curso){
        return cursoServicio.updateCurso(curso);
    }

    @DeleteMapping("/{id}")
    public String eliminarCurso(@PathVariable int id){
        return cursoServicio.deleteCurso(id);
    }

    
    
    

    
    






}
