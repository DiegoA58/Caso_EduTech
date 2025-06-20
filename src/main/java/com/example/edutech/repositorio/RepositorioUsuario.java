package com.example.edutech.repositorio;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.edutech.modelo.Usuario;


@Repository
public class RepositorioUsuario {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> obtenerUsuarios(){
        return listaUsuarios;
    }

    public Usuario buscarIdUsuario(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId( )==id) {
                return usuario;

            }
                           
        }
        return null;
    }

    public Usuario buscarPorNombreUsuario(String nombre){
        for (Usuario usuario : listaUsuarios){
            if(usuario.getNombre().equals(nombre)){
                return usuario;
            }
        }
        return null;
    }

    public Usuario guarUsuario(Usuario user){
        listaUsuarios.add(user);
        return user;
    }

   
    public Usuario actualizarUsuario(Usuario user){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getId() == user.getId()){
                id = user.getId();
                idPosicion = i;
            }
        }

        Usuario usuario1 = new Usuario();
        usuario1.setId(id);
        usuario1.setRol(user.getRol());
        usuario1.setNombre(user.getNombre());
        usuario1.setEmail(user.getEmail());

        listaUsuarios.set(idPosicion, usuario1);
        return usuario1;
    }

    


    public void eliminar(int id){
        Usuario usuario = buscarIdUsuario(id);
        if (usuario != null){
            listaUsuarios.remove(usuario);

        }
    }

}
