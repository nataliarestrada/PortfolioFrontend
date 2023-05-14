/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Service;

import com.portfolio.PortfolioBackEnd.Entity.HabilidadesDuras;
import com.portfolio.PortfolioBackEnd.Repository.HabilidadDuraRepository;
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
public class HabilidadDuraService {
    @Autowired
    HabilidadDuraRepository rHD;
    
    public List<HabilidadesDuras> list() {
        return rHD.findAll();
    }

    public Optional<HabilidadesDuras> getOne(int id) {
        return rHD.findById(id);
         
    }
    
    public void save(HabilidadesDuras hd) {
        rHD.save(hd);
    }

    public void delete(int id) {
        rHD.deleteById(id);
    }

    public boolean existsById(int id) {
        return rHD.existsById(id);
    }
}
