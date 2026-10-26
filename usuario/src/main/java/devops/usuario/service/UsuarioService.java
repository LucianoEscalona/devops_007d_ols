package devops.usuario.service;

import devops.usuario.entity.Usuario;
import devops.usuario.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository rep;
    
    public Usuario u_guardar(Usuario u){
        /*-LOGICA NEGOCIO-*/
        Optional<Usuario> u_opt = rep.findByCorreo(u.getCorreo());
        if(u_opt.isPresent()){
            return null;
        }else{
            return rep.save(u);
        }
    };
    
    public Usuario u_recuperar(Usuario u){
        /*-LOGICA NEGOCIO-*/
        List<Usuario> u_l = rep.findAll();
        for(Usuario us: u_l){
            if(us.getCorreo().equals(u.getCorreo())&&us.getContrasenia().equals(u.getContrasenia())){
                return rep.findByCorreo(u.getCorreo()).orElse(null);
            }
        }
        return null;
    };
    
    public Usuario u_recuperar_nl(Integer id){
        /*-LOGICA NEGOCIO-*/
        return rep.findById(id).orElse(null);
    };
    
    public List<Usuario> u_listar(){
        /*-LOGICA NEGOCIO-*/
        return rep.findAll();
    };
    
    public Usuario u_modificar(Usuario u){
        /*-LOGICA NEGOCIO-*/
        Optional<Usuario> u_opt = rep.findById(u.getId());
        
        if(u_opt.isPresent()){
            Usuario u_mod = u_opt.get();
            u_mod.setNombre(u.getNombre());
            u_mod.setApellido(u.getApellido());
            u_mod.setCorreo(u.getCorreo());
            u_mod.setContrasenia(u.getContrasenia());

            return rep.save(u_mod);
        }else{
            return null;
        }
    };
    
    public Boolean u_eliminar(Integer id){
        rep.deleteById(id);
        return true;
    };
}
