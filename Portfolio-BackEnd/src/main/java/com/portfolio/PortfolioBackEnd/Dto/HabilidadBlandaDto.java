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
public class HabilidadBlandaDto {
    
    private int personaId;
    private String nombreHB;
    private String porcentajeHB;

    public HabilidadBlandaDto() {
    }

    public HabilidadBlandaDto(int personaId, String nombreHB, String porcentajeHB) {
        this.personaId = personaId;
        this.nombreHB = nombreHB;
        this.porcentajeHB = porcentajeHB;
    }
    
}
