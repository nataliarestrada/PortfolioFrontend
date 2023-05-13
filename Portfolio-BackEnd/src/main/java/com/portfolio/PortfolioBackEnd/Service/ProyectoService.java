/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Service;

import com.portfolio.PortfolioBackEnd.Entity.Proyecto;
import com.portfolio.PortfolioBackEnd.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author natal
 */
@Service
@Transactional
public class ProyectoService {
    @Autowired
    ProyectoRepository rPro;
    
    public List<Proyecto> list() {
        return rPro.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return rPro.findById(id);
         
    }
    
    public void save(Proyecto pro) {
        rPro.save(pro);
    }

    public void delete(int id) {
        rPro.deleteById(id);
    }

    public boolean existsById(int id) {
        return rPro.existsById(id);
    }
}
