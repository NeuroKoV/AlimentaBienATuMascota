/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        var usuarios = usuarioDao.findAll();
        model.addAttribute("usuarios",usuarios);
        return "loginadmin";
    }
    
    @GetMapping("/crear")
    public String crear(){
        return "crear";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario ){
        usuarioDao.save(usuario);
        return "redirect:/loginadmin";
    }
}

