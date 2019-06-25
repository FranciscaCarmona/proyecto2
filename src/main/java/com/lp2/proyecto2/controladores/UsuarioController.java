/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.controladores;

import com.lp2.proyecto2.dao.UsuarioDAO;
import com.lp2.proyecto2.modelo.Usuario;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Francisca Carmona
 */
@Controller
public class UsuarioController {

    @Autowired
    UsuarioDAO uDAO;

    @GetMapping("/CrearUsuario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoUsuario", new Usuario()); //quiero enviar un usuario vacio a la vista (crear Usuario)
        return "/CrearUsuario";
    }

    @PostMapping("/CrearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {

        uDAO.save(usuario);
        return "/CrearUsuario";

    }

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("u", new Usuario());
        return "/index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute Usuario usuario, Model model, HttpServletResponse response) throws IOException {
        model.addAttribute("incorrecto", false);
        String email = usuario.getEmail();
        String password = usuario.getPassword();

        Optional<Usuario> optional = uDAO.findByEmail(email);
        if (optional.isPresent()) {
            Usuario usuarioBD = optional.get();
            
            response.sendRedirect("/Principal");
        } else {
            model.addAttribute("Incorrecto", true);
            
            return "/index";

        }

        return null;
    }

}
