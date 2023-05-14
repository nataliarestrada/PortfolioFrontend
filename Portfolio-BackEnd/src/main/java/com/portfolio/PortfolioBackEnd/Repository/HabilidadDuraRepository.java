/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.PortfolioBackEnd.Entity.HabilidadesDuras;
import org.springframework.stereotype.Repository;

/**
 *
 * @author natal
 */
@Repository
public interface HabilidadDuraRepository extends JpaRepository<HabilidadesDuras, Integer>{
    
}
