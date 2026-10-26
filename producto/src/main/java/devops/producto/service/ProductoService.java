package devops.producto.service;

import devops.producto.entity.Producto;
import devops.producto.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository rep;
    
    public Producto p_guardar(Producto p){
        return rep.save(p);
    };
    
    public Producto p_recuperar(Integer id){
        /*-LOGICA NEGOCIO-*/
        return rep.findById(id).orElse(null);
    };
    
    public List<Producto> p_listar(){
        /*-LOGICA NEGOCIO-*/
        return rep.findAll();
    };
    
    public Producto p_modificar(Producto p){
        /*-LOGICA NEGOCIO-*/
        Optional<Producto> p_opt = rep.findById(p.getId());
        
        if(p_opt.isPresent()){
            Producto p_mod = p_opt.get();
            p_mod.setNombre(p.getNombre());
            p_mod.setPrecio(p.getPrecio());
            p_mod.setStock(p.getStock());

            return rep.save(p_mod);
        }else{
            return null;
        }
    };
    
    public Boolean p_eliminar(Integer id){
        rep.deleteById(id);
        return true;
    };
}
