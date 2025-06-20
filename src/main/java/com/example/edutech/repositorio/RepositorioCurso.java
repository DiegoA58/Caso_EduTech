package com.example.edutech.repositorio;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.edutech.modelo.Curso;




@Repository
public class RepositorioCurso {
    private List<Curso> listaCursos = new ArrayList<>();

    public List<Curso> obtenerCurso(){
        return listaCursos;
    }

    public Curso buscarIdCurso(int idC) {
        for (Curso curso : listaCursos) {
            if (curso.getIdC()==idC) {
                return curso;

            }                  
        }
        return null;
    }

    public Curso buscarPorNombreCurso(String nombreCurso){
        for (Curso curso : listaCursos){
            if(curso.getNombreCurso().equals(nombreCurso)){
                return curso;
            }
        }
        return null;
    }

    public Curso guarCurso(Curso cur){
        listaCursos.add(cur);
        return cur;
    }

    public Curso actualizarCurso(Curso cur){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaCursos.size(); i++){
            if(listaCursos.get(i).getIdC()==cur.getIdC()){
                id = cur.getIdC();
                idPosicion = i;
            }
        }

        Curso curso1 = new Curso();
        curso1.setIdC(id);
        curso1.setNombreCurso(cur.getNombreCurso());
        curso1.setDescrpCurso(cur.getDescrpCurso());
        curso1.setPrecioCurso(cur.getPrecioCurso());
        
        listaCursos.set(idPosicion, curso1);
        return curso1;        
    }

    public void eliminar(int idC){
        Curso curso = buscarIdCurso(idC);
        if(curso != null){
            listaCursos.remove(curso);
        }
    }
    

}
