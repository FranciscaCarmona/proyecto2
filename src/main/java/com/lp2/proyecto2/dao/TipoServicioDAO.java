/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.dao;

import com.lp2.proyecto2.modelo.TipoDeServicio;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Francisca Carmona
 */
public interface TipoServicioDAO extends CrudRepository<TipoDeServicio, Integer> {

    @Override
    public List<TipoDeServicio> findAll();
    

  
    public List<TipoDeServicio> findByIdServicio_IdServicio(int id);
}
