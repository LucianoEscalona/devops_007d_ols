package devops.usuario.test;

import devops.usuario.controller.UsuarioController;
import devops.usuario.entity.Usuario;
import devops.usuario.repository.UsuarioRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PruebasUsuario {
    
    @Mock
    private UsuarioRepository rep;
    @InjectMocks
    private UsuarioController ctrl;
    
    @DisplayName("Probamos que el controler llame al repositorio para recuperar un USUARIO")
    @Test
    public void ProbarGET(){
        Usuario u = new Usuario();
        u.setNombre("Pedro");
        
        when(rep.findById(1)).thenReturn(Optional.of(u));
        
        Usuario res = ctrl.uc_recuperar_nl(1);
        
        Assertions.assertEquals("Pedro", res.getNombre());
    }
    
    @DisplayName("Probamos que el controler llame al repositorio para modificar un USUARIO")
    @Test
    public void ProbarPUT(){
        Usuario u = new Usuario();
        u.setNombre("Pedro");
        
        Usuario d_nuevos = new Usuario();
        d_nuevos.setNombre("Juan");
        
        when(rep.findById(1)).thenReturn(Optional.of(u));
        when(rep.save(any(Usuario.class))).thenAnswer(i->i.getArgument(0));
        
        Usuario res = ctrl.uc_modificar(d_nuevos);
        
        Assertions.assertEquals("Juan", res.getNombre());
    }
    
    @DisplayName("Probamos que el controler llame al repositorio para eliminar un USUARIO")
    @Test
    public void ProbarDELETE(){
        when(rep.existsById(1)).thenReturn(true);
        Boolean res = ctrl.uc_eliminar(1);
        
        Assertions.assertEquals(true, res.booleanValue());
        
        verify(rep).deleteById(1);
    }
}
