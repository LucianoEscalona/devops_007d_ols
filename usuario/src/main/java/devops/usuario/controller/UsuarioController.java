package devops.usuario.controller;

import devops.usuario.entity.Usuario;
import devops.usuario.service.UsuarioService;
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
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    
    @Autowired
    private UsuarioService ser;
    
    @PostMapping("/register")
    public Usuario uc_guardar(@RequestBody Usuario u){
        return ser.u_guardar(u);
    };
    
    @PostMapping("/login")
    public Usuario uc_recuperar(@RequestBody Usuario u){
        return ser.u_recuperar(u);
    };
    
    @GetMapping("/get/{id}")
    public Usuario uc_recuperar_nl(@PathVariable Integer id){
        return ser.u_recuperar_nl(id);
    };
    
    @GetMapping("/list")
    public List<Usuario> uc_listar(){
        return ser.u_listar();
    };
    
    @PutMapping("/put")
    public Usuario uc_modificar(@RequestBody Usuario u){
        return ser.u_modificar(u);
    };
    
    @DeleteMapping("/delete/{id}")
    public Boolean uc_eliminar(@PathVariable Integer id){
        return ser.u_eliminar(id);
    };
}