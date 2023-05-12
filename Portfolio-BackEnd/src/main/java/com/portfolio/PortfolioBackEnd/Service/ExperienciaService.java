/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Service;

import com.portfolio.PortfolioBackEnd.Entity.Experiencia;
import com.portfolio.PortfolioBackEnd.Repository.ExperienciaRepository;
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
public class ExperienciaService {

    @Autowired
    ExperienciaRepository rExpe;

    public List<Experiencia> list() {
        return rExpe.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return rExpe.findById(id);
         
    }
    
    public void save(Experiencia expe) {
        rExpe.save(expe);
    }

    public void delete(int id) {
        rExpe.deleteById(id);
    }

    public boolean existsById(int id) {
        return rExpe.existsById(id);
    }
}