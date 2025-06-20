package com.example.edutech.servicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edutech.modelo.Curso;
import com.example.edutech.repositorio.RepositorioCurso;

@Service
public class CursoServicio {
    @Autowired
    private RepositorioCurso repositorioCurso;

    public List<Curso> geCursos(){
        return repositorioCurso.obtenerCurso();
    }

    public Curso saveCursos(Curso curso){
        return repositorioCurso.guarCurso(curso);
    }

    public Curso getCursoId(int id){
        return repositorioCurso.buscarIdCurso(id);
    }

    public Curso updateCurso(Curso curso){
        return repositorioCurso.actualizarCurso(curso);
    }

    public String deleteCurso(int idC){
        repositorioCurso.eliminar(idC);
        return "Curso Eliminado";
    }


}
