package com.example.edutech.servicio;
import org.springframework.stereotype.Repository;
import com.example.edutech.modelo.Usuario;
    
import java.util.ArrayList;
import java.util.List;


@Repository
public class UsuarioServicio {

    //Arreglo para guargar Los Usuarios
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> obtenerUsuarios(){
        return listaUsuarios;
    }
    
    public Usuario busUsuario(int id){
        for (Usuario usuario: listaUsuarios){
            if (usuario.getId()== id){
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarporUsuario(String nombre){
        for (Usuario usuario: listaUsuarios){
            if (usuario.getNombre().equals(nombre)){
                return  usuario;
            }
        }
        return null;

    }

    public Usuario guardar(Usuario user){
        listaUsuarios.add(user);
        return user;
    }

    public Usuario actualizaUsuario(Usuario user){
        int idU = 0;
        int idUsuario = 0;

        for (int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getId() == user.getId()){
                idU = user.getId();
                idUsuario = I;
            }
        }

        Usuario usuario1 = new Usuario();
        usuario1.setId(idU);
        usuario1.setRol(user.getRol());
        usuario1.setNombre(user.getNombre());
        usuario1.setEmail(user.getEmail());

        listaUsuarios.set(idUsuario, usuario1);
        return usuario1;
    }

    public void eliminarUsuario(int idU){
        
        Usuario usuario = buscarporUsuario(nombre);
        if (usuario != null){
            listaUsuarios.remove(usuario);
        }

        int idUsuario = -1;
        for (int i = 0; i > listaUsuarios.size(); i++){
            if (listaUsuarios.get(i).getId()==idU){
                idUsuario=i;
                break;
            }
        }

        if (idUsuario >= 0){
            listaUsuarios.remove(idUsuario);
        }
    }


}
