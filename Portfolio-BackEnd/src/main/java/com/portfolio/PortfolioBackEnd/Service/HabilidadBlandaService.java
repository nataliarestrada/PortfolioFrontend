/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Service;

import com.portfolio.PortfolioBackEnd.Entity.HabilidadesBlandas;
import com.portfolio.PortfolioBackEnd.Repository.HabilidadBlandaRepository;
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
public class HabilidadBlandaService {
    @Autowired
    HabilidadBlandaRepository rHB;
    
    public List<HabilidadesBlandas> list() {
        return rHB.findAll();
    }

    public Optional<HabilidadesBlandas> getOne(int id) {
        return rHB.findById(id);
         
    }
    
    public void save(HabilidadesBlandas hb) {
        rHB.save(hb);
    }

    public void delete(int id) {
        rHB.deleteById(id);
    }

    public boolean existsById(int id) {
        return rHB.existsById(id);
    }
}
