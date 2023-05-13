/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Service;

import com.portfolio.PortfolioBackEnd.Entity.Educacion;
import com.portfolio.PortfolioBackEnd.Repository.EducacionRepository;
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
public class EducacionService {
    @Autowired
    EducacionRepository rEdu;
    
     public List<Educacion> list() {
        return rEdu.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return rEdu.findById(id);
         
    }
    
    public void save(Educacion edu) {
        rEdu.save(edu);
    }

    public void delete(int id) {
        rEdu.deleteById(id);
    }

    public boolean existsById(int id) {
        return rEdu.existsById(id);
    }
}
