/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.controladores;

import com.lp2.proyecto2.dao.TipoServicioDAO;
import com.lp2.proyecto2.modelo.TipoDeServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class TipoServicioController {
    @Autowired
    private TipoServicioDAO tsDao;
    
    @GetMapping("/manicure")
    public String mostrarTipos (Model model){
        
        List<TipoDeServicio> list = tsDao.findByIdServicio_IdServicio(2);
        model.addAttribute("listamanicure",list);
      
        return "/manicure";
    }
    
    @GetMapping("/tipos_servicio/{id}")
    public String mostrarTipos (Model model, @PathVariable("id") Integer id){
        
        List<TipoDeServicio> list = tsDao.findByIdServicio_IdServicio(id);
        model.addAttribute("listamanicure",list);
      
        return "/manicure";
    }
    
}
