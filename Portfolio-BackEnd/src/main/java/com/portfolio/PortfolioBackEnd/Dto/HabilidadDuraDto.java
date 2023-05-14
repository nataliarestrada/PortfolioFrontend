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
public class HabilidadDuraDto {
    
    private int personaId;
    private String nombreHD;
    private String porcentajeHD;

    public HabilidadDuraDto() {
    }

    public HabilidadDuraDto(int personaId, String nombreHD, String porcentajeHD) {
        this.personaId = personaId;
        this.nombreHD = nombreHD;
        this.porcentajeHD = porcentajeHD;
    }

    
}
