package com.example.edutech;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.edutech.controller.UsuarioController;
import com.example.edutech.modelo.Usuario;
import com.example.edutech.servicio.UsuarioServicio;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllertest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UsuarioServicio usuarioServicio;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerUsuario() throws Exception {
        // Configura el comportamiento del servicio
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Juan");
        usuario.setEmail("juan@example.com");

        when(usuarioServicio.getUsuarioId(1)).thenReturn(usuario);

        // Realiza la solicitud GET y verifica la respuesta
        mockMvc.perform(get("/api/v1/Usuarios/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.email").value("juan@example.com"));
    }

    @Test
    public void testAgregarUsuario() throws Exception {
        // Crea un nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("Pedro");
        nuevoUsuario.setEmail("pedro@example.com");

        // Simula el comportamiento del servicio
        when(usuarioServicio.saveUsuarios(any(Usuario.class))).thenReturn(nuevoUsuario);

        // Realiza la solicitud POST y verifica la respuesta
        mockMvc.perform(post("/api/v1/Usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Pedro\",\"email\":\"pedro@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Pedro"))
                .andExpect(jsonPath("$.email").value("pedro@example.com"));
    }

    @Test
    public void testObtenerUsuarios() throws Exception {
       
        Usuario usuario1 = new Usuario();
        usuario1.setId(1);
        usuario1.setNombre("Juan");
        usuario1.setEmail("juan@example.com");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setNombre("Pedro");
        usuario2.setEmail("pedro@example.com");

        when(usuarioServicio.getUsuarios()).thenReturn(List.of(usuario1, usuario2));

        
        mockMvc.perform(get("/api/v1/Usuarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Juan"))
                .andExpect(jsonPath("$[1].nombre").value("Pedro"));
    }
}
