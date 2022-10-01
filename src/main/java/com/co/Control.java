
package com.co;

import com.co.DAO.UsuarioDAO;
import com.co.pojo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class Control {
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    @GetMapping("/login")
    public String iniciosesion(){
        return "iniciosesion";
    }
    @GetMapping("/loginadmin")
    public String loginadmin(Model model){
        var usuarios= usuarioDao.findAll();
        model.addAttribute("usuarios",usuarios);
        return "loginadmin";
    }
    
    @GetMapping("/crear")
    public String crear(){
        return "crear";
    }
    
    @GetMapping("/productos")
    public String productos(){
        return "productos";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuarios){
        usuarioDao.save(usuarios);
        return "redirect:/loginadmin";
    }
    
       
}

