/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author natal
 */
@Entity
@Setter @Getter
public class HabilidadesDuras {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    private String nombreHD;
    private String porcentajeHD;

    public HabilidadesDuras() {
    }

    public HabilidadesDuras(Persona persona, String nombreHD, String porcentajeHD) {
        this.persona = persona;
        this.nombreHD = nombreHD;
        this.porcentajeHD = porcentajeHD;
    }
    
}
