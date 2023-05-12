/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author natal
 */

@Entity
@Setter @Getter
public class Educacion {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    @Size(max = 500, message = "excedio la longitud")
    private String descripcionEdu;
    @Size(max = 500, message = "excedio la longitud")
    private String urlLogoEdu;

    public Educacion() {
    }

    public Educacion(Persona persona, String tituloEdu, String periodoEdu, String institucionEdu, String descripcionEdu, String urlLogoEdu) {
        this.persona = persona;
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.institucionEdu = institucionEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlLogoEdu = urlLogoEdu;
    }
    
    
}
