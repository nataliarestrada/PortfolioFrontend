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
public class EducacionDto {
    
    private int personaId;
    private String tituloEdu;
    private String periodoEdu;
    private String institucionEdu;
    private String descripcionEdu;
    private String urlLogoEdu;

    public EducacionDto() {
    }

    public EducacionDto(int personaId, String tituloEdu, String periodoEdu, String institucionEdu, String descripcionEdu, String urlLogoEdu) {
        this.personaId = personaId;
        this.tituloEdu = tituloEdu;
        this.periodoEdu = periodoEdu;
        this.institucionEdu = institucionEdu;
        this.descripcionEdu = descripcionEdu;
        this.urlLogoEdu = urlLogoEdu;
    }
    
    
}
