package devops.usuario.test;

import devops.usuario.service.UsuarioService;
import devops.usuario.entity.Usuario;
import devops.usuario.repository.UsuarioRepository;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PruebasUsuario {
    
    @Mock
    private UsuarioRepository rep;

    @InjectMocks
    private UsuarioService service;

    private Usuario usuario;

    @BeforeEach
    void preparar() {
        usuario = new Usuario(1, "Pedro", "Diaz", "correo@gmail.com","pass","normal");
    }

    @Test
    void guardarUsuario() {
        when(rep.save(usuario)).thenReturn(usuario);

        Usuario resultado = service.u_guardar(usuario);

        assertNotNull(resultado);
        assertEquals("Pedro", resultado.getNombre());
    }

    @Test
    void recuperarUsuarioExistente() {
        when(rep.findById(1)).thenReturn(Optional.of(usuario));

        Usuario resultado = service.u_recuperar_nl(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
    }

    @Test
    void recuperarUsuarioInexistente() {
        when(rep.findById(99)).thenReturn(Optional.empty());

        Usuario resultado = service.u_recuperar_nl(99);

        assertNull(resultado);
    }

    @Test
    void listarUsuarios() {
        when(rep.findAll()).thenReturn(Arrays.asList(usuario));

        var resultado = service.u_listar();

        assertEquals(1, resultado.size());
        assertEquals("Pedro", resultado.get(0).getNombre());
    }

    @Test
    void modificarUsuarioExistente() {
        Usuario cambios = new Usuario(1, "Roberto", "Gomez", "corre2o@gmail.com","word","admin");

        when(rep.findById(1)).thenReturn(Optional.of(usuario));
        when(rep.save(usuario)).thenReturn(usuario);

        Usuario resultado = service.u_modificar(cambios);

        assertNotNull(resultado);
        assertEquals("Roberto", resultado.getNombre());
        assertEquals("corre2o@gmail.com", resultado.getCorreo());
        assertEquals("word", resultado.getContrasenia());
    }

    @Test
    void eliminarProducto() {
        Boolean resultado = service.u_eliminar(1);

        assertTrue(resultado);
        verify(rep).deleteById(1);
    }
}
