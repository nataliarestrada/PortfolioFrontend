/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.PortfolioBackEnd.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author natal
 */
@Getter @Setter
public class ExperienciaDto {
    
    private int personaId;
    private String puestoExpe;
    private String periodoExpe;
    private String organismoExpe;
    private String descripcionExpe;
    private String urlLogoExpe;

    public ExperienciaDto() {
    }

    public ExperienciaDto(int personaId, String puestoExpe, String periodoExpe, String organismoExpe, String descripcionExpe, String urlLogoExpe) {
        this.personaId = personaId;
        this.puestoExpe = puestoExpe;
        this.periodoExpe = periodoExpe;
        this.organismoExpe = organismoExpe;
        this.descripcionExpe = descripcionExpe;
        this.urlLogoExpe = urlLogoExpe;
    }
    
    
}
