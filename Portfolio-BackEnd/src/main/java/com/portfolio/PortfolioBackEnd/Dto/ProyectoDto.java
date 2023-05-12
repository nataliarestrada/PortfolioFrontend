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
@Setter @Getter
public class ProyectoDto {
    
    private int personaId;
    private String nombreProye;
    private String descripcionProye;
    private String imgUrl;
    private String repoUrl;

    public ProyectoDto() {
    }

    public ProyectoDto(int personaId, String nombreProye, String descripcionProye, String imgUrl, String repoUrl) {
        this.personaId = personaId;
        this.nombreProye = nombreProye;
        this.descripcionProye = descripcionProye;
        this.imgUrl = imgUrl;
        this.repoUrl = repoUrl;
    }
    
    
    
}
