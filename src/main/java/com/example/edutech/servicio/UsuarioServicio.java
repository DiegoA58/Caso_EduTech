package com.example.edutech.servicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edutech.modelo.Usuario;
import com.example.edutech.repositorio.RepositorioUsuario;

@Service

public class UsuarioServicio {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public List<Usuario> getUsuarios(){
        return repositorioUsuario.obtenerUsuarios();
    }

    public Usuario saveUsuarios(Usuario usuario){
        return repositorioUsuario.guarUsuario(usuario);

    }

    public Usuario getUsuarioId(int id){
        return repositorioUsuario.buscarIdUsuario(id);

    }

    public Usuario updateUsuario(Usuario usuario){
        return repositorioUsuario.actualizarUsuario(usuario);
    }

    public String daleteUsuario(int id){
        repositorioUsuario.eliminar(id);
        return "Usuario Eliminado";
    }

    


   


 

}
