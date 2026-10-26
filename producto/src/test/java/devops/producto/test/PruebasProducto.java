package devops.producto.test;

import devops.producto.controller.ProductoController;
import devops.producto.entity.Producto;
import devops.producto.repository.ProductoRepository;
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
public class PruebasProducto {
    
    @Mock
    private ProductoRepository rep;
    @InjectMocks
    private ProductoController ctrl;
    
    @DisplayName("Probamos que el controler llame al repositorio para recuperar un PRODUCTO")
    @Test
    public void ProbarGET(){
        Producto p = new Producto();
        p.setNombre("Tomate");
        
        when(rep.findById(1)).thenReturn(Optional.of(p));
        
        Producto res = ctrl.pc_recuperar(1);
        
        Assertions.assertEquals("Tomate", res.getNombre());
    }
    
    @DisplayName("Probamos que el controler llame al repositorio para modificar un PRODUCTO")
    @Test
    public void ProbarPUT(){
        Producto p = new Producto();
        p.setNombre("Tomate");
        
        Producto d_nuevos = new Producto();
        d_nuevos.setNombre("Cebolla");
        
        when(rep.findById(1)).thenReturn(Optional.of(p));
        when(rep.save(any(Producto.class))).thenAnswer(i->i.getArgument(0));
        
        Producto res = ctrl.pc_modificar(d_nuevos);
        
        Assertions.assertEquals("Cebolla", res.getNombre());
    }
    
    @DisplayName("Probamos que el controler llame al repositorio para eliminar un PRODUCTO")
    @Test
    public void ProbarDELETE(){
        when(rep.existsById(1)).thenReturn(true);
        Boolean res = ctrl.pc_eliminar(1);
        
        Assertions.assertEquals(true, res.booleanValue());
        
        verify(rep).deleteById(1);
    }
}
