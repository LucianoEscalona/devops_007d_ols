package devops.producto.controller;

import devops.producto.entity.Producto;
import devops.producto.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/producto")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
    
    @Autowired
    private ProductoService ser;
    
    @PostMapping("/post")
    public Producto pc_guardar(@RequestBody Producto p){
        return ser.p_guardar(p);
    };
    
    @GetMapping("/get/{id}")
    public Producto pc_recuperar(@PathVariable Integer id){
        return ser.p_recuperar(id);
    };
    
    @GetMapping("/list")
    public List<Producto> pc_listar(){
        return ser.p_listar();
    };
    
    @PutMapping("/put")
    public Producto pc_modificar(@RequestBody Producto p){
        return ser.p_modificar(p);
    };
    
    @DeleteMapping("/delete/{id}")
    public Boolean pc_eliminar(@PathVariable Integer id){
        return ser.p_eliminar(id);
    };
}
