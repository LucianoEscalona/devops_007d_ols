package devops.producto.test;

import devops.producto.entity.Producto;
import devops.producto.repository.ProductoRepository;
import devops.producto.service.ProductoService;

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
public class PruebasProducto {
    
    @Mock
    private ProductoRepository rep;

    @InjectMocks
    private ProductoService service;

    private Producto producto;

    @BeforeEach
    void preparar() {
        producto = new Producto(1, "Teclado", 15000, 10);
    }

    @Test
    void guardarProducto() {
        when(rep.save(producto)).thenReturn(producto);

        Producto resultado = service.p_guardar(producto);

        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNombre());
    }

    @Test
    void recuperarProductoExistente() {
        when(rep.findById(1)).thenReturn(Optional.of(producto));

        Producto resultado = service.p_recuperar(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
    }

    @Test
    void recuperarProductoInexistente() {
        when(rep.findById(99)).thenReturn(Optional.empty());

        Producto resultado = service.p_recuperar(99);

        assertNull(resultado);
    }

    @Test
    void listarProductos() {
        when(rep.findAll()).thenReturn(Arrays.asList(producto));

        var resultado = service.p_listar();

        assertEquals(1, resultado.size());
        assertEquals("Teclado", resultado.get(0).getNombre());
    }

    @Test
    void modificarProductoExistente() {
        Producto cambios = new Producto(1, "Mouse", 8000, 20);

        when(rep.findById(1)).thenReturn(Optional.of(producto));
        when(rep.save(producto)).thenReturn(producto);

        Producto resultado = service.p_modificar(cambios);

        assertNotNull(resultado);
        assertEquals("Mouse", resultado.getNombre());
        assertEquals(8000, resultado.getPrecio());
        assertEquals(20, resultado.getStock());
    }

    @Test
    void eliminarProducto() {
        Boolean resultado = service.p_eliminar(1);

        assertTrue(resultado);
        verify(rep).deleteById(1);
    }
}
