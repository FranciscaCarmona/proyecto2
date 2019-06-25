/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.controladores;

import com.lp2.proyecto2.dao.UsuarioDAO;
import com.lp2.proyecto2.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Francisca Carmona
 */
public class UsuarioController {
    @Autowired
    UsuarioDAO uDAO;
    
    @GetMapping("/CrearUsuario")
    public String mostrarFormulario(Model model){
        model.addAttribute("nuevoUsuario", new Usuario());  //quiero enviar un usuario vacio a la vista (crear Usuario)
        return "/CrearUsuario";
    }
    
    
    @PostMapping("/index")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        
        uDAO.save(usuario);
        return "/index";
        
    }   
//    @GetMapping("/index")
//    public String iniciarSesión(@ModelAttribute Usuario usuario){
//        uDAO.existsById(Integer.SIZE);
//                return"/Principal";
//    }
    @GetMapping("/index")
    public String login(Model model){
        model.addAttribute("eq", new Usuario());
        return "/index";
    }
    
    
    
    
    
}
